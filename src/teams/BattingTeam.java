package teams;

import ball.Ball;
import ball.Balls;
import player.Player;
import player.Players;

import java.util.Observable;
import java.util.Observer;

public class BattingTeam implements Observer {
    private static final int INITIAL_NEXT_DOWN_POSITION = 3;
    private Players team;
    private Player onStrike;
    private Player onNonStrike;
    private int nextDown;
    private Player lastBatsmanOut;
    private boolean islastBall = false;

    private BattingTeam(Players team, Player onStrike, Player onNonStrike) {
        this.team = team;
        this.onStrike = onStrike;
        this.onNonStrike = onNonStrike;
        this.nextDown = INITIAL_NEXT_DOWN_POSITION;
    }

    public static BattingTeam create(Players batsmans) {
        Player playerOnStrike = batsmans.get(1);
        Player playerOnNonStrike = batsmans.get(2);
        return new BattingTeam(batsmans, playerOnStrike, playerOnNonStrike);
    }

    private void updatePlayerOnStrike() {
        this.onStrike = team.get(nextDown);
    }

    private void updateNextPlayerTracker() {
        nextDown += 1;
    }

    private void switchOnCreasePlayers() {
        Player nonStrikePlayer = onNonStrike;
        onNonStrike = onStrike;
        onStrike = nonStrikePlayer;
    }

    private void switchPlayersIfOverComplete(Ball ball) {
        if (islastBall) {
            switchOnCreasePlayers();
            islastBall = false;
        }
    }

    private void switchPlayersIfOddRun(Ball ball) {
        if (ball.isOddRun()) {
            switchOnCreasePlayers();
        }
    }

    private void setNextPlayerIfOut(Ball ball) {
        if (ball.isWicket()) {
            lastBatsmanOut = onStrike;
            updatePlayerOnStrike();
            updateNextPlayerTracker();
        }
    }

    private void updatedAttributeOfPlayerOnStrike(int runs) {
        onStrike.incrementBallsPlayed();
        onStrike.updateRuns(runs);
    }

    private void updateRecord(Ball ball) {
        int runs = ball.runs();
        updatedAttributeOfPlayerOnStrike(runs);
        setNextPlayerIfOut(ball);
        switchPlayersIfOddRun(ball);
        switchPlayersIfOverComplete(ball);
    }

    public Player playerOnStrike() {
        return onStrike;
    }

    public Player playerOnNonStrike() {
        return onNonStrike;
    }

    public Player lastBatsmanGotOut() {
        return lastBatsmanOut;
    }

    @Override
    public void update(Observable o, Object ball) {
        if (ball.getClass().equals(Boolean.class)) {
            islastBall = true;
        } else {
            updateRecord((Ball) ball);
        }
    }

}
