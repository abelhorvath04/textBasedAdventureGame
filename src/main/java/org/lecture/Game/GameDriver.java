package org.lecture.Game;

import org.lecture.Person.Player;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * The GameDriver class is the entry point of the game application. It displays the main menu and
 * handles user input to start the game, show a story, or quit the application.
 */
public class GameDriver {

    /**
     * A shared Scanner instance for reading user input in the whole game.
     */
    public static final Scanner scanner = new Scanner(System.in);

    /**
     * The main method which serves as the entry point of the application.
     *
     * @param args command line arguments
     * @throws InterruptedException if the thread is interrupted
     */
    public static void main(String[] args) throws InterruptedException {
        showMenu();
    }


    /**
     * Displays the main menu and processes user input. The user can choose to start the game, read a story,
     * or quit the application.
     *
     * @throws InterruptedException if the thread is interrupted
     */
    private static void showMenu() throws InterruptedException {

        boolean isRunning = true;
        while (isRunning) {
            String title = """
                                                      __ __                                                         \s
                     ____  _____ _____    _____ __   |__|__|_____ _____ _____ _____ _____    _____ _____ _____ _____\s
                    |    \\|   __| __  |  |   __|  |  |  _  |   __|   __| __  |   | |   __|  | __  |   __| __  |   __|
                    |  |  |   __|    -|  |  |  |  |__|     |__   |   __|    -| | | |   __|  | __ -|   __|    -|  |  |
                    |____/|_____|__|__|  |_____|_____|__|__|_____|_____|__|__|_|___|_____|  |_____|_____|__|__|_____|
                                                                                                                    \s                                                                                                    \s
                    """;

            System.out.println(ColorText.GREEN_BOLD + title + ColorText.RESET_COLOR);
            String menu = """
                    1 - Start Game
                    2 - Read a story
                                    
                    Q - quit
                    """;
            System.out.println(ColorText.BLUE_BOLD + menu + ColorText.RESET_COLOR);

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    startGame();
                    break;
                case "2":
                    System.out.println(showStory());
                    break;
                case "q", "Q":
                    System.out.println(ColorText.RED_BOLD
                            + "[NARRATOR]: "
                            + ColorText.RESET_COLOR
                            + ColorText.YELLOW_BOLD
                            + "Gott segne di!"
                            + ColorText.RESET_COLOR);
                    isRunning = false;
                    break;
                default:
                    System.out.println(ColorText.RED_BOLD + "Invalid input" + ColorText.RESET_COLOR);
            }
        }
    }

    /**
     * Starts the game by loading player data from a file and initiating the game sequence.
     *
     * @throws InterruptedException if the thread is interrupted
     */
    private static void startGame() throws InterruptedException {

        Path p = Paths.get("src", "main", "resources", "game.txt");

        Player player = FileReader.fileReader(p);

        Thread.sleep(500);
        String playerName;

        if (player.getName().isEmpty()) {
            System.out.println(ColorText.RED_BOLD
                    + "[NARRATOR]: "
                    + ColorText.RESET_COLOR
                    + ColorText.YELLOW_BOLD
                    + "Write your name: \n"
                    + ColorText.RESET_COLOR);
            do {
                System.out.println(ColorText.YELLOW_BOLD
                        + "[Zwerg]: "
                        + ColorText.RESET_COLOR
                        + "If you don't say anything, you'll never get out of here!");
                playerName = scanner.nextLine();
                player.setName(playerName);
            } while (player.getName().isEmpty());
        }

        String story_2 = """
                You will start your journey in the Start room! God helps you on your way,""";

        Thread.sleep(500);
        System.out.println(ColorText.RED_BOLD
                + "[NARRATOR]: "
                + ColorText.RESET_COLOR
                + story_2 + " "
                + ColorText.RED_BOLD
                + player.getName()
                + ColorText.RESET_COLOR + "!");

        Thread.sleep(1000);

        Game game = new Game();
        game.playGame(player);
    }

    /**
     * Displays a short story to the user.
     *
     * @return
     */
    protected static String showStory() {
        String story = """
                A oama Bua suacht's Glück. Er findt'n Weg übern Glasberg, besiegt an Drachen und befreit a Prinzessin. \s
                De leb'n glücklich bis ans End.""";
        System.out.println(ColorText.RED_BOLD
                + "[NARRATOR]: "
                + ColorText.RESET_COLOR + ColorText.YELLOW_BOLD + story + ColorText.RESET_COLOR);
        return story;
    }
}