package com.pb.bolshakov.hw10;


public class Main {
    public static void main(String[] args) throws Exception {

        NumBox<Float> object = new NumBox<Float>(5);

        object.add(0.4f);
        object.add(1.6f);
        object.add(2.2f);
        object.add(3.8f);
        object.add(4.5f);
        println(object);


        NumBox<Integer> integers = new NumBox<Integer>(5);
        integers.add(8);
        integers.add(4);
        integers.add(5);
        integers.add(2);
        integers.add(-1);
        println(integers);

    }
    private static void println(NumBox<?> numBox) {
        int length = numBox.length();

        System.out.println();
        for (int i = 0; i < length; i++) {
            System.out.print(numBox.get(i) + "; ");
        }
        System.out.println();

        System.out.println("Sum: " + numBox.sum());
        System.out.println("Avg: " + numBox.average());
        System.out.println("Max: " + numBox.max());
    }
}
