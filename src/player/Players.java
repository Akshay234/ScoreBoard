package player;

import java.util.ArrayList;
import java.util.HashMap;

public class Players {
    private HashMap<Integer, Player> players;

    private Players(HashMap<Integer, Player> players) {
        this.players = players;
    }

    public static Players create(ArrayList<String> names) {
        HashMap<Integer, Player> playersMapping = new HashMap<>(names.size());
        int position = 1;
        for (String name : names) {
            playersMapping.put(position, new Player(name, position));
            position++;
        }
        return new Players(playersMapping);
    }

    public Player get(int playerPosition) {
        return players.get(playerPosition);
    }

    public Player getNextOf(Player player) {
        for (int key : players.keySet()) {
            if (players.get(key).equals(player) && players.containsKey(key++)) {
                return players.get(key++);
            }
        }
        return players.get(1);
    }

}
