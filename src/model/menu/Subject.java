package model.menu;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    public void add(Observer o) {
        observers.add(o);
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void execute(){
        for(Observer observer: observers){
            observer.update();
        }
    }

}
