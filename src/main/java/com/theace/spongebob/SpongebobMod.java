package com.theace.spongebob;

import com.mojang.logging.LogUtils;
import com.theace.spongebob.item.ModCreativeModeTabs;
import com.theace.spongebob.item.ModItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
@Mod(SpongebobMod.MOD_ID)
public class SpongebobMod
{
    public static final String MOD_ID = "spongebob";

    private static final Logger LOGGER = LogUtils.getLogger();
    public SpongebobMod(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItem.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {

    }
    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if(event.getTab() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItem.SPONGE);
        }
        if(event.getTab() == ModCreativeModeTabs.AMOGUS_TAB){
            event.accept(ModItem.SPONGE);
        }
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}
