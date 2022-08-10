package com.primeto.roboticsmod.event;

import com.primeto.roboticsmod.RoboticsMod;
import com.primeto.roboticsmod.entity.ModEntityTypes;
import com.primeto.roboticsmod.entity.custom.DrillRobotEntity;
import com.primeto.roboticsmod.entity.custom.ModSpawnEggItem;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.entity.EntityType;

@Mod.EventBusSubscriber(modid = RoboticsMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event){
        event.put(ModEntityTypes.DRILL_ROBOT.get(), DrillRobotEntity.setCustomAttributes().create());
    }
    @SubscribeEvent
    public static void onRegisterEntities(RegistryEvent.Register<EntityType<?>> event){
        ModSpawnEggItem.initSpawnEggs();
    }
}
