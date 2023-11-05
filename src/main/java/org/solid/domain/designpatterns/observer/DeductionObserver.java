package org.solid.domain.designpatterns.observer;

public class DeductionObserver implements Observer{
    @Override
    public void update() {
        System.out.println("The salary deduction has been calculated. Carrying out corresponding actions...");
    }
}
