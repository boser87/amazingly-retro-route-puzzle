package routepuzzle;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Room {
    private Integer id;
    private String name;
    private Integer north;
    private Integer south;
    private Integer west;
    private Integer east;
    private Set<Item> items;

    public Room(Integer id, String name, Integer north, Integer south, Integer west, Integer east, Set<Item> items) {
        this.id = id;
        this.name = name;
        this.north = north;
        this.south = south;
        this.west = west;
        this.east = east;
        this.items = items;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Item> getItems() {
        return items;
    }

    @Override
    public String toString() {
        return id.toString() + ": " + name;
    }

    // Order of neighbors in the neighbors' set affect how different results, all still valid, are generated
    public Set<Room> getNeighboors(Map<Integer, Room> roomMap) {
        return Stream.of(south, west, east, north)
                .filter(Objects::nonNull)
                .map(id -> roomMap.get(id))
                .collect(Collectors.toCollection(LinkedHashSet::new)); // LinkedHashSet will preserve order of initial neighbors list
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id) &&
                Objects.equals(name, room.name) &&
                Objects.equals(north, room.north) &&
                Objects.equals(south, room.south) &&
                Objects.equals(west, room.west) &&
                Objects.equals(east, room.east) &&
                items.containsAll(room.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, north, south, west, east, items);
    }
}
