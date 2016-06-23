import java.util.ArrayList;
import java.util.HashMap;

public class Players {

    private HashMap<Integer, Player> players;
    private Role role;
    private Player playerOnStrike;
    private Player playerOnNonStrike;
    private Player currentBowler;
    private int positionOfUpcomingPlayer;


    private Players(HashMap<Integer, Player> players, Role role, Player playerOnStrike, Player playerOnNonStrike, Player currentBowler) {
        this.players = players;
        this.role = role;
        this.playerOnStrike = playerOnStrike;
        this.playerOnNonStrike = playerOnNonStrike;
        this.currentBowler = currentBowler;
        this.positionOfUpcomingPlayer = 3;
    }

    private void changeBowler() {
        currentBowler = players.get(currentBowler.upcomingPlayerPosition());
    }

    private Player nextPlayer(Player playerOnStrike) {
        return players.get(positionOfUpcomingPlayer);
    }

    private boolean isOdd(int runs) {
        return (runs % 2) != 0;
    }

    public static Players createBatsmans(ArrayList<String> names) {
        HashMap<Integer, Player> playersMapping = new HashMap<>(names.size());
        int position = 1;
        for (String name : names) {
            playersMapping.put(position, new Player(name, position));
            position++;
        }
        Player playerOnStrike = playersMapping.get(1);
        Player playerOnNonStrike = playersMapping.get(2);
        return new Players(playersMapping, Role.Batsman, playerOnStrike,playerOnNonStrike, null);
    }

    public static Players createBowlers(ArrayList<String> names) {
        HashMap<Integer, Player> playersMapping = new HashMap<>(names.size());
        int position = 1;
        for (String name : names) {
            playersMapping.put(position, new Player(name, position));
            position++;
        }
        Player currentBowler = playersMapping.get(1);
        return new Players(playersMapping, Role.Bowler, null, null, currentBowler );
    }



    public Player onStrike() {
        return playerOnStrike;
    }

    public void update(Ball ball) {
        if (role.equals(Role.Batsman)) {
            playerOnStrike.incrementBallsPlayed();
            if (ball.isWicket()) {
                playerOnStrike = nextPlayer(playerOnStrike);
                positionOfUpcomingPlayer += 1;
            } else {
                int runs = ball.getRun();
                playerOnStrike.updateRuns(runs);
                if (isOdd(runs)) {
                    Player nonStrikePlayer = playerOnNonStrike;
                    playerOnNonStrike = playerOnStrike;
                    playerOnStrike = nonStrikePlayer;
                }
            }
        } else {
            currentBowler.incrementBallsDelivery();
            if (ball.isWicket()) {
                currentBowler.creditWicket();
            }
            if (currentBowler.isOverCompleted()) {
                changeBowler();
            }
        }
    }

    public Player onNonStrike() {
        return playerOnNonStrike;
    }
}
