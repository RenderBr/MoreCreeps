package com.renderbr.morecreeps.entity.client;

import com.renderbr.morecreeps.MoreCreeps;
import com.renderbr.morecreeps.entity.custom.FloobEntity;
import com.renderbr.morecreeps.entity.custom.LetterGEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class FloobModel extends GeoModel<FloobEntity> {


    @Override
    public ResourceLocation getModelResource(FloobEntity animatable) {
        return new ResourceLocation(MoreCreeps.MODID, "geo/floob.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FloobEntity animatable) {
        return new ResourceLocation(MoreCreeps.MODID, "textures/entity/floob.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FloobEntity animatable) {
        return new ResourceLocation(MoreCreeps.MODID, "animations/floob.animation.json");
    }
}
