package AdvanceedObjectOrientedDesign.ThucHanh.LopAnimalVaInterfaceEdible;

public class Chicken extends Animal implements Edible {
    @Override
    public String makeSound() {
        return "Chicken: chip-chip";
    }

    @Override
    public String howtoeat() {
        return "Could be fried";
    }
}
