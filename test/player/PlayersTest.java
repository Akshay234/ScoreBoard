package player;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class PlayersTest {
    @Test
    public void ShouldCreatePlayer() throws Exception {
        ArrayList<String> playersList= new ArrayList<>();
        playersList.add("test1");
        Players players = Players.create(playersList);
        assertEquals(playersList.get(0), players.get(0).name());
    }
    @Test
    public void ShouldGiveNextPlayer() throws Exception {
        ArrayList<String> playersList= new ArrayList<>();
        playersList.add("test1");
        playersList.add("test2");
        playersList.add("test3");
        playersList.add("test4");

        Players players = Players.create(playersList);

        assertEquals(playersList.get(0), players.get(0).name());

        assertEquals(playersList.get(1),players.getNextOf(players.get(1)).name());
        assertEquals(playersList.get(3),players.getNextOf(players.get(3)).name());

    }
}