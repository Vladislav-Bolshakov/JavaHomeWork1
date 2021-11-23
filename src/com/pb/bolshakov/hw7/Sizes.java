package com.pb.bolshakov.hw7;

public enum Sizes {
    XXS(32) {
        public String getDescription() {
            return "Детский размер";
        }
    },
    XS(34),
    S(36),
    M(38),
    L(40);

    private int EuroSize;

    private Sizes(int getEuroSize) {
        this.EuroSize = getEuroSize;
    }

    public String getDescription() {
        return "взрослый размер";
    }

    public String toString() {
        return this.name() + "(" + this.EuroSize + ") " + this.getDescription();
    }
}
