package org.lecture.Person;

import org.lecture.Game.ColorText;

/**
 * The Farmer class represents a non-player character (NPC) in the game who is a farmer.
 * It extends the NPC class and implements the speak method to communicate with the player.
 */
public class Farmer extends NPC{
    @Override
    public void speak() {
        System.out.println(ColorText.GREEN_BOLD
                + "[Farmer]: "
                + ColorText.RESET_COLOR
                + "There was a good harvest last year...");
    }
}
