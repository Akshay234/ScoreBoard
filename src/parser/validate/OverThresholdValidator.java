package parser.validate;


import exceptions.InvalidOverThresholdException;

public class OverThresholdValidator extends Validator {
    private String oversDetail;
    private double threshold;

    public OverThresholdValidator(String oversDetail, double threshold) {
        this.oversDetail = oversDetail;
        this.threshold = threshold;
    }

    private String[] formattedData() {
        return oversDetail.trim().replaceAll(" +", " ").split(" ");
    }

    @Override
    public void validate() throws InvalidOverThresholdException {
        int completedOvers = (int) Math.floor(threshold);
        double remainingBalls = (threshold - completedOvers) * 10;
        if (remainingBalls % 1 != 0 && threshold < formattedData().length) {
            throw new InvalidOverThresholdException(threshold);
        }
    }
}
