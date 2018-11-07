package Exceptions;

public class notEnoughTimeException extends Exception {
    public notEnoughTimeException () {
        super("You do not have enough time left in the day to make the plan");
    }
}
