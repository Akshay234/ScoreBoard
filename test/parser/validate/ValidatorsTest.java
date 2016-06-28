package parser.validate;

import exceptions.InvalidOverDetailsException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class ValidatorsTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void ShouldAddValidator() throws Exception {
        String correctOverData = " 1  2 3";

        Validators validators = new Validators();

        OverDetailsValidator overDetailsValidator1 = new OverDetailsValidator(correctOverData);


        validators.add(overDetailsValidator1);

        validators.validate();


        assertEquals(validators.getValidators().get(0), overDetailsValidator1);

    }

    @Test(expected = InvalidOverDetailsException.class)
    public void ShouldThrowExceptionWhenDataIsNotCorrect() throws Exception {
        String OverData = "1 2 3 4 5 6Ww M n ";

        Validators validators = new Validators();

        OverDetailsValidator overDetailsValidator = new OverDetailsValidator(OverData);

        validators.add(overDetailsValidator);
        validators.validate();

    }
}