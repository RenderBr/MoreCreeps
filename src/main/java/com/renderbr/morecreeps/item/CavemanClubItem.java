package com.renderbr.morecreeps.item;

import com.renderbr.morecreeps.sounds.ModSounds;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

public class CavemanClubItem extends SwordItem {


    public CavemanClubItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
    @Override
    public boolean onLeftClickEntity(ItemStack stack, Player player, Entity entity)
    {
        if(Math.random() <= 0.25){
            if(entity instanceof Mob mob){
                mob.addEffect(new MobEffectInstance(MobEffect.byId(2), 5,2));
                mob.addEffect(new MobEffectInstance(MobEffect.byId(9), 15,2));
                mob.addEffect(new MobEffectInstance(MobEffect.byId(18), 15,1));
                player.playSound(ModSounds.CAVEMAN_DRUMS.get(), 1.0F, 1.0F);
            }
        }

        return false;
    }

}
