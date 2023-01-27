package com.renderbr.morecreeps.event;

import com.renderbr.morecreeps.MoreCreeps;
import com.renderbr.morecreeps.entity.ModEntityTypes;
import com.renderbr.morecreeps.entity.client.*;
import com.renderbr.morecreeps.entity.custom.BulletEntity;
import com.renderbr.morecreeps.entity.custom.CamelJockeyEntity;
import com.renderbr.morecreeps.entity.custom.FloobEntity;
import com.renderbr.morecreeps.entity.custom.ThiefEntity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.joml.sampling.BestCandidateSampling;

import java.util.function.Supplier;

public class ModEvents {
    @Mod.EventBusSubscriber(modid = MoreCreeps.MODID)
    public static class ForgeEvents{

    }

    @Mod.EventBusSubscriber(modid = MoreCreeps.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ModEventBusEvents{
        public static void entityAttributeEvent(EntityAttributeCreationEvent event){

        }

        @SubscribeEvent
        public static void entityAttributes(EntityAttributeCreationEvent event){
            event.put(ModEntityTypes.CAMEL_JOCKEY.get(), CamelJockeyEntity.createAttributes().build());
            event.put(ModEntityTypes.THIEF.get(), ThiefEntity.createAttributes().build());
            event.put(ModEntityTypes.LETTER_G.get(), ThiefEntity.createAttributes().build());
            event.put(ModEntityTypes.FLOOB.get(), FloobEntity.createAttributes().build());

        }

        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
            event.registerLayerDefinition(BulletModel.LAYER_LOCATION, BulletModel::createBodyLayer);
            event.registerLayerDefinition(CamelJockeyModel.LAYER_LOCATION, CamelJockeyModel::createBodyLayer);
            event.registerLayerDefinition(ThiefModel.LAYER_LOCATION, ThiefModel::createBodyLayer);
            event.registerLayerDefinition(RayModel.LAYER_LOCATION, RayModel::createBodyLayer);


        }
    }

}
