package com.renderbr.morecreeps.item;

import com.renderbr.morecreeps.MoreCreeps;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, MoreCreeps.MODID);

    public static final RegistryObject<Item> BANDAID = ITEMS.register("bandaid", () -> new BandaidItem(new Item.Properties().requiredFeatures()));

    public static final RegistryObject<Item> GUN = ITEMS.register("gun", () -> new GunItem(new Item.Properties().requiredFeatures()));
    public static final RegistryObject<Item> BLORP_COLA = ITEMS.register("blorpcola", () -> new BlorpColaItem(new Item.Properties().requiredFeatures()));
    public static final RegistryObject<Item> CAVEMAN_CLUB = ITEMS.register("club", () -> new CavemanClubItem(Tiers.IRON, 6, -3.1F, new Item.Properties().requiredFeatures()));

    public static final RegistryObject<Item> RAYGUN = ITEMS.register("raygun", () -> new RaygunItem(new Item.Properties().requiredFeatures()));
    public static final RegistryObject<Item> RAY = ITEMS.register("ray", () -> new RayItem(new Item.Properties().requiredFeatures()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
