package com.pb.bolshakov.test.test1;


import java.util.LinkedList;

public class main {
    public static void main(String[] strings) throws InterruptedException {

        LinkedList<Double> sharedQueue = new LinkedList<>();
        int size = 2;
        Thread prodThread = new Thread(new Producer(sharedQueue, size), "Producer");
        Thread consThread = new Thread(new Consumer(sharedQueue), "Consumer");

        prodThread.start();

        consThread.start();

}}