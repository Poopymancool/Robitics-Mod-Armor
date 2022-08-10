package com.primeto.roboticsmod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.IItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class VirusSwordItem extends SwordItem {


    public VirusSwordItem(IItemTier p_i48460_1_, int p_i48460_2_, float p_i48460_3_, Properties p_i48460_4_) {
        super(p_i48460_1_, p_i48460_2_, p_i48460_3_, p_i48460_4_);
    }

    @Override
    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Here we can add effects on hit with this weapon to the target
        attacker.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 60));
        target.addPotionEffect(new EffectInstance(Effects.POISON, 200, 2));
        return super.hitEntity(stack, target, attacker);
    }
}
