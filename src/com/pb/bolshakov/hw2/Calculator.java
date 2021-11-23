package com.pb.bolshakov.hw2;


import java.util.Scanner;

public class Calculator {
    public Calculator() {
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите первое число");
        int operand1 = scan.nextInt();
        System.out.print("Введите второе число");
        int operand2 = scan.nextInt();
        System.out.print("Что делаем(+-*/)?");
        String sign = scan.next();
        byte var6 = -1;
        switch(sign.hashCode()) {
            case 42:
                if (sign.equals("*")) {
                    var6 = 2;
                }
                break;
            case 43:
                if (sign.equals("+")) {
                    var6 = 0;
                }
            case 44:
            case 46:
            default:
                break;
            case 45:
                if (sign.equals("-")) {
                    var6 = 1;
                }
                break;
            case 47:
                if (sign.equals("/")) {
                    var6 = 3;
                }
        }

        switch(var6) {
            case 0:
                System.out.println(operand1 + operand2);
                break;
            case 1:
                System.out.println(operand1 - operand2);
                break;
            case 2:
                System.out.println(operand1 * operand2);
                break;
            case 3:
                System.out.println("ERROR. Делить на ноль нельзя");
                if (operand1 == 0) {
                }

                if (operand1 != 0) {
                }

                System.out.println(operand1 + "/" + operand2 + "=" + operand1 / operand2);
                break;
            default:
                System.out.println("Неверная операция");
        }

    }
}
