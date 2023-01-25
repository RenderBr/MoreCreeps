package com.renderbr.morecreeps.entity;

import com.renderbr.morecreeps.MoreCreeps;
import com.renderbr.morecreeps.entity.custom.BulletEntity;
import com.renderbr.morecreeps.entity.custom.CamelJockeyEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityTypes {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, MoreCreeps.MODID);

    public static final RegistryObject<EntityType<BulletEntity>> BULLET = ENTITY_TYPES.register("bullet",
            () -> EntityType.Builder.<BulletEntity>of(BulletEntity::new, MobCategory.MISC)
                    .sized(0.5F, 0.5F)
                    .build(MoreCreeps.MODID + ":bullet"));

    public static final RegistryObject<EntityType<CamelJockeyEntity>> CAMEL_JOCKEY = ENTITY_TYPES.register("cameljockey",
            () -> EntityType.Builder.<CamelJockeyEntity>of(CamelJockeyEntity::new, MobCategory.MONSTER)
                    .sized(0.3F, 0.3F)
                    .build(MoreCreeps.MODID + ":cameljockey"));

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
