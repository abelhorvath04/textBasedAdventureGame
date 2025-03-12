package org.lecture.Game;

import org.lecture.Person.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * The FileReader class provides a method to read player data from a file.
 */
public class FileReader {

    /**
     * Reads player data from the specified file path. If the file does not exist or an error occurs
     * during reading, the method returns null. Otherwise, it returns a Player object with the data
     * read from the file.
     *
     * @param p the path to the file containing player data
     * @return a Player object with the data read from the file, or null if an error occurs
     */
    public static Player fileReader(Path p) {

        Player player = new Player();

        if (Files.notExists(p)) {
            System.err.println("Path not found " + p);
            return null;
        }

        try (BufferedReader br = Files.newBufferedReader(p)) {

            String line;

            br.readLine(); // Skip the first line

            while ((line = br.readLine()) != null) {
                String[] split = line.split(";");
                player.setName(split[0]);
                player.setHealthPoints(Integer.parseInt(split[1]));
            }

            System.out.println(org.lecture.Game.ColorText.YELLOW_BOLD +
                    "Loading..." + org.lecture.Game.ColorText.RESET_COLOR);
            return player;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
