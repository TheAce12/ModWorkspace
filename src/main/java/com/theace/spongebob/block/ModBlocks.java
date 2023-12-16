package com.theace.spongebob.block;

import com.theace.spongebob.SpongebobMod;
import com.theace.spongebob.item.ModItem;
import com.theace.spongebob.item.custom.CustomBlock;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, SpongebobMod.MOD_ID);

    public static final RegistryObject<Block> AMOGUS_BLOCK = registerBlock("amogus_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CUSTOM_BLOCK = registerBlock("custom_block",
            () -> new CustomBlock(BlockBehaviour.Properties.copy(Blocks.DIRT).strength(3f).requiresCorrectToolForDrops()));

    private  static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block){
        RegistryObject<T> toReturn = BLOCKS.register(name ,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block){
        return ModItem.ITEMS.register(name , () -> new BlockItem((block.get()), new Item.Properties()));
    }

    public static  void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
