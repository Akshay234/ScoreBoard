package parser.validate;


import exceptions.InvalidOverThresholdException;

import java.text.NumberFormat;

public class OverThresholdValidator extends Validator {
    private String[] oversDetail;
    private double threshold;

    public OverThresholdValidator(String[] oversDetail, double threshold) {
        this.oversDetail = oversDetail;
        this.threshold = threshold;
    }

    @Override
    public void validate() throws InvalidOverThresholdException {

        int completedOvers = (int) Math.floor(threshold);
        double remainingBalls = (threshold - completedOvers) * 10;
        String number = Integer.toBinaryString((int) remainingBalls);
        int ballSize = Integer.parseInt(number);
        if (((ballSize <= 0) && (ballSize > 6)) || ((ballSize + (completedOvers * 6)) > oversDetail.length)) {
            throw new InvalidOverThresholdException(threshold);
        }
    }
}
