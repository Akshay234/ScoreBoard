package parser.validate;

import exceptions.InvalidOverDetailsException;
import org.junit.Assert;
import org.junit.Test;
import parser.InputFormatter;

import static org.junit.Assert.*;

public class OverDetailsValidatorTest {
    @Test

    public void SholdValidateTheDetailOfOver() throws Exception {
        String overDetails = "1 2 3 4 5 6 W w";
        String[] formattedData = new InputFormatter(overDetails).format();
        OverDetailsValidator overDetailsValidator = new OverDetailsValidator(formattedData);
        overDetailsValidator.validate();

//        assertEquals(oversData,overDetails);

    }

    @Test(expected = InvalidOverDetailsException.class)
    public void ShouldThrowExceptionWhenDataIsNotCorrect() throws Exception {
        String overDetails = "1 2 3 4 5 6Ww M n ";
        String[] formattedData = new InputFormatter(overDetails).format();

        OverDetailsValidator overDetailsValidator = new OverDetailsValidator(formattedData);
        Validators validators = new Validators();

        validators.add(overDetailsValidator);

        validators.validate();
    }
}