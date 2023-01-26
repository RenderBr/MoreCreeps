package com.renderbr.morecreeps.entity.custom;

import com.renderbr.morecreeps.item.ModItems;
import com.renderbr.morecreeps.sounds.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.datafix.fixes.ItemIdFix;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.Tags;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.event.GeoRenderEvent;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.concurrent.ThreadLocalRandom;

public class LetterGEntity extends Monster implements GeoAnimatable {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);

    public LetterGEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.setSpeed(0.2f);
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource pSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pSource, pLooting, pRecentlyHit);

        ItemStack[] Drops = new ItemStack[]{
                Items.GRAVEL.getDefaultInstance(),
                Items.GLASS.getDefaultInstance(),
                Items.GOLD_BLOCK.getDefaultInstance(),
                Items.GLOWSTONE.getDefaultInstance(),
                Items.GLASS_PANE.getDefaultInstance(),
                Items.GOLD_INGOT.getDefaultInstance(),
                Items.GOLDEN_SWORD.getDefaultInstance(),
                Items.GOLDEN_AXE.getDefaultInstance(),
                Items.GOLDEN_PICKAXE.getDefaultInstance(),
                Items.GOLDEN_SHOVEL.getDefaultInstance(),
                Items.GUNPOWDER.getDefaultInstance(),
                Items.GOLDEN_HELMET.getDefaultInstance(),
                Items.GOLDEN_CHESTPLATE.getDefaultInstance(),
                Items.GOLDEN_LEGGINGS.getDefaultInstance(),
                Items.GOLDEN_BOOTS.getDefaultInstance(),
                Items.GOLDEN_APPLE.getDefaultInstance(),
                Items.GLOWSTONE_DUST.getDefaultInstance(),
                ModItems.GUN.get().getDefaultInstance()
        };

        int randomDrop = ThreadLocalRandom.current().nextInt(0, Drops.length);

        this.spawnAtLocation(Drops[randomDrop]);



    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.G_AMBIENT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.G_DEATH.get();
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, (double)0.1F).add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.ARMOR, 0.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {

    }
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
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
}
