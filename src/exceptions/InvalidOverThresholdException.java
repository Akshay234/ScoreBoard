package exceptions;

public class InvalidOverThresholdException extends Exception {
    public InvalidOverThresholdException(double invalidThreshold) {
        super(invalidThreshold + " is an invalid limit, please enter a valid over limit.");
    }
}
