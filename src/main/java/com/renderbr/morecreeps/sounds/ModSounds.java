package com.renderbr.morecreeps.sounds;

import com.renderbr.morecreeps.MoreCreeps;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.concurrent.ThreadLocalRandom;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MoreCreeps.MODID);

    public static final RegistryObject<SoundEvent> USE_BANDAID = registerSoundEvent("use_bandaid");

    public static final RegistryObject<SoundEvent> USE_BLORPCOLA = registerSoundEvent("blorpcola");

    public static final RegistryObject<SoundEvent> USE_GUN = registerSoundEvent("bullet");
    public static final RegistryObject<SoundEvent> JOCKEY_DEATH = registerSoundEvent("jockey_death");

    public static final RegistryObject<SoundEvent> JOCKEY_HURT = registerSoundEvent("jockey_hurt");

    public static final RegistryObject<SoundEvent> JOCKEY_AMBIENT = registerSoundEvent("jockey_ambient");


    public static final RegistryObject<SoundEvent> CAVEMAN_DRUMS = registerSoundEvent("cavedrums");

    public static final RegistryObject<SoundEvent> THIEF_STEAL = registerSoundEvent("thief_steal");
    public static final RegistryObject<SoundEvent> THIEF_DEATH = registerSoundEvent("thief_death");
    public static final RegistryObject<SoundEvent> THIEF_HURT = registerSoundEvent("thief_hurt");

    public static final RegistryObject<SoundEvent> THIEF_AMBIENT = registerSoundEvent("thief_nearby");

    public static final RegistryObject<SoundEvent> G_AMBIENT = registerSoundEvent("g_ambient");

    public static final RegistryObject<SoundEvent> G_DEATH = registerSoundEvent("g_death");

    public static final RegistryObject<SoundEvent> THIEF_SPOT_PLAYER = registerSoundEvent("thief_spotted");


    public static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUNDS.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(MoreCreeps.MODID, name)));
    }

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }

}
