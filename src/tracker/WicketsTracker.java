package tracker;

import ball.Ball;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class WicketsTracker implements Observer, Calculable {

    private final ArrayList<Integer> balls;

    public WicketsTracker() {
        balls = new ArrayList<>();
    }

    @Override
    public void update(Observable o, Object ball) {
        Ball ballToTrack = (Ball) ball;
        balls.add(ballToTrack.wicket());
    }

    @Override
    public int totalUpto(int threshold) {
        int wickets = 0;
        for (int i = 0; i < threshold; i++) {
            wickets += balls.get(i);
        }
        return wickets;
    }
}
