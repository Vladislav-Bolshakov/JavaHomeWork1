package com.pb.bolshakov.hw6;

import java.util.Objects;

public class Veterinarian {
    private String name;

    public Veterinarian(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            Veterinarian that = (Veterinarian)o;
            return Objects.equals(this.name, that.name);
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.name});
    }

    public String toString() {
        return "Veterinarian{name='" + this.name + '\'' + '}';
    }

    public void treatAnimal(Animal animal) {
        if (animal.getClass() == Cat.class) {
            System.out.println(((Cat)animal).getName() + " на лечении у ветиринара");
        }

        if (animal.getClass() == Dog.class) {
            System.out.println(((Dog)animal).getName() + " на лечении у ветиринара");
        }

        if (animal.getClass() == Horse.class) {
            System.out.println(((Horse)animal).getName() + " на лечении у ветиринара");
        }

    }
}
