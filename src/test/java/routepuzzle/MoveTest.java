package routepuzzle;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class MoveTest {

    @Test
    public void nicePrint() {
        Move move = new Move(new RoomBuilder().setId(1).setName("Anyroom").createRoom(),
                new HashSet(Arrays.asList(new Item("Cat"), new Item("Dog"))));
        move.prettyPrint();
    }
}
