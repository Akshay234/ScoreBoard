import ball.Ball;

import java.util.Observable;
import java.util.Observer;

public class BattingTeam implements Observer {
    private Players batsmans;
    private Player onStrike;
    private Player onNonStrike;
    private int positionOfUpcomingPlayer;
    private Player lastBatsmanOut;

    private BattingTeam(Players batsmans, Player onStrike, Player onNonStrike) {
        this.batsmans = batsmans;
        this.onStrike = onStrike;
        this.onNonStrike = onNonStrike;
        this.positionOfUpcomingPlayer = 3;
    }

    public static BattingTeam create(Players batsmans) {
        Player playerOnStrike = batsmans.get(1);
        Player playerOnNonStrike = batsmans.get(2);
        return new BattingTeam(batsmans, playerOnStrike, playerOnNonStrike);
    }

    private void updatePlayerOnStrike() {
        this.onStrike = batsmans.get(positionOfUpcomingPlayer);
    }

    private void updateNextPlayerTracker() {
        positionOfUpcomingPlayer += 1;
    }

    private void switchOnCreasePlayers() {
        Player nonStrikePlayer = onNonStrike;
        onNonStrike = onStrike;
        onStrike = nonStrikePlayer;
    }

    private void switchPlayersIfOverComplete(Ball ball) {
        if (ball.last()) {
            switchOnCreasePlayers();
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
        updateRecord((Ball) ball);
    }

}
