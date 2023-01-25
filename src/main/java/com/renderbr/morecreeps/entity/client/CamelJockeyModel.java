// Made with Blockbench 4.6.1
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class CamelJockeyModel<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "cameljockeymodel"), "main");
	private final ModelPart body;

	public CamelJockeyModel(ModelPart root) {
		this.body = root.getChild("body");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition body = partdefinition.addOrReplaceChild("body", CubeListBuilder.create().texOffs(64, 0).addBox(-10.0F, -54.0F, -1.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(-10.0F, -54.0F, -1.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-1.0F, -12.0F, 3.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 32).addBox(-11.0F, -12.0F, 3.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(32, 32).addBox(-10.0F, -37.0F, 3.0F, 16.0F, 24.0F, 8.0F, new CubeDeformation(1.0F))
		.texOffs(80, 32).addBox(-19.0F, -37.0F, 3.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(80, 32).addBox(7.0F, -37.0F, 3.0F, 8.0F, 24.0F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 11.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 128, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}