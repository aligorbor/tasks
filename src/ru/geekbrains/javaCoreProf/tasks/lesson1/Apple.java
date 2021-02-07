package ru.geekbrains.javaCoreProf.tasks.lesson1;

public class Apple extends Fruit {
    public Apple(float weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "Apple{weight=" + this.getWeight() + "}";
    }
}
