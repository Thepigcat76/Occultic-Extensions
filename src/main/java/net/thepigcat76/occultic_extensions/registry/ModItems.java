package net.thepigcat76.occultic_extensions.registry;

import com.github.klikli_dev.occultism.Occultism;
import com.github.klikli_dev.occultism.common.OccultismCreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import static net.thepigcat76.occultic_extensions.Occultic_extensions.MODID;

public class ModItems {
    public static final DeferredRegister<Item> MOD_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> SILVER_SCEPTER = MOD_ITEMS.register("silver_scepter",
            () -> new Item(new Item.Properties().tab(Occultism.ITEM_GROUP)));

    public static void register(IEventBus eventBus) {
        MOD_ITEMS.register(eventBus);
    }
}
