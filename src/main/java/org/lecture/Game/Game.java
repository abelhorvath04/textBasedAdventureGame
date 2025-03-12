package org.lecture.Game;

import org.lecture.Person.Player;
import org.lecture.Room.ConcreteRoomFactory;
import org.lecture.Room.Room;

import java.util.List;

/**
 * The Game class represents the main game logic, allowing a player to go through a series of rooms.
 */
public class Game {

    /**
     * Starts the game for the given player. Asks the player to choose the number of rooms (between 3 and 10)
     * and then processes the player's journey through the rooms.
     *
     * @param player the player who will play the game
     * @throws InterruptedException if the thread is interrupted while the player is going through the rooms
     */
    public void playGame(Player player) throws InterruptedException {
        int roomNumber;
        ConcreteRoomFactory roomFactory = new ConcreteRoomFactory();

        System.out.println(ColorText.RED_BOLD
                + "[NARRATOR]: "
                + ColorText.RESET_COLOR
                + "How many rooms do you want? (between 3-10)");

        roomNumber = GameDriver.scanner.nextInt();
        GameDriver.scanner.nextLine();

        while (roomNumber > 10 || roomNumber < 3) {
            System.out.println(ColorText.RED_BOLD
                    + "[NARRATOR]: "
                    + ColorText.RESET_COLOR
                    + "Between three and ten!");
            roomNumber = GameDriver.scanner.nextInt();
            GameDriver.scanner.nextLine();
        }

        List<Room> roomlist = roomFactory.createRoomList(roomNumber);

        goThrough(roomlist, player);

    }

    /**
     * Processes the player's journey through the given list of rooms. The player proceeds through each room
     * until he/she either survive all the rooms or fail to survive a room.
     *
     * @param roomList the list of rooms the player will go through
     * @param player the player who will go through the rooms
     * @throws InterruptedException if the thread is interrupted while the player is going through the rooms
     */
    private void goThrough(List<Room> roomList, Player player) throws InterruptedException{
        for (Room room : roomList) {
            room.survivedRoom(player);
            if (!player.survivedRoom()) {
                break;
            }
        }

    }
}
