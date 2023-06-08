package com.theace.spongebob.entity;

import com.theace.spongebob.SpongebobMod;
import com.theace.spongebob.entity.custom.SpongeEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntity {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, SpongebobMod.MOD_ID);

    public static final RegistryObject<EntityType<SpongeEntity>> SPONGEBOB =
            ENTITY_TYPES.register("spongebob", () -> EntityType.Builder.of(SpongeEntity::new , MobCategory.CREATURE)
                    .sized(1.4f,1.75f)
                    .build(new ResourceLocation(SpongebobMod.MOD_ID,"spongebob").toString()));


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
