package com.pb.bolshakov.hw7;


public class Pants extends Clothes implements ManClothes, WomenClothes {
    public Pants(Sizes size, String color) {
        super(size, color);
    }

    public Pants(Sizes size, String color, double cost) {
        super(size, color, cost);
    }

    public String toString() {
        return "Штаны{размер = " + this.getSize() + ", цена = " + this.getCost() + " грн, цвет = " + this.getColor() + "}";
    }
}
