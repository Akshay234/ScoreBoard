import ball.Ball;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class RunsTracker implements Observer, Calculable {

    private final ArrayList<Integer> balls;

    public RunsTracker() {
        balls = new ArrayList<>();
    }

    @Override
    public void update(Observable o, Object ball) {
        Ball ballToTrack = (Ball) ball;
        balls.add(ballToTrack.runs());
    }

    @Override
    public int totalUpto(int threshold) {
        int runs = 0;
        for (int i = 0; i < threshold; i++) {
            runs += balls.get(i);
        }
        return runs;
    }
}
