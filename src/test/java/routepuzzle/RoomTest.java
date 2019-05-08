package routepuzzle;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class RoomTest {

    @Test
    public void roomShouldHaveCorrectNeighboors() {
        Room room1 = new RoomBuilder().setId(1).setName("H").setNorth(2).setSouth(5).createRoom();
        Room room2 = new RoomBuilder().setId(2).setName("D").setWest(3).setEast(1).setSouth(4).createRoom();
        Room room3 = new RoomBuilder().setId(3).setName("K").setNorth(2).createRoom();
        Room room4 = new RoomBuilder().setId(4).setName("S").setNorth(2).createRoom();
        Room room5 = new RoomBuilder().setId(5).setName("L").setNorth(1).createRoom();

        Map<Integer, Room> roomMap = new HashMap<>();

        roomMap.put(1, room1);
        roomMap.put(2, room2);
        roomMap.put(3, room3);
        roomMap.put(4, room4);
        roomMap.put(5, room5);

        assertEquals("4,3,1",
                room2.getNeighboors(roomMap).stream().map(room -> room.getId().toString()).collect(Collectors.joining(",")));
    }
}
