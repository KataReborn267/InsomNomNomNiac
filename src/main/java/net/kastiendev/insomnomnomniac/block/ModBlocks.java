package net.kastiendev.insomnomnomniac.block;

import net.kastiendev.insomnomnomniac.InsomNomNomNiac;
import net.kastiendev.insomnomnomniac.item.ModCreativeModeTab;
import net.kastiendev.insomnomnomniac.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, InsomNomNomNiac.MOD_ID);

    public static final RegistryObject<Block> VIOLET_ORE = registerBlock("violet_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.INSOMNOMNOMNIAC_TAB);

    public static final RegistryObject<Block> GREEN_ORE = registerBlock("green_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.INSOMNOMNOMNIAC_TAB);

    public static final RegistryObject<Block> YELLOW_ORE = registerBlock("yellow_ore",
            () -> new DropExperienceBlock(Block.Properties.of(Material.STONE)
                    .strength(6f).requiresCorrectToolForDrops(),
                    UniformInt.of(3,7)), ModCreativeModeTab.INSOMNOMNOMNIAC_TAB);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
