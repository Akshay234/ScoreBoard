package ball;

import ball.Ball;

import java.util.ArrayList;

public class Balls {
    private final ArrayList<Ball> balls;

    public Balls(ArrayList<Ball> balls) {
        this.balls = balls;
    }

    public Ball get(int providedBalls) {
        return balls.get(providedBalls);
    }

    public int total() {
        return balls.size();
    }
}
