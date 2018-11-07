package Exceptions;

public class InvalidInputException extends Exception {
    public InvalidInputException () {
        super("The input you gave is invalid for this particular function");
    }
}
