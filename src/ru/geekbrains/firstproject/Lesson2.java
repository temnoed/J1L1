package ru.geekbrains.firstproject;

import java.util.Arrays;

import static java.lang.Math.abs;

public class Lesson2 {

    public static void main  (String[] args) {

        // 1- меняем биты в массиве другна друга
        System.out.println ("Задача 1:");
        int[] bits = {0,1,1,1,1,1,0,0,0,0};
        System.out.println (Arrays.toString(bits));
        for (int i = 0; i < bits.length; i++) {
            bits[i] = abs(bits[i] - 1);
        }
        System.out.println (Arrays.toString(bits));

        // 2- заполняем 0,3,6,9,12,15,18,21
        System.out.println ("Задача 2:");
        int[] array2 = new int[8];
        for (int i = 0; i < 8; i++) {
            array2[i] = i * 3;
        }
        System.out.println (Arrays.toString(array2));

        // 3- [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ]
        System.out.println ("Задача 3:");
        int[] array3 = { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
        System.out.println (Arrays.toString(array3));
        for (int i = 0; i < array3.length; i++) {
            if (array3[i] < 6) {
                array3[i] *= 2;
            }
        }
        System.out.println (Arrays.toString(array3));

        // 4- заполнить диагональ квадрата
        System.out.println ("Задача 4:");
        int[][] array4 = new int[5][5];
        for (int i = 0; i < 5; i++) {
            array4[i][i] = 1;
        }
        System.out.println (Arrays.deepToString(array4));

        // 5-наибольший и наименьший элементы
        System.out.println ("Задача 5:");
        int[] array5 = {1,23,45,677,45,-5,-107,76,0};
        int keyMin = 0, keyMax = 0;
        System.out.println (Arrays.toString(array5));
        for (int i = 0; i < array5.length; i++) {
            if (array5[i] > array5[keyMax] ) {
                keyMax = i;
            }
            if (array5[i] < array5[keyMin] ) {
                keyMin = i;
            }
        }
        System.out.println ("Наибольший [" + keyMax + "] = " + array5[keyMax]);
        System.out.println ("Наименьший [" + keyMin + "] = " + array5[keyMin]);

        // 6- баланс
        System.out.println ("Задача 6:");
        int [] array6 ={1,2,3,4,5,6,21};
        System.out.println (Arrays.toString(array6));
        System.out.println (checkBalance(array6));

        // 7- смещение
        System.out.println ("Задача 7:");
        int [] array7 ={1,2,3,4,5,6,7,8,9,10};
        int [] array7Clone = array7.clone();
        int n = 2;
        System.out.println (Arrays.toString(array7));
        System.out.println (n);
        offset(array7, n); // смещаем
        System.out.println (Arrays.toString( array7 ));
        n = -2;
        System.out.println (n);
        offset(array7Clone, n); // смещаем
        System.out.println (Arrays.toString( array7Clone));
    }

    public static void offset(int[] arr, int a) { // метод "сдвиг массива" на (-+)a влево или вправо
        if (a < 0) {
            for (int i = abs(a); i < arr.length; i++) {
                arr[i + a] = arr[i];
                arr[i] = 0;
            }
        } else {
            for (int i = (arr.length - 1 - a); i >= 0; i--) {
                arr[i + a] = arr[i];
                arr[i] = 0;
            }
        }
    }

    public static boolean checkBalance (int [] arr) {
        if (arr.length < 2) return false;
        for (int i = 0; i < arr.length; i++ ) {
            if (elemSum(arr, 0, i) == elemSum(arr, ( i + 1), (arr.length - 1))) {
                return true;
            }
        }
        return false;
    }

    public static int elemSum (int [] arr, int a, int b) {
        int sum = 0;
        for ( int i = a; i <= b; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
