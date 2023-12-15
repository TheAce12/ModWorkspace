package com.theace.spongebob.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

public class Bomboclat extends Item {
    public Bomboclat(Properties p_41383_) {
        super(p_41383_);
    }

    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if(!level.isClientSide() && player.getBlockY() > 80 && !player.onGround()){

            player.setInvulnerable(true);
            player.sendSystemMessage(Component.literal("you are now invincible"));


        }else{
            player.setInvulnerable(false);
            player.sendSystemMessage(Component.literal("you are no longer invincible"));
        }

        return super.use(level, player, hand);
    }
}
