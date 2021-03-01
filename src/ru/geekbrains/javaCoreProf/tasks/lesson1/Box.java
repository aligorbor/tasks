package ru.geekbrains.javaCoreProf.tasks.lesson1;

import java.util.ArrayList;

public class Box<E extends Fruit> {
    private ArrayList<E> fruits = null;
    private float weight = 0;
    private int countFruit = 0;

    @SafeVarargs
    public Box(E... fruit) {
        for (E e : fruit) {
            this.addFruit(e);
        }
    }

    public void addFruit(E fruit) {
        if (fruits == null) {
            fruits = new ArrayList<>();
        }
        fruits.add(fruit);
        weight += fruit.getWeight();
        countFruit++;
    }

    public E removeFruit() {
        if (countFruit > 0) {
            countFruit--;
            weight -= fruits.get(fruits.size() - 1).getWeight();
            return fruits.remove(fruits.size() - 1);
        } else return null;
    }

    public float getWeight() {
        return weight;
    }

    public boolean isFull() {
        return countFruit > 0;
    }

    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    public void moveToAnotherBox(Box<E> anotherBox) {
        while (this.isFull()) {
            anotherBox.addFruit(this.removeFruit());
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("Box{" +
                "weight=%.2f, countFruit=" + countFruit +
                "} contains: ");
        for (Fruit f : fruits) {
            str.append(f.toString()).append(" ");
        }
        return String.format(str.toString(), this.getWeight());
    }
}
