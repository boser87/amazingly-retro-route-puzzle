package routepuzzle;

import org.junit.Test;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class PuzzleTest {

    @Test
    public void oneRoomWithNoNeighboorsAndNoItemsShouldReturnEmptyRoot() {

        Room room = new RoomBuilder().setId(1).createRoom();

        Puzzle puzzle = new Puzzle(Collections.singletonMap(1, room));

        Set<Item> itemsToCollect = Collections.emptySet();

        List<Move> moves = puzzle.solve(room, itemsToCollect);

        assertThat(moves).isEmpty();
    }

    @Test
    public void oneRoomThatHasTheItemsToFindShouldReturnRootWithOneMove() {
        Item item = new Item("Cat");
        Set<Item> itemsToCollect = new HashSet<>();
        itemsToCollect.add(item);

        Room room = new RoomBuilder().setId(1).addItem(item).createRoom();

        Puzzle puzzle = new Puzzle(Collections.singletonMap(1, room));

        List<Move> moves = puzzle.solve(room, itemsToCollect);

        assertThat(moves).containsOnly(new Move(room, itemsToCollect));
    }

    @Test
    public void twoRoomsWithOneItemToFindEach() {
        Item item1 = new Item("Cat");
        Item item2 = new Item("Dog");
        Set<Item> itemsToCollect = new HashSet<>();
        itemsToCollect.add(item1);
        itemsToCollect.add(item2);

        Room room1 = new RoomBuilder().setId(1).setSouth(2).addItem(item1).createRoom();
        Room room2 = new RoomBuilder().setId(2).setNorth(1).addItem(item2).createRoom();
        Map<Integer, Room> roomMap = new HashMap<>();
        roomMap.put(1, room1);
        roomMap.put(2, room2);

        Puzzle puzzle = new Puzzle(roomMap);

        List<Move> moves = puzzle.solve(room1, itemsToCollect);

        assertThat(moves).containsExactly(new Move(room1, Collections.singleton(item1)),
                new Move(room2, Collections.singleton(item2)));

    }

    @Test
    public void printMoves() {
        Item item1 = new Item("Cat");
        Item item2 = new Item("Squirrel");
        Item item3 = new Item("Dog");
        Set<Item> itemsToCollect = new HashSet<>();
        itemsToCollect.add(item1);
        itemsToCollect.add(item2);
        itemsToCollect.add(item3);

        Room room1 = new RoomBuilder().setId(1).setSouth(2).addItem(item1).setName("Room1").createRoom();
        Room room2 = new RoomBuilder().setId(2).setNorth(1).addItem(item2).addItem(item3).setName("Room2").createRoom();
        Map<Integer, Room> roomMap = new HashMap<>();
        roomMap.put(1, room1);
        roomMap.put(2, room2);

        Puzzle puzzle = new Puzzle(roomMap);

        puzzle.solveAndPrettyPrintMoves(room1, itemsToCollect);
    }

}
