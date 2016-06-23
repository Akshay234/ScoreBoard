import java.util.ArrayList;
import java.util.Collection;

public class Over {

    private static final int OVER_LENGTH = 6;
    private ArrayList<Ball> balls;

    public Over(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    public double length() {
        return balls.size();
    }

    public int totalRuns(int givenBalls) {
        int runs = 0;

        for (int i = 0; i < givenBalls; i++) {
            if (!balls.get(i).equals("W") && !balls.get(i).equals("w")) {
                runs += Integer.parseInt(String.valueOf(balls.get(i)));
            }
        }
        return runs;
    }

    public boolean consistBallsLessThan(double length) {
        return this.length() < length;
    }

    public Ball getBallAt(int i) {
        return balls.get(i);
    }
}
