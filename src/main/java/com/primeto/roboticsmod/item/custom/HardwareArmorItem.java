package com.primeto.roboticsmod.item.custom;

import com.google.common.collect.ImmutableMap;
import com.primeto.roboticsmod.item.ModArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectUtils;
import net.minecraft.potion.Effects;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.item.GeoArmorItem;

import java.util.Map;
import java.util.logging.Level;

public class HardwareArmorItem extends GeoArmorItem implements IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);

    private static final ImmutableMap<ArmorMaterial, EffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, EffectInstance>())
                    .put(ModArmorMaterial.HARDWARE, new EffectInstance(Effects.LUCK, 200, 1)).build();

    public HardwareArmorItem(ArmorMaterial material, EquipmentSlotType slot, Properties settings) {
        super(material, slot, settings);
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController<HardwareArmorItem>(this, "controller",
                20, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    private <P extends IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        event.getController().setAnimation(new AnimationBuilder().addAnimation("idle", true));
        return PlayState.CONTINUE;
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, PlayerEntity player) {
        if(!world.isClientSide()) {
            if(hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }

    private void evaluateArmorEffects(PlayerEntity player) {
        for (ImmutableMap.Entry<ArmorMaterial, EffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            EffectInstance mapStatusEffect = entry.getValue();

            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);
            }
        }
    }

    private void addStatusEffectForMaterial(PlayerEntity player, ArmorMaterial mapArmorMaterial,
                                            EffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.getActivePotionEffect(mapStatusEffect.getPotion());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addPotionEffect(new EffectInstance(mapStatusEffect.getPotion(),
                    mapStatusEffect.getDuration(), mapStatusEffect.getAmplifier()));

            //if(new Random().nextFloat() > 0.6f) { // 40% of damaging the armor! Possibly!
            //    player.getInventory().hurtArmor(DamageSource.MAGIC, 1f, new int[]{0, 1, 2, 3});
            //}
        }
    }

    private boolean hasFullSuitOfArmorOn(PlayerEntity player) {
        ItemStack boots = player.inventory.armorItemInSlot(0);
        ItemStack leggings = player.inventory.armorItemInSlot(1);
        ItemStack breastplate = player.inventory.armorItemInSlot(2);
        ItemStack helmet = player.inventory.armorItemInSlot(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    private boolean hasCorrectArmorOn(ArmorMaterial material, PlayerEntity player) {
        for (ItemStack armorStack: player.inventory.armorInventory) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem)player.inventory.armorItemInSlot(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.inventory.armorItemInSlot(1).getItem());
        ArmorItem breastplate = ((ArmorItem)player.inventory.armorItemInSlot(2).getItem());
        ArmorItem helmet = ((ArmorItem)player.inventory.armorItemInSlot(3).getItem());

        return helmet.getArmorMaterial() == material && breastplate.getArmorMaterial() == material &&
                leggings.getArmorMaterial() == material && boots.getArmorMaterial() == material;
    }
}
