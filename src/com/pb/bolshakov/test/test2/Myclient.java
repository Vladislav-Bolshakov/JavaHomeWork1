package com.pb.bolshakov.test.test2;


import java.io.InputStream;

import java.io.OutputStream;

import java.net.Socket;

import java.util.Scanner;


public class Myclient {

    public static void main(String[] args) {

        Myclient mc = new Myclient();

        mc.initClient();

    }


    public void initClient() {

        try {

// Создать клиентский объект

            Socket client = new Socket("localhost", 9090);

            // Получить входной и выходной поток клиента

            final InputStream ins = client.getInputStream();

            final OutputStream ous = client.getOutputStream();

            // Сначала получаем приветственное сообщение с сервера

            String msg = readMsg(ins);

            System.out.println(msg);

            // Получаем запрос от сервера на ввод имени пользователя

            String requestName = readMsg(ins);

            System.out.println(requestName);

            // Получить информацию об имени пользователя из консоли

            final Scanner scanner = new Scanner(System.in);

            String username = scanner.nextLine();

            // отправить имя пользователя

            sendMsg(ous, username + "\r\n");

            // читаем запрос пароля

            String requestPwd = readMsg(ins);

            System.out.println(requestPwd);

            // Сканирование пароля с консоли

            String pwd = scanner.nextLine();

            // отправить пароль на сервер

            sendMsg(ous, pwd + "\r\n");

            // Получить результат проверки

            String result = readMsg(ins);

            // Если вход не удался, примите сообщение с сервера

            while(!result.equals("ok")){

                // Получаем «Не удалось подключиться к серверу ...»

                String message=readMsg(ins);

                System.out.println(message);

                // Получаем «пожалуйста, проверьте ваше имя и пароль и войдите снова .....»

                message=readMsg(ins);

                System.out.println(message);

                // Получаем "пожалуйста, введите ваше имя:" "

                message=readMsg(ins);

                System.out.println(message);

                // Переслать имя пользователя на сервер

                username = scanner.nextLine();

                // отправить имя пользователя

                sendMsg(ous, username + "\r\n");

                // Принимаем запрос пароля "Пожалуйста, введите ваш пароль:"

                message=readMsg(ins);

                System.out.println(message);

                // Отправить пароль на сервер

                pwd = scanner.nextLine();

                // отправить имя пользователя

                sendMsg(ous, pwd + "\r\n");

                // Получаем информацию с сервера

                result = readMsg(ins);

            }

            // Если вход в систему успешен, вы можете начать общаться

            if (result.equals("ok")) {

                // System.out.println ("Вход в систему успешен");

                // Отправить ветку сообщений

                new Thread() {

                    public void run() {

                        try {

                            while (true) {

                                // Сканируем строку данных из консоли

                                String message = scanner.nextLine();

                                sendMsg(ous, message + "\r\n");

                            }

                        } catch (Exception e) {

                            e.printStackTrace();

                        }


                    };

                }.start();


                // Читать ветку сообщений

                new Thread() {

                    public void run() {

                        try {

                            while (true) {

                                String message = readMsg(ins);

                                System.out.println(message);

                            }

                        } catch (Exception e) {

                            e.printStackTrace();

                        }

                    };

                }.start();

            } else {

                System.out.println ("«Ошибка входа»");

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }


    public String readMsg(InputStream ins) throws Exception {

        int value = ins.read();

        String str = "";

        while (value != 10) {

            // От имени клиента заказ не закрыт должным образом

            if (value == -1) {

                throw new Exception();

            }

            str = str + (char) value;

            value = ins.read();

        }

        str = str.trim();

        return str;

    }


    // функция для отправки сообщения

    public void sendMsg(OutputStream ous, String str) throws Exception {

        byte[] bytes = str.getBytes();

        ous.write(bytes);

        ous.flush();

    }

}
