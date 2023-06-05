package com.theace.spongebob.item;

import com.theace.spongebob.SpongebobMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpongebobMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab AMOGUS_TAB;

    @SubscribeEvent
    public static void registerCreativeModTabs(CreativeModeTabEvent.Register event){
        AMOGUS_TAB = event.registerCreativeModeTab(new ResourceLocation(SpongebobMod.MOD_ID, "amogus_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItem.SPONGE.get()))
                        .title(Component.translatable("creativemodetab.amogus_tab")));
    }
}
