package com.renderbr.morecreeps.entity.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.renderbr.morecreeps.MoreCreeps;
import com.renderbr.morecreeps.entity.custom.BulletEntity;
import com.renderbr.morecreeps.entity.custom.CamelJockeyEntity;
import com.renderbr.morecreeps.entity.custom.ThiefEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.lwjgl.opengl.GL11;

public class ThiefRenderer extends MobRenderer<ThiefEntity, ThiefModel> {
    public ThiefRenderer(EntityRendererProvider.Context context) {
        super(context, new ThiefModel(context.bakeLayer(ThiefModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    protected void scale(ThiefEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        super.scale(pLivingEntity, pMatrixStack, pPartialTickTime);
        pMatrixStack.scale(1F, 1F, 1F);
    }

    @Override
    public ResourceLocation getTextureLocation(ThiefEntity pEntity) {
        return new ResourceLocation(MoreCreeps.MODID, "textures/entity/thief.png");
    }

}
