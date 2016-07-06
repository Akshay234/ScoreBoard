package parser.validate;

import exceptions.InvalidOverThresholdException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import parser.InputFormatter;



public class OverThresholdValidatorTest {
    private String overDetail;
    private double threshold;
    private double validThreshold;
    private double invalidThreshold;

    @Before
    public void setUp() throws Exception {
        overDetail = "1 2 3 4 5 6 7 w W";
        threshold = 1.2;
        validThreshold =1.4;
        invalidThreshold = 1.22;

    }

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void should_not_throw_exception_if_threshold_is_valid() throws InvalidOverThresholdException {
        String[] formattedData = new InputFormatter(overDetail).format();
        OverThresholdValidator overThresholdValidator = new OverThresholdValidator(formattedData, threshold);
        overThresholdValidator.validate();
    }

    @Test
    public void should_throw_exception_if_threshold_is_invalid() throws InvalidOverThresholdException {

        String[] formattedData = new InputFormatter(overDetail).format();
        OverThresholdValidator overThresholdValidator = new OverThresholdValidator(formattedData, validThreshold);
        exception.expect(InvalidOverThresholdException.class);
        exception.expectMessage("1.4 is an invalid limit, please enter a valid over limit.");
        overThresholdValidator.validate();
    }


    @Test
    public void should_throw_exception_if_threshold_is_in_double_decimal_value() throws InvalidOverThresholdException {
        String[] formattedData = new InputFormatter(overDetail).format();
        OverThresholdValidator overThresholdValidator = new OverThresholdValidator(formattedData, invalidThreshold);
        exception.expect(InvalidOverThresholdException.class);
        exception.expectMessage("1.22 is an invalid limit, please enter a valid over limit.");
        overThresholdValidator.validate();
    }
}