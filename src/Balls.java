import java.util.ArrayList;
import java.util.HashMap;

public class Balls {
    private final HashMap<Integer, Ball> balls;

    private Balls(HashMap<Integer, Ball> balls) {
        this.balls = balls;
    }

    public static Balls create(ArrayList<String> values) {
        HashMap<Integer, Ball> ballsMaping = new HashMap<>();
        int ballNumber = 1;
        for (String value : values) {
            ballsMaping.put(ballNumber, new Ball(ballNumber, value));
            ballNumber += 1;
        }
        return new Balls(ballsMaping);
    }

    public Ball get(int providedBalls) {
        return balls.get(providedBalls);
    }

    public int total() {
        return balls.size();
    }
}
