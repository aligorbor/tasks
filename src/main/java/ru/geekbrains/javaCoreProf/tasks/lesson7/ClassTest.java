package ru.geekbrains.javaCoreProf.tasks.lesson7;

public class ClassTest {

    @BeforeSuite
    public void init() {
        System.out.println("Тест начался");
    }

    //    @BeforeSuite
//    public void init1(){
//        System.out.println("Тест начался");
//    }

    @AfterSuite
    public void end() {
        System.out.println("Тест закончен");
    }

    //    @AfterSuite
//    public void end1(){
//        System.out.println("Тест закончен");
//    }

    @Test(priority = 3)
    public void test1() {
        System.out.println("Выполняется тест 1");
    }

    @Test(priority = 7)
    public void test2() {
        System.out.println("Выполняется тест 2");
    }

    @Test(priority = 10)
    public void test3() {
        System.out.println("Выполняется тест 3");
    }

    @Test
    public void test4() {
        System.out.println("Выполняется тест 4");
    }

    @Test(priority = 5)
    public void test5() {
        System.out.println("Выполняется тест 5");
    }

    @Test(priority = 4)
    public void test6() {
        System.out.println("Выполняется тест 6");
    }

    @Test(priority = 6)
    public void test7() {
        System.out.println("Выполняется тест 7");
    }

    @Test(priority = 3)
    public void test8() {
        System.out.println("Выполняется тест 8");
    }

    @Test(priority = 8)
    public void test9() {
        System.out.println("Выполняется тест 9");
    }

    @Test(priority = 3)
    public void test10() {
        System.out.println("Выполняется тест 10");
    }

}
