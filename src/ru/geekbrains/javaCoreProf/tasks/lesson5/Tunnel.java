package ru.geekbrains.javaCoreProf.tasks.lesson5;

public class Tunnel extends Stage {
    public Tunnel(int length, int carsCount) {
        super(length, carsCount);
        this.description = "Тоннель " + length + " метров";
    }

    @Override
    public void go(Car c) {
        try {
            try {
                System.out.println(c.getName() + " готовится к этапу(ждет): " + description);
                smpLimit.acquire();
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(c.getName() + " закончил этап: " + description);
                smpLimit.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
