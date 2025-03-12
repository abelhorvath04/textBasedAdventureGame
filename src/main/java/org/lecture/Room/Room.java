package org.lecture.Room;

import lombok.Getter;
import lombok.Setter;
import org.lecture.Person.Player;

/**
 * The Room class represents a generic room in the game.
 * It is an abstract class that provides the basic structure for all types of rooms.
 */
@Getter
@Setter
public abstract class Room {
    private final Room nextRoom;

    /**
     * Constructs a new Room object with the specified next room.
     *
     * @param nextRoom the next room connected to this room
     */
    protected Room(Room nextRoom) {
        this.nextRoom = nextRoom;
    }


    public abstract boolean survivedRoom(Player player) throws InterruptedException;
}
