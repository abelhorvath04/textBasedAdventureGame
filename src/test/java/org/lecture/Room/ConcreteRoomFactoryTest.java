package org.lecture.Room;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConcreteRoomFactoryTest {
    @Test
    public void createRoomTest() {
        StartRoom startRoom = new StartRoom(null);
        Room startRoomFromTest = new StartRoom(null);
        ConcreteRoomFactory roomFactory = new ConcreteRoomFactory();
        Room startRoomFromFactory = roomFactory.createRoom(RoomType.START, startRoom);
        assertEquals(startRoomFromFactory, startRoomFromTest);
    }

    @Test
    public void numberOfRoomsInTheRoomListTest() {
        ConcreteRoomFactory roomFactory = new ConcreteRoomFactory();
        List<Room> roomList = roomFactory.createRoomList(3);
        assertEquals(5, roomList.size());
    }
}