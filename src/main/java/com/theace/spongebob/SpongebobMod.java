package com.theace.spongebob;

import com.mojang.logging.LogUtils;
import com.theace.spongebob.block.ModBlocks;
import com.theace.spongebob.entity.ModEntity;
import com.theace.spongebob.entity.client.SpongeRenderer;
import com.theace.spongebob.item.ModCreativeModeTabs;
import com.theace.spongebob.item.ModItem;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
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

        ModCreativeModeTabs.register(modEventBus);

        ModItem.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModEntity.register(modEventBus);

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {

    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS){
            event.accept(ModItem.SPONGE);
        }
        if(event.getTab() == ModCreativeModeTabs.AMOGUS_TAB.get()){
            event.accept(ModItem.SPONGE);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.accept(ModBlocks.AMOGUS_BLOCK);
        }
        if(event.getTab() == ModCreativeModeTabs.AMOGUS_TAB.get()){
            event.accept(ModBlocks.AMOGUS_BLOCK);
        }
        if(event.getTab() == ModCreativeModeTabs.AMOGUS_TAB.get()){
            event.accept(ModItem.CREWMATE);
        }
        if(event.getTab() == ModCreativeModeTabs.AMOGUS_TAB.get()){
            event.accept(ModItem.SPAWN_EGG_SPONGE);
        }
        if(event.getTabKey() == CreativeModeTabs.SPAWN_EGGS){
            event.accept(ModItem.SPAWN_EGG_SPONGE);
        }if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS){
            event.accept(ModItem.REDBULL);
        }if(event.getTab() == ModCreativeModeTabs.AMOGUS_TAB.get()){
            event.accept(ModItem.REDBULL);
        }if(event.getTab() == ModCreativeModeTabs.AMOGUS_TAB.get()){
            event.accept(ModItem.DYING);
        }if(event.getTab() == ModCreativeModeTabs.AMOGUS_TAB.get()) {
            event.accept(ModItem.INVINCIBLE);
        }if(event.getTab() == ModCreativeModeTabs.AMOGUS_TAB.get()) {
            event.accept(ModBlocks.CUSTOM_BLOCK);
        }if(event.getTab() == ModCreativeModeTabs.AMOGUS_TAB.get()) {
            event.accept(ModItem.TELEPORTATION);
        }
    }
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            EntityRenderers.register(ModEntity.SPONGEBOB.get(), SpongeRenderer::new);
        }
    }
}
