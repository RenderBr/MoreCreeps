package com.renderbr.morecreeps.item;

import com.renderbr.morecreeps.sounds.ModSounds;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class BlorpColaItem extends Item {
    public BlorpColaItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if(player.getHealth() < player.getMaxHealth()){
            player.heal(2);
            player.addEffect(new MobEffectInstance(MobEffect.byId(1), 100, 2));
            player.addEffect(new MobEffectInstance(MobEffect.byId(8), 100, 2));
            player.addEffect(new MobEffectInstance(MobEffect.byId(10), 5, 5));

            player.getItemInHand(hand).shrink(1);
            player.playSound(ModSounds.USE_BLORPCOLA.get(), 1.0F, 1.0F);
        }
        return super.use(world, player,hand);
    }
}
