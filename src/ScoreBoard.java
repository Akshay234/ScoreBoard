import java.util.ArrayList;

public class ScoreBoard {
    private static final int OVER_LENGTH = 6;
    private Players batsmans;
    private Players bowlers;
    private ArrayList<Over> overs;

    private ScoreBoard(ArrayList<Over> overs, Players batsmans, Players bowlers) {
        this.overs = overs;
        this.batsmans = batsmans;
        this.bowlers = bowlers;
    }

    private int totalRunsTill(double over) {
        ArrayList<Ball> balls = getBallsIn(over);
        int runs = 0;
        for (Ball ball : balls) {
            runs += ball.getRun();
        }
        return runs;
    }

    private int calculateTotalWicketsTill(double over) {
        ArrayList<Ball> balls = getBallsIn(over);
        int wickets = 0;
        for (Ball ball : balls) {
            wickets += ball.getWicket();
        }
        return wickets;
    }

    public static ScoreBoard create(ArrayList<Over> overs, Players batsmans, Players bowlers) {
        ScoreBoard scoreBoard = new ScoreBoard(overs, batsmans, bowlers);
        return scoreBoard;
    }

    private ArrayList<Ball> filterBallsUpto(int index, Over over) {
        ArrayList<Ball> balls = new ArrayList<>(index);
        for (int i = 0; i < index; i++) {
            balls.add(over.getBallAt(i));
        }
        return balls;
    }

    private int calculateTotalBallsIn(double givenOvers) {
        int completedOvers = (int) Math.floor(givenOvers);
        int remainingBalls = (int) Math.round((givenOvers - completedOvers) * 10);
        return (completedOvers * OVER_LENGTH) + remainingBalls;
    }

    private ArrayList<Ball> getBallsIn(double givenOvers) {
        int totalNumberOfBalls = calculateTotalBallsIn(givenOvers);
        ArrayList<Ball> balls = new ArrayList<>(totalNumberOfBalls);
        for (Over over : overs) {
            if (over.consistBallsLessThan(totalNumberOfBalls)) {
                balls.addAll(filterBallsUpto(OVER_LENGTH, over));
                totalNumberOfBalls -= OVER_LENGTH;
            } else {
                balls.addAll(filterBallsUpto(totalNumberOfBalls, over));
                return balls;
            }
        }
        return balls;
    }

    private void update(ArrayList<Ball> balls) {
        for (Ball ball : balls) {
            updateRecordAccordingTo(ball);
        }
    }

    private void updateRecordAccordingTo(Ball ball) {
        batsmans.update(ball);
        bowlers.update(ball);
    }

    public Displayer showUpTo(double over) {
        update(getBallsIn(over));
        int totalRuns = totalRunsTill(over);
        int totalWickets = calculateTotalWicketsTill(over);
        return new Displayer(totalRuns, totalWickets, batsmans, bowlers);
    }
}
