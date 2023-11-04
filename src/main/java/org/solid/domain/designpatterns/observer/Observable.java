package org.solid.domain.designpatterns.observer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Observable {
    private List<Observer> observerList = new ArrayList<>();

    public void addObserver(Observer observer){
        observerList.add(observer);
    }

    public void deleteObserver(Observer observer){
        observerList.remove(observer);
    }

    protected void notifyObservers(){
        for (Observer observer : observerList){
            observer.update();
        }
    }

}
