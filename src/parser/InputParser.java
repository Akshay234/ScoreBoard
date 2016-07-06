package parser;

import ball.Ball;
import exceptions.InvalidOverDetailsException;
import exceptions.InvalidOverThresholdException;
import parser.validate.Validators;

import java.util.ArrayList;

public class InputParser {
    private static final int OVER_LENGTH = 6;
    private String[] oversDetail;
    private double overThreshold;

    private InputParser(String[] oversDetail, double overThreshold) {
        this.oversDetail = oversDetail;
        this.overThreshold = overThreshold;
    }

    public static InputParser create(String[] oversDetail, double overThreshold, Validators validators) throws InvalidOverDetailsException, InvalidOverThresholdException {
        validators.validate();
        return new InputParser(oversDetail, overThreshold);
    }

    public int ballsThreshold() {
        int completedOvers = (int) Math.floor(overThreshold);
        int remainingBalls = (int) Math.round((overThreshold - completedOvers) * 10);
        return (completedOvers * OVER_LENGTH) + remainingBalls;
    }

    public ArrayList<Ball> getBalls() {
        ArrayList<Ball> ballsCollection = new ArrayList<>();
        for (int i = 0; i < ballsThreshold(); i++) {
            ballsCollection.add(new Ball(oversDetail[i]));
        }
        return ballsCollection;
    }
}