package com.pb.bolshakov.hw7;

public class Atelier {
    public Atelier() {
    }

    public static void main(String[] args) {
        Clothes[] clothes = new Clothes[]{new Tshirt(Sizes.XS, "темно-коричнеый", 450.0D), new Tshirt(Sizes.L, "болый", 340.0D), new Pants(Sizes.M, "черный", 550.0D), new Pants(Sizes.XXS, "синий", 250.0D), new Skirt(Sizes.S, "голубой", 450.0D), new Skirt(Sizes.M, "красный", 600.0D), new Tie(Sizes.L, "синий", 320.0D), new Tie(Sizes.L, "жёлтый", 370.0D)};
        DressMakingStudio studio = new DressMakingStudio();
        studio.dressMan(clothes);
        System.out.println();
        studio.dressWomen(clothes);
        System.out.println();
    }
}
