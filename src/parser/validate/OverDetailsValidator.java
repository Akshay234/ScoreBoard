package parser.validate;

import exceptions.InvalidOverDetailsException;

public class OverDetailsValidator extends Validator {

    private String oversData;

    public OverDetailsValidator(String oversData) {
        this.oversData = oversData;
    }

    private String[] formattedData() {
        return oversData.trim().replaceAll(" +", " ").split(" ");
    }

    @Override
    public void validate() throws InvalidOverDetailsException {
        String validator = "[0-9]+|W|w";

        for (String ballValue : formattedData()) {
            if (!ballValue.matches(validator)) {
                throw new InvalidOverDetailsException(oversData);
            }
        }
    }

    public String getOversData() {
        return oversData;
    }
}
