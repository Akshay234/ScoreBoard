package ball;

import java.util.ArrayList;
import java.util.Observable;

public class Balls extends Observable {
    private final ArrayList<Ball> balls;

    public Balls(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    public Ball get(int providedBalls) {
        Ball ball = balls.get(providedBalls);
        if (isLastBall(ball)){
            setChanged();
            notifyObservers(true);
        }
        return ball;
    }

    private boolean isLastBall(Ball ball) {
        return ((balls.indexOf(ball) + 1) % 6 == 0);
    }

    public int total() {
        return balls.size();
    }
}
