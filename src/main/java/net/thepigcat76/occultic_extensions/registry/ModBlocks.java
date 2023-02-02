package net.thepigcat76.occultic_extensions.registry;

import com.github.klikli_dev.occultism.Occultism;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            Occultism.MODID);
    public static final Map<ResourceLocation, BlockDataGenSettings> BLOCK_DATA_GEN_SETTINGS = new HashMap<>();


    public static final RegistryObject<Block> OTHERSTONE_BRICK = register("otherstone_brick", () -> new Block(
            Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5f, 30)));
    //Components
    public static final RegistryObject<SlabBlock> OTHERSTONE_BRICK_SLAB = register("otherstone_brick_slab", () -> new SlabBlock(Block.Properties.of(Material.STONE).sound(SoundType.STONE).strength(1.5f, 30)));

    public static <I extends Block> RegistryObject<I> register(final String name, final Supplier<? extends I> sup) {
        return register(name, sup, true);
    }

    public static <I extends Block> RegistryObject<I> register(final String name, final Supplier<? extends I> sup, boolean generateDefaultBlockItem) {
        return register(name, sup, generateDefaultBlockItem, LootTableType.DROP_SELF);
    }

    public static <I extends Block> RegistryObject<I> register(final String name, final Supplier<? extends I> sup, boolean generateDefaultBlockItem, LootTableType lootTableType) {
        RegistryObject<I> object = BLOCKS.register(name, sup);
        BLOCK_DATA_GEN_SETTINGS.put(object.getId(), new BlockDataGenSettings(generateDefaultBlockItem, lootTableType));

        if (generateDefaultBlockItem) {
            ModItems.ITEMS.register(name, () -> new BlockItem(object.get(), new Item.Properties().tab(Occultism.ITEM_GROUP)));
        }

        return object;
    }

    public enum LootTableType {
        EMPTY,
        DROP_SELF,
        REPLANTABLE_CROP,
        OTHERWORLD_BLOCK,
        CUSTOM
    }

    public static class BlockDataGenSettings {
        public boolean generateDefaultBlockItem;
        public LootTableType lootTableType;

        public BlockDataGenSettings(boolean generateDefaultBlockItem,
                                    LootTableType lootTableType) {
            this.generateDefaultBlockItem = generateDefaultBlockItem;
            this.lootTableType = lootTableType;
        }
    }
}