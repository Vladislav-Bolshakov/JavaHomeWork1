package com.pb.bolshakov.hw13;

import com.oracle.jrockit.jfr.Producer;

import java.util.LinkedList;


public class Main {
    public static void main(String[] strings) {
        LinkedList<Double> sharedQueue = new LinkedList<>();

        int size = 3;

        Thread consThread = new Thread(new Consumer(sharedQueue), "Consumer");
//         Thread prodThread = new Thread(new Producer(sharedQueue, size),  "Producer");
//        prodThread.start();
        consThread.start();
}}