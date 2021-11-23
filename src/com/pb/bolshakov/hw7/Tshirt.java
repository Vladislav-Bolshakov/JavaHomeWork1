package com.pb.bolshakov.hw7;


public class Tshirt extends Clothes implements ManClothes, WomenClothes {
    public Tshirt(Sizes size, String color) {
        super(size, color);
    }

    public Tshirt(Sizes size, String color, double cost) {
        super(size, color, cost);
    }

    public String toString() {
        return "Футболка{размер = " + this.getSize() + ", цена = " + this.getCost() + " грн, цвет = " + this.getColor() + "}";
    }
}
