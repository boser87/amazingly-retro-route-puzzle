package routepuzzle;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Move {
    private Room room;
    private Set<Item> itemsCollected;

    public Move(Room room, Set<Item> itemsCollected) {
        this.room = room;
        this.itemsCollected = itemsCollected;
    }


    @Override
    public int hashCode() {
        return Objects.hash(room, itemsCollected);
    }

    // Overriding equals is needed to make comparison between two Move objects work
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o instanceof Move) {
            Move m = (Move) o;
            return Objects.equals(room, m.room)
                    && Objects.equals(itemsCollected, m.itemsCollected);
        }
        return false;
    }

    public void prettyPrint() {
        System.out.printf("%d. %-15s %s\n", room.getId(), room.getName(), itemsCollectedToString());
    }

    private String itemsCollectedToString() {
        return itemsCollected.stream().map(item -> item.toString()).collect(Collectors.joining(", "));
    }


}
