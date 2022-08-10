package com.primeto.roboticsmod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {


    public static final ItemGroup ROBOTIC_GROUP = new ItemGroup("roboticModTab")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.HARDWARE.get());
        }
    };


}
