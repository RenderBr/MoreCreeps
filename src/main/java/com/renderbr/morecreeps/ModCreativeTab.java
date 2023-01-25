package com.renderbr.morecreeps;

import com.renderbr.morecreeps.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreCreeps.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeTab {
    public static CreativeModeTab MORE_CREEPS;

    @SubscribeEvent
   public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event)
   {
        MORE_CREEPS = event.registerCreativeModeTab(new ResourceLocation(MoreCreeps.MODID, "morecreeps"),
                builder -> builder.icon(() -> new ItemStack(ModItems.BLORP_COLA.get())).title(Component.literal("More Creeps & Weirdos Rebooted")).build());
   }
}
