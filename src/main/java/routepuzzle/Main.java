package routepuzzle;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        CommandLineArgumentParser argumentParser = new CommandLineArgumentParser(args);

        Arrays.stream(args).forEach(s -> System.out.println(s));

        RoomMapReader roomMapReader = null;
        try {
            roomMapReader = new JSONRoomMapReader(argumentParser.getFileName());
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<Integer, Room> roomMap = roomMapReader.getRoomMap();
        Puzzle puzzle = new Puzzle(roomMap);
        puzzle.solveAndPrettyPrintMoves(
                roomMap.get(argumentParser.getStartingRoom()),
                Arrays.stream(argumentParser.getItemsToFind()).map(itemToFindArgument -> new Item(itemToFindArgument)).collect(Collectors.toSet()));
    }
}
