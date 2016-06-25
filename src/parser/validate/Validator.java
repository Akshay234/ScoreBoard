package parser.validate;

import exceptions.InvalidOverDetailsException;
import exceptions.InvalidOverThresholdException;

public interface Validator {
     void validate() throws InvalidOverDetailsException, InvalidOverThresholdException;
}
