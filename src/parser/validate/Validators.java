package parser.validate;
import exceptions.InvalidOverDetailsException;
import exceptions.InvalidOverThresholdException;

import java.util.ArrayList;

public class Validators {
    private final ArrayList<Validator> validators;

    public Validators() {
        validators = new ArrayList<>();
    }

    public void add(Validator validator) {
        validators.add(validator);
    }

    public void validate() throws InvalidOverThresholdException, InvalidOverDetailsException {
        for (Validator validator : validators) {
            validator.validate();
        }
    }
}
