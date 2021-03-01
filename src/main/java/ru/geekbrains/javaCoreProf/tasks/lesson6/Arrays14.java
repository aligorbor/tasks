package ru.geekbrains.javaCoreProf.tasks.lesson6;

import java.util.Arrays;

public class Arrays14 {

    public static void main(String[] args) {
        int[] ar = {1, 2, 4, 4, 2, 3, 4, 1, 7};
        int[] ar1 = {4, 1, 1, 4, 4, 4, 4};

        Arrays14 arrays14 = new Arrays14();

        for (int a : arrays14.arrayAfter4(ar)) {
            System.out.println(a);
        }

        System.out.println(arrays14.arrayTrue14(ar1));

    }

    public int[] arrayAfter4(int[] ar) {
        for (int i = ar.length - 1; i > -1; i--) {
            if (ar[i] == 4) {
                if (ar.length - 1 - i > 0)
                    return Arrays.copyOfRange(ar, i + 1, ar.length);
                break;
            }
        }
        throw new RuntimeException("Ошибочные входные данные");
    }

    public boolean arrayTrue14(int[] ar) {
        boolean true4 = false;
        boolean true1 = false;

        for (int a : ar) {
            if (!(a == 1 || a == 4)) return false;
            if (a == 4) true4 = true;
            if (a == 1) true1 = true;
        }
        return true1 && true4;
    }


}


