package parser.validate;

import exceptions.InvalidOverDetailsException;
import exceptions.InvalidOverThresholdException;

public abstract class Validator {
    void validate() throws InvalidOverDetailsException, InvalidOverThresholdException {}
}
