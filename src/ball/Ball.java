package ball;

import parser.InputParser;
public class Ball {
    private static final int OVER_LENGTH = 6;
    private int ballNumber;
    private final String value;

    public Ball(int ballNumber, String value) {
        this.ballNumber = ballNumber;
        this.value = value;
    }

    public boolean isOddRun() {
        return (runs() % 2) != 0;
    }

    public boolean isWicket() {
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return true;
        } catch (NullPointerException e) {
            return true;
        }
        return false;
    }

    public int runs() {
        return !isWicket() ? Integer.parseInt(value) : 0;
    }

    public int wicket() {
        return isWicket() ? 1 : 0;
    }

    public boolean last() {
        return ballNumber % OVER_LENGTH == 0;
    }
}