package com.pb.bolshakov.hw7;

public class DressMakingStudio {
    public DressMakingStudio() {
    }

    public void dressMan(Clothes[] clothes) {
        System.out.println("Мужская одежда в наличии:");
        Clothes[] var2 = clothes;
        int var3 = clothes.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Clothes clothe = var2[var4];
            if (clothe instanceof ManClothes) {
                System.out.println(clothe);
            }
        }

    }

    public void dressWomen(Clothes[] clothes) {
        System.out.println("Женская одежда в наличии:");
        Clothes[] var2 = clothes;
        int var3 = clothes.length;

        for(int var4 = 0; var4 < var3; ++var4) {
            Clothes clothe = var2[var4];
            if (clothe instanceof WomenClothes) {
                System.out.println(clothe);
            }
        }

    }
}
