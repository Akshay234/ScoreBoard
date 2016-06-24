import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class WicketsTracker implements Observer,Calculable {

    private final HashMap<Integer, Integer> balls;

    public WicketsTracker() {
        balls = new HashMap<Integer, Integer>();
    }

    @Override
    public void update(Observable o, Object ball) {
        Ball ballToTrack = (Ball) ball;
        balls.put(ballToTrack.number(), ballToTrack.wicket());
    }

    @Override
    public int totalUpto(int threshold) {
        int wickets = 0;
        for (int i = 1; i <= threshold; i++) {
            wickets += balls.get(i);
        }
        return wickets;
    }
}
