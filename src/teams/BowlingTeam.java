package teams;

import ball.Ball;
import player.Player;
import player.Players;

import java.util.Observable;
import java.util.Observer;

public class BowlingTeam implements Observer {
    private Players team;
    private Player currentBowler;
    private Player nextBowler;
    private Player lastWicketTakingBowler;

    private BowlingTeam(Players team, Player currentBowler, Player nextBowler) {
        this.team = team;
        this.currentBowler = currentBowler;
        this.nextBowler = nextBowler;
    }

    public static BowlingTeam create(Players bowlers) {
        Player currentBowler = bowlers.get(0);
        Player nextBowler = bowlers.get(1);
        return new BowlingTeam(bowlers, currentBowler, nextBowler);
    }

    private void changeBowler() {
        currentBowler = nextBowler;
        nextBowler = team.getNextOf(currentBowler);
    }

    private void changeBowlerIfOverCompleted() {
        if (currentBowler.isOverCompleted()) {
            changeBowler();
        }
    }


    private void updateRecord(Ball ball) {
        currentBowler.incrementBallsDelivery();
        updateWicketTakingBowlerIfWicket(ball);
        changeBowlerIfOverCompleted();

    }

    private void updateWicketTakingBowlerIfWicket(Ball ball) {
        if (ball.isWicket()) {
            lastWicketTakingBowler = currentBowler;
        }
    }

    public Player lastWicketTaker() {
        return lastWicketTakingBowler;
    }

    @Override
    public void update(Observable o, Object ball) {
        updateRecord((Ball) ball);
    }
}
