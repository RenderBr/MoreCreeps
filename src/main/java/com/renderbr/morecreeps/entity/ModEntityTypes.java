package com.renderbr.morecreeps.entity;

import com.renderbr.morecreeps.MoreCreeps;
import com.renderbr.morecreeps.entity.custom.*;
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
                    .sized(1F, 1F)
                    .build(MoreCreeps.MODID + ":cameljockey"));

    public static final RegistryObject<EntityType<ThiefEntity>> THIEF = ENTITY_TYPES.register("thief",
            () -> EntityType.Builder.<ThiefEntity>of(ThiefEntity::new, MobCategory.MONSTER)
                    .sized(0.8F, 2F)
                    .build(MoreCreeps.MODID + ":thief"));

    public static final RegistryObject<EntityType<LetterGEntity>> LETTER_G = ENTITY_TYPES.register("letterg",
            () -> EntityType.Builder.<LetterGEntity>of(LetterGEntity::new, MobCategory.MONSTER)
                    .sized(1F, 2F)
                    .build(MoreCreeps.MODID + ":letterg"));

    public static final RegistryObject<EntityType<RayEntity>> RAY = ENTITY_TYPES.register("ray",
            () -> EntityType.Builder.<RayEntity>of(RayEntity::new, MobCategory.MISC)
                    .sized(1F, 2F)
                    .build(MoreCreeps.MODID + ":ray"));

    public static final RegistryObject<EntityType<FloobEntity>> FLOOB = ENTITY_TYPES.register("floob",
            () -> EntityType.Builder.<FloobEntity>of(FloobEntity::new, MobCategory.MONSTER)
                    .sized(1F, 2F)
                    .build(MoreCreeps.MODID + ":floob"));


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
