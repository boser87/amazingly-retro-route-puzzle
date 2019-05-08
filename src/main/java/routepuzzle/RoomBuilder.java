package routepuzzle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RoomBuilder {
    private Integer id;
    private String name;
    private Integer north;
    private Integer south;
    private Integer west;
    private Integer east;
    private Set<Item> items = new HashSet<>();

    public RoomBuilder setId(Integer id) {
        this.id = id;
        return this;
    }

    public RoomBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public RoomBuilder setNorth(Integer north) {
        this.north = north;
        return this;
    }

    public RoomBuilder setSouth(Integer south) {
        this.south = south;
        return this;
    }

    public RoomBuilder setWest(Integer west) {
        this.west = west;
        return this;
    }

    public RoomBuilder setEast(Integer east) {
        this.east = east;
        return this;
    }

    public RoomBuilder addItem(String item) {
        items.add(new Item(item));
        return this;
    }

    public RoomBuilder addItem(Item item) {
        items.add(item);
        return this;
    }

    public RoomBuilder addItems(List<Item> objects) {
        items.addAll(objects);
        return this;
    }

    public Room createRoom() {
        return new Room(id, name, north, south, west, east, items);
    }
}
