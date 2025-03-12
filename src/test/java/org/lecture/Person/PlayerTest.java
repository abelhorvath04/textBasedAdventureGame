package org.lecture.Person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {
    @Test
    public void notSurvivedRoomTest() {
        Player player = new Player();
        player.setName("Test_player");
        player.setHealthPoints(0);
        assertFalse(player.survivedRoom());
    }

    @Test
    public void successfullySurvivedRoomTest () {
        Player player = new Player();
        player.setName("Test_player");
        player.setHealthPoints(10);
        assertTrue(player.survivedRoom());
    }
}