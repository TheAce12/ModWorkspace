package com.theace.spongebob.enchantment;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ExplosionEnchantment extends Enchantment {
    protected ExplosionEnchantment(Rarity rarity, EnchantmentCategory enchantmentCategory, EquipmentSlot... equipmentSlot) {
        super(rarity, enchantmentCategory, equipmentSlot);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {

        if(!pAttacker.level().isClientSide()){
            ServerLevel world = ((ServerLevel) pAttacker.level());
            BlockPos pos = pTarget.blockPosition();

            if(pLevel == 1){
                EntityType.TNT.spawn(world, (ItemStack) null,null,pos, MobSpawnType.TRIGGERED,true,true);
            }

            if(pLevel == 2){
                EntityType.TNT.spawn(world, (ItemStack) null,null,pos, MobSpawnType.TRIGGERED,true,true);
                EntityType.TNT.spawn(world, (ItemStack) null,null,pos, MobSpawnType.TRIGGERED,true,true);
            }
        }

        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
}
