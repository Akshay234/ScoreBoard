import java.util.Observable;
import java.util.Observer;

public class BowlingTeam implements Observer {
    private Players bowlers;
    private Player currentBowler;
    private Player nextBowler;
    private Player lastWicketTakerBowler;

    public BowlingTeam(Players bowlers, Player currentBowler, Player nextBowler) {
        this.bowlers = bowlers;
        this.currentBowler = currentBowler;
        this.nextBowler = nextBowler;
    }

    public static BowlingTeam create(Players bowlers) {
        Player currentBowler = bowlers.get(1);
        Player nextBowler = bowlers.get(2);
        return new BowlingTeam(bowlers, currentBowler, nextBowler);
    }

    private void changeBowler() {
        currentBowler = nextBowler;
        nextBowler = bowlers.getNextOf(currentBowler);
    }

    private void changeBowlerIfOverCompleted() {
        if (currentBowler.isOverCompleted()) {
            changeBowler();
        }
    }

    private void creditWicketIfAny(Ball ball) {
        if (ball.isWicket()) {
            lastWicketTakerBowler = currentBowler;
            currentBowler.creditWicket();
        }
    }

    private void updateRecord(Ball ball) {
        currentBowler.incrementBallsDelivery();
        currentBowler.updateRunsConsided(ball.runs());
        creditWicketIfAny(ball);
        changeBowlerIfOverCompleted();
    }

    public Player lastWicketTaker() {
        return lastWicketTakerBowler;
    }

    @Override
    public void update(Observable o, Object ball) {
        updateRecord((Ball) ball);
    }
}
