package com.pb.bolshakov.test.test2;


import java.io.IOException;

import java.net.ServerSocket;

import java.net.Socket;

import java.util.ArrayList;


public class Myserver {


    public static ArrayList<ServerThread>list =new ArrayList<ServerThread>();

    public void initServer() {


        try {

            // Создать объект сервера и указать номер порта

            ServerSocket server = new ServerSocket(9090);

            System.out.println ("«Сервер был установлен ...»");

            // Постоянно получаем соединение клиента

            while(true){

                Socket socket =server.accept();

                System.out.println ("«Клиент подключается в ...»");

                // Когда клиент подключается, запускаем поток для обработки логики клиента,

                ServerThread st = new ServerThread(socket);

                st.start();

                // Добавить клиента в контейнер

                list.add(st);

            }

        } catch (Exception e) {

            e.printStackTrace();

        }


    }


}