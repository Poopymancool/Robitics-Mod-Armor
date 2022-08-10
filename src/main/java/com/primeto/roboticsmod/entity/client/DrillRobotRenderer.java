package com.primeto.roboticsmod.entity.client;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.MatrixApplyingVertexBuilder;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.primeto.roboticsmod.RoboticsMod;
import net.minecraft.client.renderer.RenderType;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import com.primeto.roboticsmod.entity.custom.DrillRobotEntity;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;

public class DrillRobotRenderer extends GeoEntityRenderer<DrillRobotEntity> {


    public DrillRobotRenderer(EntityRendererManager renderManager) {
        super(renderManager, new DrillRobotModel());
        this.shadowSize = 0.5F;
    }



    @Override
    public ResourceLocation getEntityTexture(DrillRobotEntity instance) {
        return new ResourceLocation(RoboticsMod.MOD_ID, "textures/entity/drillrobot/drillrobot.png");
    }
    @Override
    public RenderType getRenderType(DrillRobotEntity animatable, float partialTicks, MatrixStack stack,
                                    IRenderTypeBuffer renderTypeBuffer, IVertexBuilder vertexBuilder,
                                    int packedLightIn, ResourceLocation textureLocation){
        stack.translate(0.6, 0.5, 0.6);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
