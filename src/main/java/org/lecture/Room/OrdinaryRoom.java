package org.lecture.Room;

import org.lecture.Game.ColorText;
import org.lecture.Person.Farmer;
import org.lecture.Person.Player;
import org.lecture.Person.Villager;

/**
 * The OrdinaryRoom class represents a room in the game where the player encounters villagers and farmers.
 * It extends the Room class and overrides the survivedRoom method to handle the events in the ordinary room.
 */
public class OrdinaryRoom extends Room {
    private int villagerNumber;
    private int farmerNumber;

    /**
     * Constructs a new OrdinaryRoom object with the specified next room, number of villagers, and number of farmers.
     *
     * @param nextRoom       the next room connected to the ordinary room
     * @param villagerNumber the number of villagers in the room
     * @param farmerNumber   the number of farmers in the room
     */
    public OrdinaryRoom(Room nextRoom, int villagerNumber, int farmerNumber) {
        super(nextRoom);
        this.villagerNumber = villagerNumber;
        this.farmerNumber = farmerNumber;
    }


    /**
     * Overrides the survivedRoom method to handle the events in the ordinary room.
     * The player interacts with villagers and farmers, then continues their journey.
     *
     * @param player the player who enters the ordinary room
     * @return true if the player has survived, false otherwise
     * @throws InterruptedException if the thread is interrupted while waiting
     */
    @Override
    public boolean survivedRoom(Player player) throws InterruptedException {
        Thread.sleep(500);
        System.out.println(ColorText.RED_BOLD
                        + "[NARRATOR]: "
                        + ColorText.RESET_COLOR
                        + "You are in an ordinary room. Chill out a bit with the others.");
        Thread.sleep(1000);
        for (int i = 0; i < villagerNumber; i++) {
            Villager villager = new Villager();
            villager.speak();
        }
        for (int i = 0; i < farmerNumber; i++) {
            Farmer farmer = new Farmer();
            farmer.speak();
        }
        Thread.sleep(500);
        System.out.println(ColorText.RED_BOLD
                + "[NARRATOR]: "
                + ColorText.RESET_COLOR
                + "Onwards the journey goes...!");

        return player.survivedRoom();
    }
}
