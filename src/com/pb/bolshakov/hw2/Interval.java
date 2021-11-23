package com.pb.bolshakov.hw2;

import java.util.Scanner;

public class Interval {
    private static Scanner in;

    public Interval() {
    }

    public static void main(String[] args) {
        byte a = 0;
        byte b = 14;
        byte d = 15;
        byte e = 35;
        byte f = 36;
        byte g = 50;
        byte h = 51;
        byte j = 100;
        System.out.print("\nВведите число: ");
        in = new Scanner(System.in);
        byte x = in.nextByte();
        if (x >= a && x <= b) {
            System.out.print("Число " + x + "  в интервал от " + a + " до " + b + "\n");
        } else if (x >= d && x <= e) {
            System.out.print("Число " + x + "  в интервал от " + d + " до " + e + "\n");
        } else if (x >= f && x <= g) {
            System.out.print("Число " + x + "  в интервал от " + f + " до " + g + "\n");
        } else if (x >= h && x <= j) {
            System.out.print("Число " + x + "  в интервал от " + h + " до " + j + "\n");
            System.out.print("Число " + x + " является отрицательным");
            System.out.print("Ваше число " + x + " не попадает ни в один интервал");
        } else if (x <= j) {
            System.out.print("Ваше число " + x + " является отрицательным");
        }

    }
}
