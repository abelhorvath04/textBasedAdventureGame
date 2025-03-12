package org.lecture.Person;

import org.lecture.Game.ColorText;

/**
 * The Villager class represents a non-player character (NPC) in the game who is a villager.
 * It extends the NPC class and implements the speak method to communicate with the player.
 */
public class Villager extends NPC{
    @Override
    public void speak() {
        System.out.println(ColorText.GREEN_BOLD
                + "[Villager]: "
                + ColorText.RESET_COLOR
                + " Hier am Land ist doch zu ruhig...");
    }
}
