package parser.validate;


import exceptions.InvalidOverThresholdException;

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
        int ballSize = (int) Math.ceil(remainingBalls);
        if ((ballSize - remainingBalls > 0.00001)|| ((ballSize + (completedOvers * 6)) > oversDetail.length)) {
            throw new InvalidOverThresholdException(threshold);
        }
    }
}
