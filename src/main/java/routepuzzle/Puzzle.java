package routepuzzle;

import java.util.*;

public class Puzzle {

    private final Map<Integer, Room> roomMap;

    private List<Move> moves = new ArrayList<>();
    private Stack<Room> roomsToVisit = new Stack<>();
    private Set<Item> remainingItems;
    private Set<Room> visitedRooms = new HashSet<>();

    Puzzle(Map<Integer, Room> roomMap) {
        this.roomMap = roomMap;
    }

    public List<Move> solve(Room startingRoom, Set<Item> itemsToCollect) {
        if(itemsToCollect.isEmpty()) {
            return Collections.emptyList();
        }

        remainingItems = new HashSet<>(itemsToCollect);

        roomsToVisit.push(startingRoom);

        visitNextRoom();

        return moves;
    }

    public void solveAndPrettyPrintMoves(Room startingRoom, Set<Item> itemsToCollect) {
        List<Move> moves = solve(startingRoom, itemsToCollect);
        System.out.printf("%s %-15s %s\n", "ID", "Room", "Items");
        moves.stream().forEach(move -> move.prettyPrint());
    }

    private void visitNextRoom() {
        if(roomsToVisit.isEmpty() || remainingItems.isEmpty())
            return;

        Room room = roomsToVisit.peek();

        Set<Item> collectedItemsInTheRoom = collectItemsInTheRoom(room, remainingItems);
        updateItemsToCollect(collectedItemsInTheRoom);

        moves.add(new Move(room, collectedItemsInTheRoom));

        visitedRooms.add(room);

        Set<Room> neighbors = room.getNeighboors(roomMap);
        neighbors.removeAll(visitedRooms);

        // TODO: handle different strategies for the graph traversing
        Optional<Room> firstNeighbor = neighbors.stream().findFirst();

        if(firstNeighbor.isPresent()) {
            roomsToVisit.push(firstNeighbor.get());
        } else {
            roomsToVisit.pop();
        }

        visitNextRoom();
    }

    private void updateItemsToCollect(Set<Item> collectedItemsInTheRoom) {
        remainingItems.removeAll(collectedItemsInTheRoom);
    }

    private Set<Item> collectItemsInTheRoom(Room room, Set<Item> itemsToCollect) {
        Set<Item> collectedItemsInTheRoom = room.getItems();
        collectedItemsInTheRoom.retainAll(itemsToCollect);
        return collectedItemsInTheRoom;
    }
}
