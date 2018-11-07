package Exceptions;

public class DateDoesNotExistException extends Throwable {
    public DateDoesNotExistException () {
        super("The date given does not currently exist...");
    }
}
