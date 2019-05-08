package routepuzzle;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class JSONRoomMapReader implements RoomMapReader {
    private final Map<Integer, Room> roomMap;

    public JSONRoomMapReader(String fileName) throws IOException {
        InputStream in = getClass().getClassLoader().getResourceAsStream(fileName);
        String jsonString = readFromInputStream(in);
        List<JSONRoom> jsonRooms = new ObjectMapper().readValue(jsonString, JSONRooms.class).getRooms();
        List<Room> rooms = jsonRooms.stream().map(jsonRoom -> jsonRoom.convertToRoom()).collect(Collectors.toList());
        roomMap = rooms.stream().collect(Collectors.toMap(Room::getId, Function.identity()));
    }

    @Override
    public Map<Integer, Room> getRoomMap() {
        return roomMap;
    }

    private String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}
