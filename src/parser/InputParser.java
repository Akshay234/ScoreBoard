package parser;

import ball.Ball;

import java.util.ArrayList;

public class InputParser {
    private static final int OVER_LENGTH = 6;
    private String oversDetail;
    private double overThreshold;

    public InputParser(String oversDetail, double overThreshold) {
        this.oversDetail = oversDetail;
        this.overThreshold = overThreshold;
    }

    private String[] formattedData() {
        return oversDetail.trim().replaceAll(" +", " ").split(" ");
    }

    public boolean isValid() {
        String validator = "[0-9]+|W|w";
        String[] oversData = formattedData();
        for (String ballValue : oversData) {
            if (!ballValue.matches(validator)) {
                return false;
            }
        }
        return true;
    }

    public int ballsThreshold() {
        int completedOvers = (int) Math.floor(overThreshold);
        int remainingBalls = (int) Math.round((overThreshold - completedOvers) * 10);
        return (completedOvers * OVER_LENGTH) + remainingBalls;
    }

    public ArrayList<Ball> getBalls() {
        String[] balls = formattedData();
        ArrayList<Ball> ballsCollection = new ArrayList<>();
        for (int i = 0; i < ballsThreshold(); i++) {
            ballsCollection.add(new Ball(i+1, balls[i]));
        }
        return ballsCollection;
    }
}