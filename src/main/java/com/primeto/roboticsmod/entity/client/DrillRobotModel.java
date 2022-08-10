package com.primeto.roboticsmod.entity.client;

import com.primeto.roboticsmod.RoboticsMod;
import com.primeto.roboticsmod.entity.custom.DrillRobotEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DrillRobotModel<T extends DrillRobotEntity> extends AnimatedGeoModel<T> {
    @Override
    public ResourceLocation getModelLocation(DrillRobotEntity object) {
        return new ResourceLocation(RoboticsMod.MOD_ID, "geo/drillrobot.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(DrillRobotEntity object) {
        return new ResourceLocation(RoboticsMod.MOD_ID, "textures/entity/drillrobot/Drill Robot.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(DrillRobotEntity animatable) {
        return new ResourceLocation(RoboticsMod.MOD_ID, "animations/drillrobot.animation.json");
    }
}
