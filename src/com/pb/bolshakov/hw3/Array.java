package com.pb.bolshakov.hw3;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Array {
    public Array() {
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        int[] a = new int[]{-5, 16, 7, -7, -9, 2, -1, 11, -5, 5};

        int sum;
        for(sum = 0; sum < a.length; ++sum) {
            System.out.println(a[sum]);
        }

                sum = IntStream.of(a).sum();
        System.out.println("Сумма всех элементов " + sum);
        boolean countNegative = false;
        int countPositive = 0;
        int[] var6 = a;
        int buf = a.length;

        int i;
        for(i = 0; i < buf; ++i) {
            int value = var6[i];
            if (value >= 0) {
                if (value <= 0) {
                    break;
                }

                ++countPositive;
            }
        }

        System.out.println("Положительных чисел:" + countPositive);
        boolean isSorted = false;

        while(!isSorted) {
            isSorted = true;

            for(i = 0; i < a.length - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    isSorted = false;
                    buf = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = buf;
                }
            }
        }

        System.out.println("Сортировка по возрастанию:");
        System.out.println(Arrays.toString(a));
    }
}
