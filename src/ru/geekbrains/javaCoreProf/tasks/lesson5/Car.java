package ru.geekbrains.javaCoreProf.tasks.lesson5;

public class Car implements Runnable {
    private static int CARS_COUNT;
    private static int FINISH_COUNT;

    static {
        CARS_COUNT = 0;
        FINISH_COUNT = 0;
    }

    private final Race race;
    private final int speed;
    private final String name;
    private int finishCount;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }

    @Override
    public void run() {
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int) (Math.random() * 800));
            System.out.println(this.name + " готов");
            race.getCbPrepare().await();
            race.getCdlStart().countDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < race.getStages().size(); i++) {
            race.getStages().get(i).go(this);
        }
        try {
            race.getLockWinner().lock();
            finishCount = ++FINISH_COUNT;
            if (finishCount == 1) {
                System.out.println(this.name + " " + finishCount + "-е место WIN!!!!!!!!");
            } else
                System.out.println(this.name + " " + finishCount + "-е место");
        } finally {
            race.getLockWinner().unlock();
        }
        race.getCdlFinish().countDown();
    }
}