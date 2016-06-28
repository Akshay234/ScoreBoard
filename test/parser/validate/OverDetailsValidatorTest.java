package parser.validate;

import exceptions.InvalidOverDetailsException;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class OverDetailsValidatorTest {
    @Test

    public void SholdValidateTheDetailOfOver() throws Exception {
        String OverData = "1 2 3 4 5 6 W w";

        OverDetailsValidator overDetailsValidator  =new OverDetailsValidator(OverData);
        Validators validators = new Validators() ;

        validators.add(overDetailsValidator);

        validators.validate();

        assertEquals(overDetailsValidator.getOversData(),OverData);

}

    @Test(expected = InvalidOverDetailsException.class)
    public void ShouldThrowExceptionWhenDataIsNotCorrect() throws Exception {
        String OverData = "1 2 3 4 5 6Ww M n ";

        OverDetailsValidator overDetailsValidator  =new OverDetailsValidator(OverData);
        Validators validators = new Validators() ;

        validators.add(overDetailsValidator);

        validators.validate();

        assertEquals(overDetailsValidator.getOversData(),OverData);




    }
}