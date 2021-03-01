package ru.geekbrains.javaCoreProf.tasks.lesson7;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Tester {

    public static void start(String testClassName) throws RuntimeException {
        try {
            start(Class.forName(testClassName));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void start(Class testClass) throws RuntimeException {
        Method[] methods = testClass.getDeclaredMethods();
        HashMap<Integer, ArrayList<Method>> hm = new HashMap<>();
        Method methodBeforeSuite = null;
        Method methodAfterSuite = null;

        for (Method method : methods) {
            if (method.isAnnotationPresent(BeforeSuite.class)) {
                if (methodBeforeSuite == null) {
                    methodBeforeSuite = method;
                } else
                    throw new RuntimeException("Аннотация @BeforeSuite должна быть в единственном экземпляре");
            }
            if (method.isAnnotationPresent(AfterSuite.class)) {
                if (methodAfterSuite == null) {
                    methodAfterSuite = method;
                } else
                    throw new RuntimeException("Аннотация @AfterSuite должна быть в единственном экземпляре");
            }
            if (method.isAnnotationPresent(Test.class)) {
                int priority = method.getAnnotation(Test.class).priority();
                if (!hm.containsKey(priority)) {
                    ArrayList<Method> al = new ArrayList<>();
                    hm.put(priority, al);
                }
                hm.get(priority).add(method);
            }
        }

        try {
            Object classTest = testClass.newInstance();
            if (methodBeforeSuite != null)
                methodBeforeSuite.invoke(classTest);
            for (Map.Entry<Integer, ArrayList<Method>> e : hm.entrySet()) {
                ArrayList<Method> al = e.getValue();
                for (Method m : al) {
                    m.setAccessible(true);
                    System.out.println("Приоритет: " + e.getKey());
                    m.invoke(classTest);
                }
            }
            if (methodAfterSuite != null)
                methodAfterSuite.invoke(classTest);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try {
            Tester.start(ClassTest.class);
            //    Tester.start("ru.geekbrains.javaCoreProf.tasks.lesson7.ClassTest");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
