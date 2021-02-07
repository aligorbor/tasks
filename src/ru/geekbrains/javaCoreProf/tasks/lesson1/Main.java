package ru.geekbrains.javaCoreProf.tasks.lesson1;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Задание 1");
        Integer[] ar1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        swapper(ar1, 0, 9);
        for (Integer i : ar1) {
            System.out.print(i + " ");
        }
        System.out.println();
        String[] ar2 = {"a", "b", "c", "d", "e", "f", "g"};
        swapper(ar2, 0, 6);
        for (String s : ar2) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println("Задание 2");
        ArrayList<Integer> alInt = convertToList(ar1);
        System.out.println(alInt);
        ArrayList<String> alStr = convertToList(ar2);
        System.out.println(alStr);
        ArrayList<String> alStr1 = convertToList1(ar2);
        alStr1.add("qq");
        System.out.println(alStr1);

        System.out.println("Задание 3");
        Box<Apple> box1 = new Box<>(new Apple(1f), new Apple(1.2f), new Apple(1.3f));
        System.out.println("Box1: " + box1);
        Box<Orange> box2 = new Box<>(new Orange(1.5f), new Orange(1.6f), new Orange(1.7f));
        System.out.println("Box2: " + box2);
        Box<Apple> box3 = new Box<>(new Apple(1f), new Apple(1.2f), new Apple(1.3f), new Apple(1.3f));
        System.out.println("Box3: " + box3);
        if (box2.compare(box1)) System.out.println("Вес коробок box2 и box1 одинаковый");
        if (box2.compare(box3)) System.out.println("Вес коробок box2 и box3 одинаковый");
        box1.addFruit(new Apple(1.3f));
        System.out.println("Box1: " + box1);
        if (box2.compare(box1)) System.out.println("Вес коробок box2 и box1 одинаковый");

        box1.moveToAnotherBox(box3);
        System.out.println("Box1: " + box1);
        System.out.println("Box3: " + box3);
        while (box3.isFull()) box3.removeFruit();
        System.out.println("Box3: " + box3);
    }

    //  1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    public static <E> void swapper(E[] arr, int ind1, int ind2) {
        E el = arr[ind1];
        arr[ind1] = arr[ind2];
        arr[ind2] = el;
    }

    // 2. Написать метод, который преобразует массив в ArrayList;
    public static <E> ArrayList<E> convertToList(E[] arr) {
        ArrayList<E> arrayList = new ArrayList<>();
        for (E el : arr) arrayList.add(el);
        return arrayList;
    }

    public static <E> ArrayList<E> convertToList1(E[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }


//   3. Есть классы Fruit -> Apple, Orange (больше фруктов не надо);
//    Класс Box, в который можно складывать фрукты. Коробки условно сортируются
//    по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
//    Для хранения фруктов внутри коробки можно использовать ArrayList;
//    Сделать метод getWeight(), который высчитывает вес коробки, зная количество
//    фруктов и вес одного фрукта (вес яблока – 1.0f, апельсина – 1.5f. Не важно, в каких это единицах);
//    Внутри класса Коробка сделать метод compare, который позволяет сравнить текущую
//    коробку с той, которую подадут в compare в качестве параметра, true – если она равны
//    по весу, false – в противном случае (коробки с яблоками мы можем сравнивать с коробками с апельсинами);
//    Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую
//    (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами).
//    Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты,
//    которые были в этой коробке;
//    Не забываем про метод добавления фрукта в коробку.


}




