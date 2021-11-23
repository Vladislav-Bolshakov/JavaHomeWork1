package com.pb.bolshakov.hw7;

public abstract class Clothes {
    private Sizes size;
    private String color;
    private double cost;

    public Clothes(Sizes size, String color) {
        this.size = size;
        this.color = color;
    }

    public Clothes(Sizes size, String color, double cost) {
        this(size, color);
        this.cost = cost;
    }

    public Sizes getSize() {
        return this.size;
    }

    public String getColor() {
        return this.color;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (!(o instanceof Clothes)) {
            return false;
        } else {
            Clothes clothes = (Clothes)o;
            if (Double.compare(clothes.cost, this.cost) != 0) {
                return false;
            } else {
                return this.size != clothes.size ? false : this.color.equals(clothes.color);
            }
        }
    }

    public int hashCode() {
        int result = this.size.hashCode();
        long temp = Double.doubleToLongBits(this.cost);
        result = 31 * result + (int)(temp ^ temp >>> 32);
        result = 31 * result + this.color.hashCode();
        return result;
    }
}

