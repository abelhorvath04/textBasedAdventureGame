package org.lecture.Room;

import org.lecture.Game.ColorText;
import org.lecture.Game.GameDriver;
import org.lecture.Person.Player;

import java.util.concurrent.ThreadLocalRandom;

/**
 * The Tavern class represents a tavern room in the game.
 * It extends the Room class and overrides the survivedRoom method to handle the events that occur in the tavern.
 */
public class Tavern extends Room {

    /**
     * Constructs a new Tavern object with the specified next room.
     *
     * @param nextRoom the next room connected to the tavern
     */
    public Tavern(Room nextRoom) {
        super(nextRoom);
    }

    /**
     * Overrides the survivedRoom method to handle the events that occur in the tavern.
     * The player enters the tavern and encounters two gangsters who challenge them to a dice game.
     *
     * @param player the player who enters the tavern
     * @return true if the player survives the tavern encounter, false otherwise
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    @Override
    public boolean survivedRoom(Player player) throws InterruptedException {
        String nameOfTavern = "The prancing pony";
        Thread.sleep(500);
        System.out.println(ColorText.RED_BOLD
                + "[NARRATOR]: "
                + ColorText.RESET_COLOR
                + "You entered into "
                + ColorText.GREEN_BOLD
                + nameOfTavern
                + ColorText.RESET_COLOR
                + ".");
        int randomNumber1 = ThreadLocalRandom.current().nextInt(1, 20);
        int randomNumber2 = ThreadLocalRandom.current().nextInt(1, 20);

        Thread.sleep(500);
        System.out.println(ColorText.RED_BOLD
                + "[NARRATOR]: "
                + ColorText.RESET_COLOR
                + "Two gangsters block the door");
        Thread.sleep(500);
        System.out.println(ColorText.YELLOW_BOLD
                + "[Mr. Underberg]: "
                + ColorText.RESET_COLOR
                + "Now, we play a game, foreigner! [laughs]");
        Thread.sleep(500);
        System.out.println(ColorText.YELLOW_BOLD
                + "[Mr. Underberg]: "
                + ColorText.RESET_COLOR
                + "We'll play a dice game... Roll it!");
        Thread.sleep(500);
        System.out.println(ColorText.RED_BOLD
                + "[NARRATOR]: "
                + ColorText.RESET_COLOR
                + "Write roll to roll the dice!");
        String userInputToRoll = GameDriver.scanner.nextLine();

        while (true) {
            if (userInputToRoll.equalsIgnoreCase("roll")) {
                Thread.sleep(500);
                System.out.println(ColorText.YELLOW_BOLD
                        + "[Mr. Underberg]: "
                        + ColorText.RESET_COLOR
                        + "Hahaha, this is: "
                        + ColorText.BLUE_BOLD
                        + randomNumber1
                        + ColorText.RESET_COLOR + " and mine is: " + ColorText.BLUE_BOLD
                        + randomNumber2
                        + ColorText.RESET_COLOR
                        + "!");
                break;
            } else {
                System.out.println(ColorText.RED_BOLD
                        + "[NARRATOR]: "
                        + ColorText.RESET_COLOR + "False input. Write roll to roll the dice");
                userInputToRoll = GameDriver.scanner.nextLine();
            }
        }

        if (randomNumber1 > randomNumber2) {
            Thread.sleep(500);
            System.out.println(ColorText.YELLOW_BOLD
                    + "[Mr. Underberg]: "
                    + ColorText.RESET_COLOR
                    + "Luck you have! Hahaha! Free to go! [the two gangsters open the door]");
            Thread.sleep(500);
            System.out.println(ColorText.RED_BOLD
                    + "[NARRATOR]: "
                    + ColorText.RESET_COLOR
                    + "You really had luck... Go away quickly!");
        } else {
            Thread.sleep(500);
            System.out.println(ColorText.YELLOW_BOLD
                    + "[Mr. Underberg]: "
                    + ColorText.RESET_COLOR
                    + "I always win... YOU HAVE TO DRINK THIS NOW!");
            Thread.sleep(500);
            System.out.println(ColorText.RED_BOLD
                    + "[NARRATOR]: "
                    + ColorText.RESET_COLOR
                    + "You drank the Dwarve's beer and... loose 3 health points...");
            Thread.sleep(500);
            int healthPoints = player.getHealthPoints();
            player.setHealthPoints(healthPoints - 3);
            if (player.getHealthPoints() <= 0) {
                System.out.println(ColorText.RED_BOLD
                        + "[NARRATOR]: "
                        + ColorText.RESET_COLOR
                        + "You died.");
                Thread.sleep(500);
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
