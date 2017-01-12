package ru.geekbrains.firstproject;

public class MainClassOld {

    // Создаём простой метод main
    public static void main (String[] args) {
        System.out.println("Hellow, Programmer!");

        // Инициализируем переменные всех типов
        final byte a = 1;
        short b = 2000;
        int c = 300000;
        long d = 400000L;
        float e = 5.0f;
        double f = 6.5346563;
        boolean g = false;
        char h = 'x';

        // выводим результаты
        System.out.println("Задание 3:");
        System.out.println("При a,b,c,d = 1,2,3,4, a*(b+(c/d))=" + result(1,2,3,4));
        System.out.println("Задание 4:");
        System.out.println("Сумма 2 + 9 входит между 10 и 20 ? - " + vnutri_10_20(2,9));
        System.out.println("Задание 5:");
        numberSign(-4);
        System.out.println("Задание 6:");
        System.out.println("Посылаем число 20, результат - " + isNegative(20));
        System.out.println("Задание 7:");
        helloName("Агафон");
        System.out.println("Задание 8:");
        bissextus(2017);

    }

    // методом вычисляем a * (b + (c / d)
    public static float result (float a, float b, float c, float d) {
        return (a * (b + (c / d)));
    }

    // методом вычисляем входит ли сумма a и b между 10 и 20 вкл.
    public static boolean vnutri_10_20 (int a, int b) {
        if ((a + b) >= 10 && (a + b) <= 20) {
            return true;
        } else {
            return  false;
        }
    }

    // метод определяет знак числа
    public static  void numberSign (int a) {
        if (a < 0) {
            System.out.println("Число " + a + " отрицательное.");
        } else {
            System.out.println("Число " + a + " положительное.");
        }
    }

    // метод возвращает true если число отрицательное
    public static  boolean isNegative (int a) {
        if (a < 0) {
            return true;
        } else {
            return false;
        }
    }

    //метод выводит Привет, Имя!
    public  static void helloName (String name) {
        System.out.println("Привет, " + name);
    }

    // високосный ?
    public static void bissextus(int year) {
        if ((year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0))) {
            System.out.println("Год " + year + " - високосный.");
        } else {
            System.out.println("Год  " + year + " - НЕвисокосный.");
        }
    }
}