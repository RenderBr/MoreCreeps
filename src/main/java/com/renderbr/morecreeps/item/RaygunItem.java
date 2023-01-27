package com.renderbr.morecreeps.item;

import com.renderbr.morecreeps.entity.custom.BulletEntity;
import com.renderbr.morecreeps.entity.custom.RayEntity;
import com.renderbr.morecreeps.sounds.ModSounds;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class RaygunItem extends Item {

    public RaygunItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
            player.playSound(ModSounds.RAYGUN.get(), 1.0F, 1.0F);
            if(!world.isClientSide) {
                RayEntity beam = RayEntity.create(player);
                beam.tickCount = 35;
                beam.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 5F, 1F);
                world.addFreshEntity(beam);
            }

        return super.use(world, player, hand);
    }

}
