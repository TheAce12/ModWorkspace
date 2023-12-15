package com.theace.spongebob.item.custom;

import com.theace.spongebob.item.ModItem;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.common.IPlantable;

public class CustomBlock extends Block {


    public CustomBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        if(entity instanceof LivingEntity livingEntity){
            livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,10));
        }

        super.stepOn(level, blockPos, blockState, entity);
    }
}
