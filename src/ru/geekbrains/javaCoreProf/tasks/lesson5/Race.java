package ru.geekbrains.javaCoreProf.tasks.lesson5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Race {
    private final ArrayList<Stage> stages;
    private final CyclicBarrier cbPrepare;
    private final CountDownLatch cdlStart;
    private final CountDownLatch cdlFinish;
    private final Lock lockWinner;

    public Lock getLockWinner() {
        return lockWinner;
    }

    public CyclicBarrier getCbPrepare() {
        return cbPrepare;
    }

    public CountDownLatch getCdlFinish() {
        return cdlFinish;
    }

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public CountDownLatch getCdlStart() {
        return cdlStart;
    }

    public Race(int carsCount, Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        cbPrepare = new CyclicBarrier(carsCount);
        cdlStart = new CountDownLatch(carsCount);
        cdlFinish = new CountDownLatch(carsCount);
        lockWinner = new ReentrantLock();
    }
}
