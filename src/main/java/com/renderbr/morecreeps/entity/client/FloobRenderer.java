package com.renderbr.morecreeps.entity.client;

import com.renderbr.morecreeps.MoreCreeps;
import com.renderbr.morecreeps.entity.custom.FloobEntity;
import com.renderbr.morecreeps.entity.custom.LetterGEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class FloobRenderer extends GeoEntityRenderer<FloobEntity> {
    public FloobRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new FloobModel());
        this.shadowRadius = 0.3F;
    }

    @Override
    public ResourceLocation getTextureLocation(FloobEntity animatable) {
        return new ResourceLocation(MoreCreeps.MODID, "textures/entity/floob.png");
    }

    @Override
    public RenderType getRenderType(FloobEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
