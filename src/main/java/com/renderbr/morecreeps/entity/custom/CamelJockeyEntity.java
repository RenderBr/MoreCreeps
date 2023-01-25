package com.renderbr.morecreeps.entity.custom;

import com.renderbr.morecreeps.entity.ModEntityTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

public class CamelJockeyEntity extends Monster {

    public CamelJockeyEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.rotate(Rotation.CLOCKWISE_90);

    }


    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, (double)0.5F).add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.ARMOR, 0.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }
}
