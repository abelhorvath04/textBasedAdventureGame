package org.lecture.Room;

import lombok.EqualsAndHashCode;
import org.lecture.Game.ColorText;
import org.lecture.Game.GameDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The ConcreteRoomFactory class provides methods to create different types of rooms.
 */
@EqualsAndHashCode
public class ConcreteRoomFactory {

    /**
     * Creates a room of the specified type with the given next room.
     *
     * @param type     the type of room to create
     * @param nextRoom the next room connected to the created room
     * @return the created room
     */
    public Room createRoom(RoomType type, Room nextRoom) {
        switch (type) {
            case START:
                return new StartRoom(nextRoom);
            case END:
                return new EndRoom();
            case ORDINARY:
                return getOrdinaryRoom(nextRoom);
            case MAGIC:
                return new MagicRoom(nextRoom);
            case TRAP:
                return new TrapRoom(nextRoom);
            case TAVERN:
                return new Tavern(nextRoom);
            default:
                throw new IllegalArgumentException("Unknown type: " + type);
        }
    }

    /**
     * Creates an ordinary room with the specified number of people and villagers.
     *
     * @param nextRoom the next room connected to the created room
     * @return the created ordinary room
     */
    private static Room getOrdinaryRoom(Room nextRoom) {
        System.out.println(ColorText.YELLOW_BOLD
                + "How many people want you in the Ordinary room (between 0-20)? "
                + ColorText.RESET_COLOR);

        int peopleNumber;
        int villagerNumber;

        peopleNumber = GameDriver.scanner.nextInt();
        GameDriver.scanner.nextLine();

        while (peopleNumber > 20 || peopleNumber < 0) {
            System.out.println(ColorText.YELLOW_BOLD
                    + "Too much or minus? What are you up to?"
                    + ColorText.RESET_COLOR);
            peopleNumber = GameDriver.scanner.nextInt();
            GameDriver.scanner.nextLine();
        }

        System.out.println(ColorText.YELLOW_BOLD
                + "How many of them want you to be a villager?"
                + ColorText.RESET_COLOR);

        villagerNumber = GameDriver.scanner.nextInt();
        GameDriver.scanner.nextLine();

        while (villagerNumber > peopleNumber) {
            System.out.println(ColorText.YELLOW_BOLD
                    + "Waaas? Cannot be more than the people already here..."
                    + ColorText.RESET_COLOR);
            villagerNumber = GameDriver.scanner.nextInt();
            GameDriver.scanner.nextLine();
        }

        int farmerNumber = peopleNumber - villagerNumber;

        OrdinaryRoom ordinaryRoom = new OrdinaryRoom(nextRoom, villagerNumber, farmerNumber);

        return ordinaryRoom;
    }

    /**
     * Creates a list of rooms with the specified number of rooms.
     *
     * @param numberOfRooms the number of rooms to create
     * @return a list of rooms
     */
    public List<Room> createRoomList(int numberOfRooms) {
        List<Room> roomList = new ArrayList<>();
        Room room = createRoom(RoomType.END, null);

        roomList.add(createRoom(RoomType.START, room));
        for (int i = 0; i < numberOfRooms; i++) {
            int random = ThreadLocalRandom.current().nextInt(1, 22);
            if (random % 5 == 0) {
                roomList.add(createRoom(RoomType.MAGIC, room));
            } else if (random % 3 == 0) {
                roomList.add(createRoom(RoomType.ORDINARY, room));
            } else if (random % 4 == 0) {
                roomList.add(createRoom(RoomType.TAVERN, room));
            } else {
                roomList.add(createRoom(RoomType.TRAP, room));
            }
        }
        roomList.add(room);

        return roomList;
    }
}
