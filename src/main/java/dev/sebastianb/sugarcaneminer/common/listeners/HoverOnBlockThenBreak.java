package dev.sebastianb.sugarcaneminer.common.listeners;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;

import net.minecraft.entity.player.EntityPlayer;

import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;


public class HoverOnBlockThenBreak {

    /**
     * Checks if player is inside sugarcane. I honestly didn't know what to name class / method
     */
    @SubscribeEvent
    public void playerInsideMyDick(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;
        if (event.player instanceof EntityPlayerSP) return;
        if (event.player instanceof EntityOtherPlayerMP) return;
        //check player location at head
        checkIfLookingAtCane(player);

    }





    private void checkIfLookingAtCane(EntityPlayer player) {
        try {
            World world = player.world;
            BlockPos lookingAt = Minecraft.getMinecraft().objectMouseOver.getBlockPos();

            if (lookingAt.getY() != player.getPosition().getY()) { return; }

            if (world.getBlockState(lookingAt).getBlock() == Blocks.REEDS) {
                Minecraft.getMinecraft().playerController.clickBlock(lookingAt, EnumFacing.NORTH);
            }

        } catch (NullPointerException ignored) {

        }

    }


}
