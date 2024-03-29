package com.theace.spongebob.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

public class Teleportation extends Item {
    public Teleportation(Properties p_41383_) {
        super(p_41383_);
    }
    public BlockPos blockPos;
    public Block blockType;
    public Player player;
    boolean clicked = false;
    @Override
    public InteractionResult useOn(UseOnContext pContext) {


        if(!pContext.getLevel().isClientSide() && pContext.getPlayer().isShiftKeyDown() == true){

            player = pContext.getPlayer();
            blockPos = pContext.getClickedPos();
            clicked = true;
            player.sendSystemMessage(Component.literal("Location Saved"));
        }
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                    player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;

    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {

        if(!level.isClientSide() &&  clicked == true){
            player.teleportTo(blockPos.getX(), blockPos.getY() + 1, blockPos.getZ());
            player.sendSystemMessage(Component.literal("Teleporting"));
            player.getCooldowns().addCooldown(this, 20);
        }

        return super.use(level, player, hand);
    }
}
