package org.lecture.Room;

import org.lecture.Game.ColorText;
import org.lecture.Game.GameDriver;
import org.lecture.Person.Player;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The TrapRoom class represents a room in the game containing a trap.
 * It extends the Room class and overrides the survivedRoom method to handle the trap event.
 */
public class TrapRoom extends Room {

    /**
     * Constructs a new TrapRoom object with the specified next room.
     *
     * @param nextRoom the next room connected to the trap room
     */
    public TrapRoom(Room nextRoom) {
        super(nextRoom);
    }

    /**
     * Overrides the survivedRoom method to handle the events that occur in the trap room.
     * The player falls through a trap door and encounters a puzzle set by a creature.
     *
     * @param player the player who falls into the trap room
     * @return true if the player survives the trap encounter, false otherwise
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    @Override
    public boolean survivedRoom(Player player) throws InterruptedException {
        System.out.println(ColorText.RED_BOLD
                + "[NARRATOR]: "
                + ColorText.RESET_COLOR
                + "You fell through a trap door in the trap room.");

        int randomNumber1 = ThreadLocalRandom.current().nextInt(1, 20);
        int randomNumber2 = ThreadLocalRandom.current().nextInt(1, 20);
        int result = randomNumber1 - randomNumber2;
        Thread.sleep(500);
        System.out.println(ColorText.YELLOW_BOLD
                + "[Zwerg]: "
                + ColorText.RESET_COLOR
                + "You again? I won't let you go until you solve this puzzle! [suddenly grows to 3 meters]");
        Thread.sleep(500);
        System.out.println(ColorText.YELLOW_BOLD
                + ColorText.YELLOW_BOLD
                + "[Zwerg]: "
                + ColorText.RESET_COLOR
                + "What is the result of this subtraction: "
                + ColorText.BLUE_BOLD + randomNumber1 + ColorText.RESET_COLOR
                + " - " + ColorText.BLUE_BOLD
                + randomNumber2 + ColorText.RESET_COLOR
                + "?");
        System.out.println(ColorText.RED_BOLD
                + "[NARRATOR]: "
                + ColorText.RESET_COLOR
                + "Write the result.");
        int playerResult = GameDriver.scanner.nextInt();
        GameDriver.scanner.nextLine();
        if (playerResult == result) {
            System.out.println(ColorText.YELLOW_BOLD
                    + "[Zwerg]: "
                    + ColorText.RESET_COLOR
                    + "Luck you have! Now go away... [it fades and disappears]");
        } else {
            System.out.println(ColorText.YELLOW_BOLD
                    + "[Zwerg]: "
                    + ColorText.RESET_COLOR
                    + "RUN!");
            Thread.sleep(500);
            System.out.println(ColorText.RED_BOLD
                    + "[NARRATOR]: "
                    + ColorText.RESET_COLOR
                    + "It bites you and you loose 5 HP.");
            int healthPoints = player.getHealthPoints();
            player.setHealthPoints(healthPoints - 5);
            if (player.getHealthPoints() <= 0) {
                System.out.println(ColorText.RED_BOLD
                        + "[NARRATOR]: "
                        + ColorText.RESET_COLOR
                        + "You died.");
                String tombStone = """
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠖⠲⢦⣄⡀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡼⠉⠓⠲⢦⠏⠀⢦⢠⣿⡟⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⡁⠳⡄⠱⣠⡀⡠⡀⠻⠿⢤⣀⡀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠓⢶⡄⣻⣿⣿⡝⣽⣧⣀⣾⣿⠂⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⡿⠁⠙⣿⣿⡟⠾⢿⣿⣽⠋⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠶⠚⠛⠛⠛⠓⠒⠲⠶⢤⣤⣄⣼⠁⠀⢠⣿⡿⠁⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡴⠿⢤⣗⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠿⣷⣾⣿⡁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⡟⠀⠀⠀⠙⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⣿⡳⢶⣄⡀⠀⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡞⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⠞⢻⣶⡺⣿⣦⡄⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡾⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⢹⡀⠘⢿⣿⣿⣿⣿⣆⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣼⠇⠀⠀⠀⣶⣶⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⠹⣝⣿⣟⢻⡆⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣸⠋⠀⠀⠀⣼⣿⣿⣿⡇⠀⢠⡟⡒⡆⠀⢠⣖⣶⣤⡀⠀⠀⠀⠀⢰⡇⠀⠈⡻⣿⣿⡇⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢠⠏⠀⠀⠀⣼⣹⣿⣿⠟⠁⠀⣼⢙⣿⠁⢠⡏⢹⣿⣿⣷⡄⠀⠀⠀⣼⢦⠀⠘⢞⣾⣿⡶⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⡎⠀⠀⠀⡜⢰⢋⡏⣿⠀⠀⢠⠇⣸⠃⠀⡞⢠⣿⣿⣷⠿⠃⠀⠀⢠⡇⢤⠣⣠⣴⣿⣿⣿⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⡸⠀⠀⠀⠈⠙⠋⠸⢷⣿⠀⠀⣾⣰⠇⠀⣸⣡⣼⠃⠀⠀⠀⠀⠀⠀⡾⢀⣠⣿⣿⢿⡛⢝⣿⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⢰⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⠋⠀⠀⠀⠀⠀⠀⣰⣇⣾⡿⡋⣉⠢⡙⢮⡏⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⣼⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣲⠋⢹⣍⢻⡀⢐⢌⠳⡌⢺⠇⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⢰⢿⡇⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠋⠁⣼⠀⠹⣿⣌⠻⡑⢬⣿⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⢀⡏⠘⠷⢶⡖⠈⠙⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠳⡀⠑⢤⡏⠙⢌⢺⣧⡙⢮⡲⡏⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⠀⡞⠀⠑⢄⠘⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠐⢄⠈⣶⣿⣇⠀⢄⠫⣿⢿⣦⢹⠃⠀⠀⠀⠀
                        ⠀⠀⠀⠀⠀⣼⠙⠢⡀⠀⠑⠈⠁⢀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⠠⠄⠙⣇⣿⠛⣷⣷⣿⡟⢄⠙⣾⠀⠀⠀⠀⠀
                        ⠀⠀⠀⠀⢰⠇⠀⠀⠈⠢⡑⢄⡐⠀⠑⠤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠢⡀⠈⠳⢀⣲⣿⡿⡀⣌⠻⣿⣿⡢⣽⡇⠀⠀⠀⠀⠀
                        ⢀⡤⠶⠶⢿⠤⠶⠤⢤⣤⣀⣀⡤⠖⠒⠒⠚⢦⣤⡀⢀⠀⠀⠀⠀⢀⡀⢌⠂⠀⢠⣿⣯⡀⠸⣮⡳⡘⢯⣿⡿⠀⠀⠀⠀⠀⠀
                        ⠀⠀⠠⠒⠛⠒⢤⡀⠃⠀⢀⣈⡿⢤⣀⢀⡠⠤⠧⣭⣠⠽⠶⠾⣭⡀⠉⠙⢷⣤⣸⣻⣅⠙⢷⣗⣝⣾⣦⣻⡷⠒⠒⠦⣤⠀⠀
                        ⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠀⠀⠀⠀⠉⠀⠀⠀⠀⠀⠀⠀⠊⠁⠀⠈⠉⠛⠞⠉⠀⠈⠉⠿⠋⠳⠦⠤⠒⠛⠛
                        """;
                System.out.println(ColorText.GREEN_BOLD + tombStone + ColorText.RESET_COLOR);
                Thread.sleep(1500);
                return false;
            }
        }
        return player.survivedRoom();
    }
}
