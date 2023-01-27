package com.renderbr.morecreeps.entity.custom;

import com.renderbr.morecreeps.entity.ModEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class RayEntity extends Projectile {
    public static RayEntity create(LivingEntity livingEntity){
        RayEntity bullet = new RayEntity(ModEntityTypes.RAY.get(), livingEntity.level);

        bullet.setOwner(livingEntity);
        bullet.setPos(livingEntity.getX(), livingEntity.getY() + (double)livingEntity.getEyeHeight() - 0.10000000149011612D, livingEntity.getZ());
        return bullet;
    }

    public RayEntity(EntityType<RayEntity> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    protected void onHitEntity(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        entity.hurt(DamageSource.thrown(this, this.getOwner()), 6.0F);
        entity.setSecondsOnFire(2);
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        super.onHitBlock(pResult);
        getCommandSenderWorld().getBlockState(pResult.getBlockPos()).getBlock().destroy(getCommandSenderWorld(), pResult.getBlockPos(), getCommandSenderWorld().getBlockState(pResult.getBlockPos()));
    }

    @Override
    public void tick() {
        super.tick();
        Vec3 vec3 = this.getDeltaMovement();
        HitResult hitresult = ProjectileUtil.getHitResult(this, this::canHitEntity);
        if (hitresult.getType() != HitResult.Type.MISS && !net.minecraftforge.event.ForgeEventFactory.onProjectileImpact(this, hitresult))
            this.onHit(hitresult);
        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        this.updateRotation();
        float f = 0.99F;
        float f1 = 0.06F;
        if (this.level.getBlockStates(this.getBoundingBox()).noneMatch(BlockBehaviour.BlockStateBase::isAir)) {
            this.discard();
        } else if (this.isInWaterOrBubble()) {
            this.discard();
        } else {
            this.setDeltaMovement(vec3.scale((double)0.99F));
            if (!this.isNoGravity()) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, (double)-0.06F, 0.0D));
            }

            this.setPos(d0, d1, d2);
        }
    }


    @Override
    protected void defineSynchedData() {

    }
}
