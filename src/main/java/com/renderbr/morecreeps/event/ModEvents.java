package com.renderbr.morecreeps.event;

import com.renderbr.morecreeps.MoreCreeps;
import com.renderbr.morecreeps.entity.ModEntityTypes;
import com.renderbr.morecreeps.entity.client.BulletModel;
import com.renderbr.morecreeps.entity.client.CamelJockeyModel;
import com.renderbr.morecreeps.entity.custom.BulletEntity;
import com.renderbr.morecreeps.entity.custom.CamelJockeyEntity;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

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
        }
        @SubscribeEvent
        public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event){
            event.registerLayerDefinition(BulletModel.LAYER_LOCATION, BulletModel::createBodyLayer);
            event.registerLayerDefinition(CamelJockeyModel.LAYER_LOCATION, CamelJockeyModel::createBodyLayer);
        }
    }

}
