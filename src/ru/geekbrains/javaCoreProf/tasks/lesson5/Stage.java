package ru.geekbrains.javaCoreProf.tasks.lesson5;

import java.util.concurrent.Semaphore;

public abstract class Stage {
    protected int length;
    protected String description;
    protected Semaphore smpLimit;

    protected Stage(int length, int limitOfCars) {
        this.length = length;
        smpLimit = new Semaphore(limitOfCars);
    }

    public String getDescription() {
        return description;
    }

    public abstract void go(Car c);
}
