package com.primeto.roboticsmod.entity;

import com.primeto.roboticsmod.RoboticsMod;
import com.primeto.roboticsmod.entity.custom.DrillRobotEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, RoboticsMod.MOD_ID);

    public static final RegistryObject<EntityType<DrillRobotEntity>> DRILL_ROBOT =
            ENTITY_TYPES.register("drill_robot",
                    () -> EntityType.Builder.create(DrillRobotEntity::new,
                            EntityClassification.MONSTER).size(1f,2f)
                            .build(new ResourceLocation(RoboticsMod.MOD_ID, "drill_robot").toString()));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }



}
