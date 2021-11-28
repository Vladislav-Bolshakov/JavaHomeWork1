package com.pb.bolshakov.hw10;

public class NumBox <T extends Number> {

    private T number;

    public NumBox(int size) {

    }

    public T get(int i) {
        return number;
    }


    public void set(T number) {
        this.number = number;
    }

    public void add(T index, T num) {
    }

    public T getSize() {
        return null;
    }

    public boolean length() {
        return false;
    }

    public class Numbers<T extends Number> {

        private final T[] number;
        private int filled;


        public Numbers(int size) {

           this.number = (T[]) new Number[size];
        }

        public void set(int index, T number) {
            this.number[index] = number;
        }

        void add(T num) throws Exception {
            if (this.filled >= this.number.length) {
                throw new Exception("Array already filled!");
            }
            this.number[this.filled] = num;
            this.filled++;
        }

        public T get(int index) {
            return number[index];
        }

        int length() {
            return 0;

        }

        public double average() {
            double sum = 0.0;
            for (int i = 0; i < number.length; i++)
                sum += number[i].doubleValue();
            return sum / number.length;

        }

        public double sum() {
            double sum = 0.0;
            for (T i : number) {
                if (i == null) {
                    sum += 0;
                } else sum += i.doubleValue();
            }
            return sum;
        }


        public int max() {
            int[] a = new int[0];
            int max = a[0]; // saves a bit of time

            for (int j = 1; j < a.length; j++) {
                if (a[j] > max) {
                    max = a[j];
                }
            }
            return max;




}}}