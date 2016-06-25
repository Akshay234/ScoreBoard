package exceptions;

public class InvalidOverDetailsException extends Exception {

    public InvalidOverDetailsException(String invalidData) {
        super(invalidData+" is a invalid data.");
    }
}
