package ui;

import Exceptions.notEnoughTimeException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, notEnoughTimeException {
        Schedule schedule = new Schedule();

        schedule.run();
    }

}
