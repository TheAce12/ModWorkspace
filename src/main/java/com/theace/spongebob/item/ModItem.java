package com.theace.spongebob.item;

import com.theace.spongebob.SpongebobMod;
import com.theace.spongebob.entity.ModEntity;
import com.theace.spongebob.item.custom.Bomboclat;
import com.theace.spongebob.item.custom.Teleportation;
import com.theace.spongebob.item.custom.Yup;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItem {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, SpongebobMod.MOD_ID);

    public static  final RegistryObject<Item> SPONGE = ITEMS.register("sponge",
            () -> new Item(new Item.Properties()));

    public static  final RegistryObject<Item> DYING = ITEMS.register("dying",
            () -> new Yup(new Item.Properties()));
    public static  final RegistryObject<Item> INVINCIBLE = ITEMS.register("invincible",
            () -> new Bomboclat(new Item.Properties()));

    public static  final RegistryObject<Item> TELEPORTATION = ITEMS.register("tp_wand",
            () -> new Teleportation(new Item.Properties().durability(50)));

    public static  final RegistryObject<Item> SPAWN_EGG_SPONGE = ITEMS.register("sponge_spawn_egg",
            () -> new ForgeSpawnEggItem(ModEntity.SPONGEBOB, 0xD57E36, 0X1D0D00,new Item.Properties()));

    public static final RegistryObject<Item> CREWMATE = ITEMS.register("crewmate",
            ()-> new Item(new Item.Properties().food(Foods.CREWMATE)));
    public static final RegistryObject<Item> REDBULL = ITEMS.register("redbull",
            ()-> new Item(new Item.Properties().food(Foods.REDBULL)));


    public static class Foods{
        public  static  final FoodProperties CREWMATE = new FoodProperties.Builder()
                .nutrition(15)
                .saturationMod(.6f)
                .fast()
                .effect( () -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 600,5), 1f)
                .effect( () -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 600,5), 1f)
                .effect( () -> new MobEffectInstance(MobEffects.DOLPHINS_GRACE, 200,2), .5f)
                .build();

        public static final FoodProperties REDBULL = new FoodProperties.Builder()
                .nutrition(20)
                .saturationMod(.8f)
                .effect( () -> new MobEffectInstance(MobEffects.LEVITATION, 2400,1),1)
                .effect( () -> new MobEffectInstance(MobEffects.ABSORPTION, 2400, 100),1)
                .build();
    }
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
