package com.renderbr.morecreeps.entity.client;

import com.renderbr.morecreeps.MoreCreeps;
import com.renderbr.morecreeps.entity.custom.LetterGEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;

public class LetterGModel extends GeoModel<LetterGEntity> {


    @Override
    public ResourceLocation getModelResource(LetterGEntity animatable) {
        return new ResourceLocation(MoreCreeps.MODID, "geo/g.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(LetterGEntity animatable) {
        return new ResourceLocation(MoreCreeps.MODID, "textures/entity/g.png");
    }

    @Override
    public ResourceLocation getAnimationResource(LetterGEntity animatable) {
        return new ResourceLocation(MoreCreeps.MODID, "animations/g.animation.json");
    }
}
