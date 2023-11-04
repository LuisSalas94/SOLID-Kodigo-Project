package org.solid.domain.designpatterns.observer;

public class AttendanceObserver implements Observer {

    @Override
    public void update() {
        System.out.println("The attendance was added");
    }
}
