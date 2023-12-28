package com.theace.spongebob.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class PortalGunBlock extends Block {
    public PortalGunBlock(Properties p_49795_) {
        super(p_49795_);
    }

    @Override
    public void stepOn(Level level, BlockPos blockPos, BlockState blockState, Entity entity) {
        if(entity instanceof LivingEntity livingEntity) {
            livingEntity.teleportTo(
                    blockPos.getX() / (level.getRandom().nextFloat() * 0.4F + 0.8F),
                    Math.abs(blockPos.getY() / (level.getRandom().nextFloat() * 0.4F + 0.8F)) + 5,
                    blockPos.getZ() / (level.getRandom().nextFloat() * 0.4F + 0.8F));

            level.destroyBlock(blockPos, true, entity);
        }

        super.stepOn(level, blockPos, blockState, entity);
    }
}
