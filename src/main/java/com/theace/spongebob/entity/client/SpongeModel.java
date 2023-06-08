package com.theace.spongebob.entity.client;

import com.theace.spongebob.SpongebobMod;
import com.theace.spongebob.entity.custom.SpongeEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.DataTicket;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class SpongeModel extends GeoModel<SpongeEntity> {
    @Override
    public ResourceLocation getModelResource(SpongeEntity animatable) {
        return new ResourceLocation(SpongebobMod.MOD_ID, "geo/spongebob.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(SpongeEntity animatable) {
        return new ResourceLocation(SpongebobMod.MOD_ID, "textures/entity/spongebob.png");
    }

    @Override
    public ResourceLocation getAnimationResource(SpongeEntity animatable) {
        return null;
    }

    @Override
    public void setCustomAnimations(SpongeEntity animatable, long instanceId, AnimationState<SpongeEntity> animationState){
        CoreGeoBone head = getAnimationProcessor().getBone("head");
        if(head != null){
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }
    }
}
