package player;

import java.util.ArrayList;

public class Players {
    private ArrayList<Player> players;

    private Players(ArrayList<Player> names) {
        players = names;
    }

    public Player get(int playerPosition) {
        return players.get(playerPosition);
    }

    public static Players create(ArrayList<String> names) {
        ArrayList<Player> playersMapping = new ArrayList<>();
        for (String name : names) {
            playersMapping.add(new Player(name));
        }
        return new Players(playersMapping);
    }

    public Player getNextOf(Player givenPlayer) {
        int positionOfCurrentPlayer = players.indexOf(givenPlayer);
        Player nextPlayer = players.get(positionOfCurrentPlayer++);
        return (nextPlayer != null) ? nextPlayer : players.get(0);
    }

}
