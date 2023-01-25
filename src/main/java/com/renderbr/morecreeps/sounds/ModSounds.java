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
    public static final RegistryObject<SoundEvent> USE_GUN = fireGun();

    public static RegistryObject<SoundEvent> fireGun(){
        switch(ThreadLocalRandom.current().nextInt(0,4)){
            case 0:
                return registerSoundEvent("bullet");
            default:
                return registerSoundEvent("bullet");
        }
    }

    public static RegistryObject<SoundEvent> registerSoundEvent(String name){
        return SOUNDS.register(name, () -> SoundEvent.createFixedRangeEvent(new ResourceLocation(MoreCreeps.MODID, name), 1.0F));
    }

    public static void register(IEventBus eventBus) {
        SOUNDS.register(eventBus);
    }

}
