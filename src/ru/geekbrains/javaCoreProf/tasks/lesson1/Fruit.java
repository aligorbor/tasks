package ru.geekbrains.javaCoreProf.tasks.lesson1;

public abstract class Fruit {
    private float weight;

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public Fruit(float weight) {
        this.weight = weight;
    }
}
