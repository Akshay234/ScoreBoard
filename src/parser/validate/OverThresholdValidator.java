package parser.validate;


import exceptions.InvalidOverThresholdException;

public class OverThresholdValidator extends Validator {

    private double threshold;

    public OverThresholdValidator(double threshold) {
        this.threshold = threshold;
    }

    @Override
    public void validate() throws InvalidOverThresholdException {
        int completedOvers = (int) Math.floor(threshold);
        double remainingBalls = (threshold - completedOvers) * 10;
        if (remainingBalls % 1 != 0) {
            throw new InvalidOverThresholdException(threshold);
        }
    }
}
