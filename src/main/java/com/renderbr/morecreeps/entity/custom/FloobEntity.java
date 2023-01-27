package com.renderbr.morecreeps.entity.custom;

import com.renderbr.morecreeps.item.ModItems;
import com.renderbr.morecreeps.sounds.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.WorldGenLevel;
import org.lwjgl.system.Pointer;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;
import software.bernie.geckolib.core.animation.RawAnimation;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.concurrent.ThreadLocalRandom;

public class FloobEntity extends Monster implements GeoAnimatable, GeoEntity, RangedAttackMob {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    private static final RawAnimation IDLE_ANIM = RawAnimation.begin().thenPlay("idle");
    private static final RawAnimation ATTACK_ANIM = RawAnimation.begin().thenPlay("attack");
    public FloobEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setSpeed(0.2f);
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource pSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pSource, pLooting, pRecentlyHit);

        ItemStack[] Drops = new ItemStack[]{
                ModItems.RAYGUN.get().getDefaultInstance(),
        };

        int randomDrop = ThreadLocalRandom.current().nextInt(0, Drops.length);

        this.spawnAtLocation(Drops[randomDrop]);



    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.FLOOB_AMBIENT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.FLOOB_DEATH.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource){
        return ModSounds.FLOOB_HURT.get();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, (double)0.1F).add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.ARMOR, 0.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }



    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(
                new AnimationController<>(this, "idle", 5, state -> state.setAndContinue(DefaultAnimations.IDLE)),
                new AnimationController<>(this, "shoot", 5, state -> state.setAndContinue(ATTACK_ANIM)),
                new AnimationController<>(this, "attack", 5, state -> state.setAndContinue(ATTACK_ANIM)));


    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(2, new RangedAttackGoal(this, 1.0D, 20, 10.0F));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Player.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Mob.class, true));
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }

    @Override
    public double getTick(Object object) {
        return 0;
    }

    @Override
    public void performRangedAttack(LivingEntity pTarget, float pVelocity) {
        this.playSound(ModSounds.RAYGUN.get(), 1.0F, 1.0F);
            RayEntity beam = RayEntity.create(this);
            beam.tickCount = 35;

        double d0 = pTarget.getX() - this.getX();
        double d1 = pTarget.getY(0.3333333333333333D) - beam.getY();
        double d2 = pTarget.getZ() - this.getZ();
        double d3 = Math.sqrt(d0 * d0 + d2 * d2);
        beam.shoot(d0, d1 + d3 * (double)0.2F, d2, 1.6F, (float)(14 - this.level.getDifficulty().getId() * 4));
        this.level.addFreshEntity(beam);

    }
}
