package com.pb.bolshakov.hw6;

import java.util.Objects;

public class Dog extends Animal {
    private String name;

    public Dog(String location, String color, String food, String name) {
        super(location, color, food);
        this.name = name;
    }

    public String toString() {
        return "Dog{по имени:'" + this.name + '\'' + '}';
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Dog dog = (Dog)o;
            return Objects.equals(this.name, dog.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name});
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String mareNoise() {
        return "Шумит";
    }

    public void eat() {
        System.out.println("Ест");
    }

    public void sleep() {
        System.out.println("Спать");
    }
}
