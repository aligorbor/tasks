package ru.geekbrains.javaCoreProf.tasks.lesson5;

public class Road extends Stage {
    public Road(int length, int carsCount) {
        super(length, carsCount);
        this.description = "Дорога " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            smpLimit.acquire();
            System.out.println(c.getName() + " начал этап: " + description);
            Thread.sleep(length / c.getSpeed() * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(c.getName() + " закончил этап: " + description);
            smpLimit.release();
        }
    }
}
