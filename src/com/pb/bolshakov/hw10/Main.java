package com.pb.bolshakov.hw10;

public class Main {
    public static void main (String[] args) throws Exception{

        NumBox<Integer> objint = new NumBox<Integer>(4);

        try {
            objint.add( 0,4);
            objint.add(1,6);
            objint.add(2,2);

        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Массив переполнен.  " + objint.getSize());
      e.printStackTrace();
        }


        System.out.println(objint.get(1));
        System.out.println(objint.length());
    }

}
