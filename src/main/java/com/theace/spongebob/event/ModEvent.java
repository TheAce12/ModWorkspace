package com.theace.spongebob.event;

import com.theace.spongebob.SpongebobMod;
import com.theace.spongebob.entity.ModEntity;
import com.theace.spongebob.entity.custom.SpongeEntity;
import net.minecraft.world.entity.SpawnPlacements;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SpongebobMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEvent {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event){
        event.put(ModEntity.SPONGEBOB.get(), SpongeEntity.setAttributes());
    }

    /*@SubscribeEvent
    public static void  entitySpawnRestrictions(SpawnPlacementRegisterEvent event){
        event.register(ModEntity.SPONGEBOB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
                Animal::checkAnimalSpawnRules,SpawnPlacementRegisterEvent.Operation.REPLACE);
    }*/
}
