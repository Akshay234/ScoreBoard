import java.math.BigInteger;
import java.util.ArrayList;

public class ScoreBoard {
    private static final int OVER_LENGTH = 6;
    private ArrayList<Over> overs;

    public ScoreBoard(ArrayList<Over> overs) {
        this.overs = overs;
    }

    public int totalBallIn(double givenOvers){
        int completedOvers = (int) ((givenOvers * 10)/ OVER_LENGTH);
        int remainingBalls = (int) (givenOvers * 10 - completedOvers * 10);
        return (completedOvers * OVER_LENGTH) + remainingBalls;
    }



    private int totalRunsTill(double givenOvers) {
        int givenBalls = totalBallIn(givenOvers);
        int totalRuns = 0;
        ArrayList<Over> oversList = overs;
        for (Over over : overs) {
            if(!over.IsOfGreaterLength(givenBalls)) {
                totalRuns += over.totalRuns(OVER_LENGTH);
            }
            else{
                totalRuns += over.totalRuns(givenBalls);
            }
            givenBalls -= OVER_LENGTH;
        }
        return totalRuns;
    }

    public Displayer showUpTo(double over) {
        int totalRuns = totalRunsTill(over);
        return new Displayer(totalRuns);
    }

}