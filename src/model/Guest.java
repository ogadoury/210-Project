package model;

import java.util.Observable;
import java.util.Observer;

public class Guest implements Observer {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Hey, " + name + " your plan, " + o + " was cancelled.");
    }
}
