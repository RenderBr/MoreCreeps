package com.renderbr.morecreeps.entity.client;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import com.renderbr.morecreeps.MoreCreeps;
import com.renderbr.morecreeps.entity.custom.BulletEntity;
import com.renderbr.morecreeps.entity.custom.CamelJockeyEntity;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.lwjgl.opengl.GL11;

public class CamelJockeyRenderer extends MobRenderer<CamelJockeyEntity, CamelJockeyModel> {
    public CamelJockeyRenderer(EntityRendererProvider.Context context) {
        super(context, new CamelJockeyModel(context.bakeLayer(CamelJockeyModel.LAYER_LOCATION)), 0.5F);
    }

    @Override
    protected void scale(CamelJockeyEntity pLivingEntity, PoseStack pMatrixStack, float pPartialTickTime) {
        super.scale(pLivingEntity, pMatrixStack, pPartialTickTime);
        pMatrixStack.scale(0.3F, 0.3F, 0.3F);
    }

    @Override
    public ResourceLocation getTextureLocation(CamelJockeyEntity pEntity) {
        return new ResourceLocation(MoreCreeps.MODID, "textures/entity/cameljockey.png");
    }

}
