package com.renderbr.morecreeps.entity.custom;
import java.util.concurrent.ThreadLocalRandom;
import com.renderbr.morecreeps.sounds.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.fml.common.Mod;

public class ThiefEntity extends Monster {

    private boolean spotted = false;
    private boolean stoleItem = false;
    public static ItemStack stolenItem;

    public ThiefEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.addBehaviourGoals();
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.THIEF_AMBIENT.get();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.THIEF_HURT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.THIEF_DEATH.get();
    }

    protected void addBehaviourGoals() {
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(7, new RandomStrollGoal(this, 1.0D));
        this.targetSelector.addGoal(1, (new HurtByTargetGoal(this)).setAlertOthers(ZombifiedPiglin.class));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }

    @Override
    public boolean doHurtTarget(Entity pEntity) {

        boolean flag = super.doHurtTarget(pEntity);

        if (pEntity instanceof Player player) {
            if(stoleItem == false) {
                stolenItem = stealItem(player);
                if(stolenItem != ItemStack.EMPTY){
                    stoleItem = true;
                    this.playSound(ModSounds.THIEF_STEAL.get(), 1.0F, 1.0F);
                    this.setItemInHand(this.getUsedItemHand(), stolenItem);
                    this.targetSelector.addGoal(3, new AvoidEntityGoal<>(this, Player.class, 120.0F, 1.0D, 1.2D));

                }

            }
        }

            return flag;
    }

    public ItemStack stealItem(Player player){
        if(player.getInventory().isEmpty()){
            return ItemStack.EMPTY;
        }

        int randomSlot = ThreadLocalRandom.current().nextInt(0, 27);

        while(player.getInventory().getItem(randomSlot).isEmpty()){
            randomSlot = ThreadLocalRandom.current().nextInt(0, 27);
        }

        ItemStack slot = player.getInventory().getItem(randomSlot);
        ItemStack itemStolen = player.getInventory().getItem(randomSlot).copy();
        slot.shrink(slot.getCount());

        return itemStolen;
    }

    @Override
    protected void dropCustomDeathLoot(DamageSource pSource, int pLooting, boolean pRecentlyHit) {
        super.dropCustomDeathLoot(pSource, pLooting, pRecentlyHit);
        if(stoleItem == true){
            this.spawnAtLocation(stolenItem);
        }

    }

    public void baseTick() {
        super.baseTick();
        if(this.getTarget() instanceof Player && spotted == false){
            spotted = true;
            this.playSound(ModSounds.THIEF_SPOT_PLAYER.get(), 1.0F, 1.0F);
        }
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Monster.createMonsterAttributes().add(Attributes.MAX_HEALTH, 20).add(Attributes.FOLLOW_RANGE, 35.0D).add(Attributes.MOVEMENT_SPEED, (double)0.5F).add(Attributes.ATTACK_DAMAGE, 3.0D).add(Attributes.ARMOR, 0.0D).add(Attributes.SPAWN_REINFORCEMENTS_CHANCE);
    }
}
