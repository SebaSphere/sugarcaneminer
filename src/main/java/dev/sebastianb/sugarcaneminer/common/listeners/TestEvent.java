package dev.sebastianb.sugarcaneminer.common.listeners;

import baritone.api.BaritoneAPI;
import baritone.api.pathing.goals.GoalXZ;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

public class TestEvent {


    @SubscribeEvent
    public void walk(PlayerEvent.PlayerLoggedInEvent event) {
        System.out.println("Joined");


        //well it does something different. Crashes this time
        BaritoneAPI.getProvider().getPrimaryBaritone().getCustomGoalProcess().setGoalAndPath(new GoalXZ(10000, 20000));

    }
}
