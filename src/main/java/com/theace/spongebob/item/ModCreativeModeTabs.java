package com.theace.spongebob.item;

import com.theace.spongebob.SpongebobMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;

import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.core.appender.DefaultErrorHandler;

@Mod.EventBusSubscriber(modid = SpongebobMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries
            .CREATIVE_MODE_TAB,
            SpongebobMod.MOD_ID);

    public static RegistryObject<CreativeModeTab> AMOGUS_TAB = CREATIVE_MODE_TABS.register("amogus_tab", () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItem.CREWMATE.get()))
            .title(Component.translatable("creativemodetab.amogus_tab")).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }

}
