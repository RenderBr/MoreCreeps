package com.renderbr.morecreeps.item;

import com.renderbr.morecreeps.sounds.ModSounds;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.sound.SoundEvent;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegistryObject;

import static com.renderbr.morecreeps.item.ModItems.BANDAID;
import static com.renderbr.morecreeps.item.ModItems.ITEMS;

public class BandaidItem extends Item {
    public BandaidItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        if(player.getHealth() < player.getMaxHealth()){
            player.heal(4);
            player.getItemInHand(hand).shrink(1);
            player.playSound(ModSounds.USE_BANDAID.get(), 1.0F, 1.0F);
        }
        return super.use(world, player,hand);
    }
}
