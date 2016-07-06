package parser.validate;

import exceptions.InvalidOverDetailsException;

public class OverDetailsValidator extends Validator {

    private String[] oversData;

    public OverDetailsValidator(String[] oversData) {
        this.oversData = oversData;
    }

    @Override
    public void validate() throws InvalidOverDetailsException {
        String validator = "[0-9]+|W|w";

        for (String ballValue : oversData) {
            if (!ballValue.matches(validator)) {
                throw new InvalidOverDetailsException(oversData);
            }
        }
    }
}
