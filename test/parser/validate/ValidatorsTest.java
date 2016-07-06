package parser.validate;

import exceptions.InvalidOverDetailsException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import parser.InputFormatter;

import static org.junit.Assert.*;

public class ValidatorsTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void ShouldAddValidator() throws Exception {
        String correctOverData = " 1  2 3";
        String[] formattedData = new InputFormatter(correctOverData).format();
        Validators validators = new Validators();

        OverDetailsValidator overDetailsValidator1 = new OverDetailsValidator(formattedData);

        validators.add(overDetailsValidator1);

        validators.validate();
    }

    @Test(expected = InvalidOverDetailsException.class)
    public void ShouldThrowExceptionWhenDataIsNotCorrect() throws Exception {
        String overDetails = "1 2 3 4 5 6Ww M n ";
        String[] formattedData = new InputFormatter(overDetails).format();

        Validators validators = new Validators();

        OverDetailsValidator overDetailsValidator = new OverDetailsValidator(formattedData);

        validators.add(overDetailsValidator);
        validators.validate();

    }
}