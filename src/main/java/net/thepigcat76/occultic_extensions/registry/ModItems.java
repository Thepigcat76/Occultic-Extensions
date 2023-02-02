package net.thepigcat76.occultic_extensions.registry;

import com.github.klikli_dev.occultism.Occultism;
import net.minecraft.world.item.*;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.thepigcat76.occultic_extensions.Occultic_extensions;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Occultic_extensions.MODID);

    public static final RegistryObject<Item> SILVER_SCEPTER = ITEMS.register("silver_scepter",
            () -> new Item(defaultProperties()));

    public static Item.Properties defaultProperties() {
        return new Item.Properties().tab(Occultism.ITEM_GROUP);
    }
}