package com.google.example;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer observer) {
        if (observer == null) {
            throw new NullPointerException("observer is null");
        }
        if (!observers.contains(observer)) {
            observers.add(observer);
            System.out.println(observer.getName() + " registered");
        }
    }

    public void unregisterObserver(Observer observer) {
        observers.remove(observer);
        System.out.println(observer.getName() + " unregistered");
    }

    public void notifyObservers(List<Observer> observers) {
        for (Observer observer : observers) {
            observer.update();
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }

    public void setObservers(List<Observer> observers) {
        this.observers = observers;
    }
}
