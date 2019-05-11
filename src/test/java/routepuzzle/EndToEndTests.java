package routepuzzle;

import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class EndToEndTests {
    @Test
    public void loadRoomMapFromFileAndSolvePuzzle() throws IOException {
        RoomMapReader roomMapReader = new JSONRoomMapReader("map1.json");
        Map<Integer, Room> roomMap = roomMapReader.getRoomMap();
        Puzzle puzzle = new Puzzle(roomMap);
        puzzle.solveAndPrettyPrintMoves(roomMap.get(2), Arrays.asList(new Item("Knife"),
                new Item("Potted Plant")).stream().collect(Collectors.toSet()));
    }

    @Test
    public void loadRoomMap2FromFileAndSolvePuzzle() throws IOException {
        RoomMapReader roomMapReader = new JSONRoomMapReader("map2.json");
        Map<Integer, Room> roomMap = roomMapReader.getRoomMap();
        Puzzle puzzle = new Puzzle(roomMap);
        puzzle.solveAndPrettyPrintMoves(roomMap.get(4), Arrays.asList(new Item("Knife"),
                new Item("Potted Plant"), new Item("Pillow")).stream().collect(Collectors.toSet()));
    }
}
