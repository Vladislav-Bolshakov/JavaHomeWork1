package com.pb.bolshakov.test.test1;

import java.util.Queue;

class Consumer implements Runnable {
    // Общая очередь
    private final Queue<Double> sharedQueue;

    public Consumer(Queue<Double> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
                System.out.println("Consumed: " + consume());

            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }


    // Метод, извлекающий элементы из общей очереди
    private Double consume() throws InterruptedException {
        synchronized (sharedQueue) {
            if (sharedQueue.isEmpty()) { // Если пуста, надо ждать
                sharedQueue.wait();
            }

            sharedQueue.notifyAll();
            return sharedQueue.poll();
        }
    }
}