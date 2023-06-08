package com.theace.spongebob.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.theace.spongebob.SpongebobMod;
import com.theace.spongebob.entity.custom.SpongeEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SpongeRenderer extends GeoEntityRenderer<SpongeEntity> {

    public SpongeRenderer(EntityRendererProvider.Context renderManagaer){
        super(renderManagaer, new SpongeModel());
    }

    @Override
    public ResourceLocation getTextureLocation(SpongeEntity animatable) {
        return new ResourceLocation(SpongebobMod.MOD_ID, "textures/entity/spongebob.png");
    }

    @Override
    public void render(SpongeEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {

        if(entity.isBaby()){
            poseStack.scale(0.4f,0.4f,0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
