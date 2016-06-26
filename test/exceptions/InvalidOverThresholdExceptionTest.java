package exceptions;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InvalidOverThresholdExceptionTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void should_throw_InvalidOverThresholdException_with_detailed_error_message_when_called() throws InvalidOverThresholdException {
        double invalidThreshold = 2.22;
        exception.expect(InvalidOverThresholdException.class);
        exception.expectMessage("2.22 is an invalid limit, please enter a valid over limit.");
        throw new InvalidOverThresholdException(invalidThreshold);
    }
}