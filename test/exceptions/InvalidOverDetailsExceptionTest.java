package exceptions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class InvalidOverDetailsExceptionTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void should_throw_InvalidOverDetailsException_with_detailed_error_message_when_called() throws InvalidOverDetailsException {
        String invalidData = "foobar";
        exception.expect(InvalidOverDetailsException.class);
        exception.expectMessage("foobar is a invalid data.");
        throw new InvalidOverDetailsException(invalidData);
    }
}