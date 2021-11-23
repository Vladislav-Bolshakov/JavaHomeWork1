package com.pb.bolshakov.hw8;

import java.util.Scanner;

public class OnlineShop {
    public OnlineShop() {
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Auth auth = new Auth();

        while(true) {
            System.out.println();
            System.out.println("Добро пожаловать в Online Shop");
            System.out.println("1. Создайте пользователя");
            System.out.println("2. Войдите в учетку");
            System.out.println("Виберите действие");
            String option = scan.nextLine();
            byte var5 = -1;
            switch(option.hashCode()) {
                case 49:
                    if (option.equals("1")) {
                        var5 = 0;
                    }
                    break;
                case 50:
                    if (option.equals("2")) {
                        var5 = 1;
                    }
            }

            switch(var5) {
                case 0:
                    signUp(scan, auth);
                    break;
                case 1:
                    signIn(scan, auth);
            }
        }
    }

    private static void signUp(Scanner scan, Auth auth) {
        System.out.println("Введите логин: ");
        String login = scan.nextLine();
        System.out.println("Введите пароль: ");
        String password = scan.nextLine();
        System.out.println("Подтвердите пароль: ");
        String confirmPassword = scan.nextLine();

        try {
            auth.signUp(login, password, confirmPassword);
            System.out.println("Новый пользователь зарегистрирован!");
        } catch (WrongLoginException var6) {
            System.out.println("Ошибка входа: " + var6.getMessage());
        } catch (WrongPasswordException var7) {
            System.out.println("Не верный пароль: " + var7.getMessage());
        }

    }

    private static void signIn(Scanner scan, Auth auth) {
        System.out.println("Введите логин: ");
        String login = scan.nextLine();
        System.out.println("Введите пароль: ");
        String password = scan.nextLine();

        try {
            auth.signIn(login, password);
            System.out.println("Приветствую " + login);
        } catch (WrongLoginException var5) {
            System.out.println("Ошибка входа: " + var5.getMessage());
        }

    }
}
