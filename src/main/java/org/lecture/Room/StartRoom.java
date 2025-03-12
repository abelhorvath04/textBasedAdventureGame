package org.lecture.Room;

import lombok.EqualsAndHashCode;
import org.lecture.Game.ColorText;
import org.lecture.Person.Player;

/**
 * The StartRoom class represents the starting room in the game.
 * It extends the Room class and overrides the survivedRoom method to handle the events in the starting room.
 */
@EqualsAndHashCode
public class StartRoom extends Room {

    /**
     * Constructs a new StartRoom object with the specified next room.
     *
     * @param nextRoom the next room connected to the starting room
     */
    public StartRoom(Room nextRoom) {
        super(nextRoom);
    }

    /**
     * Overrides the survivedRoom method to handle the events in the starting room.
     * The player is welcomed to the game and encounters a peculiar creature.
     *
     * @param player the player who enters the starting room
     * @return true if the player has survived, false otherwise
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    @Override
    public boolean survivedRoom(Player player) throws InterruptedException {
        System.out.println(ColorText.RED_BOLD
                + "[NARRATOR]: "
                + ColorText.RESET_COLOR
                + "Welcome in the game, "
                + ColorText.RED_BOLD
                + player.getName()
                + ColorText.RESET_COLOR
                + "! You are in the start point.");
        Thread.sleep(1000);
        System.out.println(ColorText.YELLOW_BOLD
                + "[Zwerg]: "
                + ColorText.RESET_COLOR + "What are you doing here on this wasteland, "
                + player.getName()
                + "?"
                + " Don't be so surprised... I know everybody's name... [jumps away awkwardly]"
                + ColorText.RESET_COLOR);
        Thread.sleep(1000);
        System.out.println(ColorText.RED_BOLD
                + "[NARRATOR]: "
                + ColorText.RESET_COLOR
                + "You met with this weird creature. Forget 'bout it. Let's go on your journey!");
        Thread.sleep(1000);
        return player.survivedRoom();
    }
}
