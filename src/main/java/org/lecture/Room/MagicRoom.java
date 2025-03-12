package org.lecture.Room;

import org.lecture.Game.ColorText;
import org.lecture.Game.GameDriver;
import org.lecture.Person.Player;

/**
 * The MagicRoom class represents a special room in the game where the player encounters a magician.
 * It extends the Room class and overrides the survivedRoom method to handle the events in the magic room.
 */
public class MagicRoom extends Room {

    /**
     * Constructs a new MagicRoom object with the specified next room.
     *
     * @param nextRoom the next room connected to the magic room
     */
    public MagicRoom(Room nextRoom) {
        super(nextRoom);
    }

    /**
     * Overrides the survivedRoom method to handle the events in the magic room.
     * The player interacts with the magician and their survival depends on the chosen magic spell.
     *
     * @param player the player who enters the magic room
     * @return true if the player has survived, false otherwise
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    @Override
    public boolean survivedRoom(Player player) throws InterruptedException {
        System.out.println(ColorText.RED_BOLD
                + "[NARRATOR]: "
                + ColorText.RESET_COLOR
                + "You entered the magic room.");
        Thread.sleep(500);
        String roomText = """
                This is the kingdom of the Great Magician, Venenosa Tenebrae!
                """;
        String magic = """
                (∩•̀ω•́)⊃-*⋆
                """;
        System.out.println(ColorText.YELLOW_BOLD
                + "[VENENOSA TENEBRAE]: "
                + ColorText.RESET_COLOR
                + roomText
                + ColorText.BLUE_BOLD + "Hope. "
                + ColorText.RESET_COLOR + ColorText.YELLOW_BOLD + "Magic. "
                + ColorText.RESET_COLOR + ColorText.GREEN_BOLD + "Madness. "
                + ColorText.RESET_COLOR + ColorText.RED_BOLD + "Fear. "
                + ColorText.RESET_COLOR + magic);
        System.out.println(ColorText.YELLOW_BOLD
                + "[VENENOSA TENEBRAE]: "
                + ColorText.RESET_COLOR
                + ColorText.YELLOW_BOLD
                + "Say a magic spell or you'll end up like... [she points to the skeletons]");
        String spell = GameDriver.scanner.nextLine();
        Thread.sleep(500);
        if (spell.length() == 0) {
            String wordsOfMagician = "RUN!";
            System.out.println(ColorText.YELLOW_BOLD
                    + "[VENENOSA TENEBRAE]: "
                    + ColorText.RESET_COLOR
                    + "Are you too scared? Then "
                    + ColorText.RED_BOLD
                    + wordsOfMagician
                    + ColorText.RESET_COLOR);
            Thread.sleep(500);
            System.out.println(ColorText.RED_BOLD
                    + "[NARRATOR]: "
                    + ColorText.RESET_COLOR
                    + "You ran away...");
        } else if (spell.length() < 10) {
            System.out.println(ColorText.YELLOW_BOLD
                    + "[VENENOSA TENEBRAE]: "
                    + ColorText.RESET_COLOR
                    + "I see you are not new to magic! But you still have to learn, now go in peace!");
            int healthPoints = player.getHealthPoints();
            player.setHealthPoints(healthPoints + 3);
            String nameOfMagician = "VENENOSA";
            Thread.sleep(500);
            System.out.println(ColorText.RED_BOLD
                    + "[NARRATOR]: "
                    + ColorText.RESET_COLOR
                    + "You earned 3 HP from "
                    + ColorText.BLUE_BOLD
                    + nameOfMagician
                    + ColorText.RESET_COLOR + ".");
            Thread.sleep(500);
            System.out.println(ColorText.RED_BOLD
                    + "[NARRATOR]: "
                    + ColorText.RESET_COLOR
                    + "Now, continue the journey!");
        } else {
            String wordsOfMagician = "OUCH! ";
            Thread.sleep(500);
            System.out.println(ColorText.YELLOW_BOLD
                    + "[VENENOSA TENEBRAE]: "
                    + ColorText.RESET_COLOR
                    + ColorText.BLUE_BOLD
                    + wordsOfMagician
                    + ColorText.RESET_COLOR
                    + "I better run! [runs away...]");
            int healthPoints = player.getHealthPoints();
            player.setHealthPoints(healthPoints + 5);
            Thread.sleep(500);
            System.out.println(ColorText.RED_BOLD
                    + "[NARRATOR]: "
                    + ColorText.RESET_COLOR
                    + "She ran away, you earned 5 HP!");
        }
        return player.survivedRoom();
    }
}
