package com.pb.bolshakov.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TKServer extends JFrame implements ActionListener {
    private Map<Integer, Socket> clients = new HashMap<Integer, Socket>();
    private JTextArea msg = new JTextArea ("Приемник сообщений сервера \r \n \n");
    private JTextArea input = new JTextArea();
    private JButton msgSend = new JButton ("«Отправить групповое сообщение»");

    public TKServer() {
        // TODO Auto-generated constructor stub
        this.setVisible(true);
        this.setTitle ( "Сервер");
        this.setSize(550, 750);
        this.setResizable(true);
        this.setLayout(new FlowLayout());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                // TODO Auto-generated method stub
                super.windowClosing(arg0);
                System.exit(0);
            }
        });
        input.setColumns(40);
        input.setRows(5);
        input.setAutoscrolls(true);
        msgSend.addActionListener(this);
        msgSend.setActionCommand("sendMsg");
        msg.setAutoscrolls(true);
        msg.setColumns(40);
        msg.setRows(30);

        JScrollPane spanel = new JScrollPane(msg);
        JScrollPane editpanel = new JScrollPane(input);
        this.add(spanel);
        this.add(editpanel);
        this.add(msgSend);
    }

    public static void main(String[] args) {

        new TKServer().listenClient();
    }

    public void listenClient() {

        String temp = "";
        try {
            // Сервер пытается получать запросы на подключение от других сокетов, метод accept сервера блокирует
            // Определяем ServerSocket для прослушивания порта 8899
            ServerSocket server = new ServerSocket(8899);
            while (true) {
                System.out.println ("«Серверная сторона прослушивает»");
                Socket socket = server.accept();
                clients.put(socket.getPort(), socket);
                temp = "Client" + socket.getPort () + "Connect";
                this.apppendMsg(temp);
                new mythread(socket, this).start();
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public void apppendMsg(String msg) {

        this.msg.append(msg + "\r\n");
    }

    public void sendMsgToAll(Socket fromSocket, String msg) {

        Set<Integer> keset = this.clients.keySet();
        java.util.Iterator<Integer> iter = keset.iterator();
        while (iter.hasNext()) {
            int key = iter.next();
            Socket socket = clients.get(key);
            if (socket != fromSocket) {
                try {
                    if (socket.isClosed() == false) {
                        if (socket.isOutputShutdown() == false) {

                            Writer writer = new OutputStreamWriter(
                                    socket.getOutputStream());
                            writer.write(msg);
                            writer.flush();
                        }
                    }
                } catch (SocketException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        String temp = "";
        if ("sendMsg".equals(e.getActionCommand())) {
            if ((temp = this.input.getText()) != null) {
                System.out.println ("«Начать отправку сообщений клиентам»");
                this.apppendMsg ("Сервер ->" + temp);
                Set<Integer> keset = this.clients.keySet();
                java.util.Iterator<Integer> iter = keset.iterator();
                while (iter.hasNext()) {
                    int key = iter.next();
                    Socket socket = clients.get(key);
                    try {
                        Writer writer = new OutputStreamWriter(socket.getOutputStream());
                        writer.write(temp);
                        writer.flush();
                    } catch (SocketException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        // TODO Auto-generated catch block
                        e1.printStackTrace();
                    }
                }
                this.input.setText("");
            }
        }
    }
}

class mythread extends Thread {

    private Socket socket = null;
    private TKServer server = null;
    private InputStreamReader reader = null;
    char chars[] = new char[64];
    int len;
    private String temp = null;

    public mythread(Socket socket, TKServer server) {
        // TODO Auto-generated constructor stub

        this.socket = socket;
        this.server = server;
        init();
    }

    private void init() {

        try {
            reader = new InputStreamReader(socket.getInputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub

        System.out.println ("«Дочерний поток начинает работать»");
        while (true) {
            try {
                System.out.println ("Серверная нить" + this.getId () + "-> Начать чтение данных с клиента ->");
                while ((len = ((Reader) reader).read(chars)) != -1) {
                    temp = new String(chars, 0, len);
                    System.out.println ("«Клиент»" + socket.getPort () + "«скажем ->»" + temp);
                    server.apppendMsg ("client" + socket.getPort () + "say ->" + temp);
                    server.sendMsgToAll (this.socket, "client" + socket.getPort () + "say ->" + temp);
                }
                if (socket.getKeepAlive() == false) {
                    ((Reader) reader).close();
                    temp = "Client" + socket.getPort () + "-> Exit";
                    server.apppendMsg(temp);
                    socket.close();
                    this.stop();
                }
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
                try {
                    ((Reader) reader).close();
                    socket.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        }
    }
}
