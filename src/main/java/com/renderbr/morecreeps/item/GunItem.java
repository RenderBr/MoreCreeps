package com.renderbr.morecreeps.item;

import com.renderbr.morecreeps.entity.ModEntityTypes;
import com.renderbr.morecreeps.entity.custom.BulletEntity;
import com.renderbr.morecreeps.sounds.ModSounds;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ProjectileWeaponItem;
import net.minecraft.world.level.Level;

public class GunItem extends Item {

    public GunItem(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
            player.playSound(ModSounds.USE_GUN.get(), 1.0F, 1.0F);
            if(!world.isClientSide) {
                BulletEntity bullet = BulletEntity.create(player);
                bullet.tickCount = 35;
                bullet.shootFromRotation(player, player.getXRot(), player.getYRot(), 0F, 3F, 1.0F);
                world.addFreshEntity(bullet);
            }

        return super.use(world, player, hand);
    }

}
