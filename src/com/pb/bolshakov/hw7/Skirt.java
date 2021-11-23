package com.pb.bolshakov.hw7;

public class Skirt extends Clothes implements WomenClothes {
    public Skirt(Sizes size, String color) {
        super(size, color);
    }

    public Skirt(Sizes size, String color, double cost) {
        super(size, color, cost);
    }

    public String toString() {
        return "Юбка{размер = " + this.getSize() + ", цена = " + this.getCost() + " грн, цвет = " + this.getColor() + "}";
    }
}
