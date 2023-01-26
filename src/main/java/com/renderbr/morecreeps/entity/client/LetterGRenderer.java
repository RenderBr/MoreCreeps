package com.renderbr.morecreeps.entity.client;

import com.renderbr.morecreeps.MoreCreeps;
import com.renderbr.morecreeps.entity.custom.LetterGEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class LetterGRenderer extends GeoEntityRenderer<LetterGEntity> {
    public LetterGRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new LetterGModel());
        this.shadowRadius = 0.3F;
    }

    @Override
    public ResourceLocation getTextureLocation(LetterGEntity animatable) {
        return new ResourceLocation(MoreCreeps.MODID, "textures/entity/g.png");
    }

    @Override
    public RenderType getRenderType(LetterGEntity animatable, ResourceLocation texture, @Nullable MultiBufferSource bufferSource, float partialTick) {
        return super.getRenderType(animatable, texture, bufferSource, partialTick);
    }
}
