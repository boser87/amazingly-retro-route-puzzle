package routepuzzle;


import java.util.List;
import java.util.stream.Collectors;

public class JSONRoom {
    private Integer id;
    private String name;
    private Integer north;
    private Integer south;
    private Integer west;
    private Integer east;
    private List<JSONItem> objects;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNorth(Integer north) {
        this.north = north;
    }

    public void setSouth(Integer south) {
        this.south = south;
    }

    public void setWest(Integer west) {
        this.west = west;
    }

    public void setEast(Integer east) {
        this.east = east;
    }

    public void setObjects(List<JSONItem> objects) {
        this.objects = objects;
    }

    public Room convertToRoom() {
        List<Item> roomItems  = objects.stream().map(jsonItem -> new Item(jsonItem.getName())).collect(Collectors.toList());
        Room room = new RoomBuilder()
                .setId(id)
                .setName(name)
                .addItems(roomItems)
                .setEast(east)
                .setNorth(north)
                .setSouth(south)
                .setWest(west)
                .addItems(objects.stream().map(object -> new Item(object.getName())).collect(Collectors.toList()))
                .createRoom();
        return room;
    }
}
