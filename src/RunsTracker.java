import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;

public class RunsTracker implements Observer,Calculable {

    private final HashMap<Integer, Integer> balls;

    public RunsTracker() {
        balls = new HashMap<Integer, Integer>();
    }

    @Override
    public void update(Observable o, Object ball) {
        Ball ballToTrack = (Ball) ball;
        balls.put(ballToTrack.number(), ballToTrack.runs());
    }

    @Override
    public int totalUpto(int threshold) {
        int runs = 0;
        for (int i = 1; i <= threshold; i++) {
            runs += balls.get(i);
        }
        return runs;
    }
}
