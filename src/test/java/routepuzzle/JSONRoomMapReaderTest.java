package routepuzzle;

import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class JSONRoomMapReaderTest {

    @Test
    public void getRoomMap() {

        JSONRoomMapReader roomMapReader = null;
        try {
            roomMapReader = new JSONRoomMapReader("map1.json");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<Integer, Room> roomMap = roomMapReader.getRoomMap();

        assertThat(roomMap).containsValues(
                        new RoomBuilder().setId(1)
                                .setName("Hallway")
                                .setNorth(2).createRoom(),
                        new RoomBuilder().setId(2)
                                .setName("Dining Room")
                                .setSouth(1)
                                .setWest(3)
                                .setEast(4).createRoom(),
                        new RoomBuilder().setId(3)
                                .setName("Kitchen")
                                .setEast(2)
                                .addItem("Knife".toLowerCase()).createRoom(),
                        new RoomBuilder().setId(4)
                                .setName("Sun Room")
                                .setWest(2)
                                .addItem("Potted Plant".toLowerCase()).createRoom());
    }
}
