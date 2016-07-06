package exceptions;

public class InvalidOverDetailsException extends Exception {

    public InvalidOverDetailsException(String[] invalidData) {
        super("{ " + String.join(" ", invalidData) + " } is a invalid data.");
    }
}
