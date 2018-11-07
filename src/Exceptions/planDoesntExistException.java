package Exceptions;

public class planDoesntExistException extends Exception {
    public planDoesntExistException () { super("The plan does not exist."); }
}
