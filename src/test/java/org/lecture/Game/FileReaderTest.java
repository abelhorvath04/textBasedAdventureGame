package org.lecture.Game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.lecture.Person.Player;

import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {
    @Test
    public void readNonExistingFile() {
        Player player_default = null;
        Path p = Paths.get("src", "test", "resources", "no_file.txt");
        Player player_readed = FileReader.fileReader(p);
        assertEquals(player_default, player_readed);
    }
    @Test
    public void readFile() {
        Player player_default = new Player();
        player_default.setName("Gandalf the grey");
        player_default.setHealthPoints(14);
        Path p = Paths.get("src", "test", "resources", "testGame.txt");
        Player player_readed = FileReader.fileReader(p);
        Assertions.assertEquals(player_readed, player_default);
    }
}