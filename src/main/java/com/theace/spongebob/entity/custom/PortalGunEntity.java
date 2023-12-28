package com.theace.spongebob.entity.custom;

import com.theace.spongebob.block.ModBlocks;
import com.theace.spongebob.block.custom.PortalGunBlock;
import com.theace.spongebob.entity.ModEntity;
import com.theace.spongebob.item.ModItem;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.ThrowableItemProjectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

public class PortalGunEntity extends ThrowableItemProjectile {
    public PortalGunEntity(EntityType<? extends ThrowableItemProjectile> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }

    public PortalGunEntity(Level pLevel) {
        super(ModEntity.PORTAL_GUN_ENTITY.get(),pLevel);
    }

    public PortalGunEntity(Level pLevel, LivingEntity livingEntity) {
        super(ModEntity.PORTAL_GUN_ENTITY.get(),livingEntity, pLevel);
    }


    @Override
    protected Item getDefaultItem() {
        return ModItem.PORTAL_GUN_PROJECTILE.get();
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if(!this.level().isClientSide()){
            this.level().broadcastEntityEvent(this, (byte) 3);
            this.level().setBlock(blockPosition(), ((PortalGunBlock) ModBlocks.PORTAL_GUN_BLOCK.get()).defaultBlockState(), 3);
        }
        this.discard();

        super.onHitBlock(pResult);
    }
}
