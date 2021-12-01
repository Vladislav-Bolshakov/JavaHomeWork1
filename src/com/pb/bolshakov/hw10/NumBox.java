package com.pb.bolshakov.hw10;

public class NumBox <T extends Number> {

    private  T[] numbers;
    private T[] max;
    private int size = 0;
    private int filled;

    public void set(int index, T number) {
        this.numbers[index] = number;
    }

    public NumBox(int maxSize) {
        if (maxSize <= 0) {
            throw new IllegalArgumentException("Параметр maxSize должен быть > 0");
        }
        numbers = (T[]) new Number[maxSize];
    }

    public void add(T num) throws Exception {
            if (this.filled >= this.numbers.length) {
                throw new Exception("Массив переполнен!");
            }
            this.numbers[this.size] = num;
            this.size++;
    }


        public T get(int index) {
            if (index >= size) {
                return null;
            }

            return numbers[index];
        }

    public int length(){
        int size = 0;
        for(T i : numbers){
            if(!(i == null)){
                size++;
            } else size+=0;
        }
            return size;
    }

    public double sum() {
        double sum = 0.0;
        for (T i : numbers) {
            if (i == null) {
                sum += 0;
            } else sum += i.doubleValue();
        }
        return sum;
    }
        public double average() {
            double sum = 0.0;
            for (int i = 0; i < numbers.length; i++)
                sum += numbers[i].doubleValue();

            return sum / numbers.length;
        }

    public T max(){
        T max = numbers[0];
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i].doubleValue() > max.doubleValue()) {
                max = numbers[i];
            }
        }
        return max;
    }
}