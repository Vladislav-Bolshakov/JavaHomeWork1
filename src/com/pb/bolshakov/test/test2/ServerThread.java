package com.pb.bolshakov.test.test2;


import java.io.IOException;

import java.io.InputStream;

import java.io.OutputStream;

import java.net.Socket;


public class ServerThread extends Thread {


    public Socket socket;

    public InputStream ins;

    public OutputStream ous;


    public ServerThread(Socket socket) {

        this.socket = socket;

    }


    public void run() {

        try {

            // Получить поток ввода и вывода

            ins = socket.getInputStream();

            ous = socket.getOutputStream();

            // отправить сообщение клиенту

            String msg = "welcome to zhou's server !";

            sendMsg(ous, msg);

            // Отправить клиенту информацию для входа

            String userinfo = "please input your name:";

            sendMsg(ous, userinfo);

            // Получить имя пользователя, введенное клиентом

            String userName = readMsg(ins);

            // Отправить клиенту необходимую информацию о пароле

            String pwd = "please input your password:";

            sendMsg(ous, pwd);

            // Получить пароль, введенный клиентом

            String pass = readMsg(ins);

            // Подтверждение входа

            boolean falg = loginCheck(userName, pass);

            // Когда проверка не проходит, проверка цикла

            while (!falg) {

                msg="no";

                sendMsg(ous, msg);

                msg = "Fail to connect server......";

                sendMsg(ous, msg);

                msg = "please check your name and password and login again.....";

                sendMsg(ous, msg);

                msg = "please input your name:";

                sendMsg(ous, msg);

                // Получить имя пользователя, введенное клиентом

                userName = readMsg(ins);

                // Отправить клиенту необходимую информацию о пароле

                msg = "please input your password:";

                sendMsg(ous, msg);

                // Получить пароль, введенный клиентом

                pass = readMsg(ins);

                falg = loginCheck(userName, pass);

            }


            // Отправить успешный результат входа клиенту

            msg="ok";

            sendMsg(ous, msg);

            // После успешной проверки: начать общаться

            msg = "successful connected..... you can chat with your friends now ......";

            sendMsg(ous, msg);

            // Логика обработки чата

            // Читаем сообщение от клиента

            msg=readMsg(ins);

            System.out.println ("«Клиент получил сообщение:«" + msg);

            // Введите пока, чтобы закончить чат

            while(!"bye".equals(msg)){

                // Для каждого объекта в контейнере переслать сообщение

                for (int i = 0; i <Myserver.list.size(); i++) {

                    ServerThread st =Myserver.list.get(i);

                    // Не следует пересылать сообщение самостоятельно

                    if(st!=this){

                        System.out.println ("Переслать сообщение ...");

                        sendMsg(st.ous, userName+" is say:"+msg);

                        System.out.println ("«Успешно отправлено сообщение ...»");

                    }

                }

                // ждем, чтобы прочитать следующее сообщение

                msg=readMsg(ins);

            }


        } catch (Exception e) {

            System.out.println ("«Клиент неправильно закрыт ...»");

// e.printStackTrace();

        }

        // Поток закрывается после исключения

        try {

            ins.close();

            ous.close();

            socket.close();

            // Удалить в данный момент закрытого клиента из контейнера

            Myserver.list.remove(this);

        } catch (IOException e) {

// TODO Auto-generated catch block

            e.printStackTrace();

        }

    }


    // Функция проверки номера счета и пароля, введенных клиентом, поскольку базы данных нет, она временно записана как мертвая

    public boolean loginCheck(String name, String pwd) {

        if (name.equals("zhou") && pwd.equals("zhou") || name.equals("user") && pwd.equals("pwd")

                || name.equals("huaxinjiaoyu") && pwd.equals("huaxinjiaoyu")) {


            return true;

        }

        return false;

    }


    // функция для отправки сообщения

    public void sendMsg(OutputStream os, String s) throws IOException {

        // выводим информацию клиенту

        byte[] bytes = s.getBytes();

        os.write(bytes);

        os.write(13);

        os.write(10);

        os.flush();


    }


    // функция для чтения входных данных с клиента

    public String readMsg(InputStream ins) throws Exception {

        // Чтение информации о клиенте

        int value = ins.read();

        // Читаем всю строку и прекращаем чтение, когда считываются возврат каретки (13) и перевод строки (10)

        String str = "";

        while (value != 10) {

            // Значение -1 будет возвращено при нажатии, чтобы закрыть клиент

            if (value == -1) {

                throw new Exception();

            }

            str = str + ((char) value);

            value = ins.read();

        }

        str = str.trim();

        return str;

    }


}

