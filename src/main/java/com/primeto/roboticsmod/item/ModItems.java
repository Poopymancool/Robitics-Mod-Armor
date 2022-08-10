package com.primeto.roboticsmod.item;

import com.primeto.roboticsmod.RoboticsMod;
import com.primeto.roboticsmod.entity.ModEntityTypes;
import com.primeto.roboticsmod.entity.custom.ModSpawnEggItem;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, RoboticsMod.MOD_ID);


    public static final RegistryObject<Item> HARDWARE = ITEMS.register("hardware",
            () -> new Item(new Item.Properties().group(ModItemGroup.ROBOTIC_GROUP)));

    public static final RegistryObject<Item> HARDWARE_SWORD = ITEMS.register("hardware_sword",
            () -> new SwordItem(ModItemTier.HARDWARE, 2, -2.7f,
                    new Item.Properties().group(ModItemGroup.ROBOTIC_GROUP)));
    public static final RegistryObject<Item> VIRUS_SWORD = ITEMS.register("virus_sword",
            () -> new VirusSwordItem(ModItemTier.HARDWARE, 2, -2.7f,
                    new Item.Properties().group(ModItemGroup.ROBOTIC_GROUP)));

    public static final RegistryObject<Item> HARDWARE_PICKAXE = ITEMS.register("hardware_pickaxe",
            () -> new PickaxeItem(ModItemTier.HARDWARE, -3, -2.8f,
                    new Item.Properties().group(ModItemGroup.ROBOTIC_GROUP)));

    public static final RegistryObject<Item> HARDWARE_SHOVEL = ITEMS.register("hardware_shovel",
            () -> new ShovelItem(ModItemTier.HARDWARE, -4, -1f,
                    new Item.Properties().group(ModItemGroup.ROBOTIC_GROUP)));

    public static final RegistryObject<Item> HARDWARE_AXE = ITEMS.register("hardware_axe",
            () -> new AxeItem(ModItemTier.HARDWARE, 4, -3f,
                    new Item.Properties().group(ModItemGroup.ROBOTIC_GROUP)));

    public static final RegistryObject<Item> HARDWARE_HOE = ITEMS.register("hardware_hoe",
            () -> new HoeItem(ModItemTier.HARDWARE, -4, 0f,
                    new Item.Properties().group(ModItemGroup.ROBOTIC_GROUP)));

    public static final RegistryObject<ModSpawnEggItem> DRILL_ROBOT_SPAWN_EGG = ITEMS.register("drill_robot_spawn_egg",
            () -> new ModSpawnEggItem(ModEntityTypes.DRILL_ROBOT, 0x948e8d, 0x3b3635,
                    new Item.Properties().group(ModItemGroup.ROBOTIC_GROUP)));













    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }



}
