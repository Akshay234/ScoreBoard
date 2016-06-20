public class Over {

    private static final int OVER_LENGTH = 6;
    private char[] balls;

    public Over(char[] balls) {
        this.balls = balls;
    }

    private double length() {
        return balls.length;
    }

    public int totalRuns(int givenBalls) {
        int runs = 0;
        for (int i = 0; i < givenBalls; i++) {
            if (balls[i] != 'W' && balls[i] != 'w') {
                runs += Integer.parseInt(String.valueOf(balls[i]));
            }
        }
        return runs;
    }

    public boolean IsOfGreaterLength(double length) {
        return this.length() > length;
    }
}
