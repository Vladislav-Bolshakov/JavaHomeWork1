package com.pb.bolshakov.hw7;


public class Tie extends Clothes implements ManClothes {
    public Tie(Sizes size, String color) {
        super(size, color);
    }

    public Tie(Sizes size, String color, double cost) {
        super(size, color, cost);
    }

    public String toString() {
        return "Галстук{размер = " + this.getSize() + ", цена = " + this.getCost() + " грн, цвет = " + this.getColor() + "}";
    }
}
