package Lógico;

import java.util.ArrayList;

public class Habitat {
    private int temperatura;
    private int humedad;
    private ArrayList<Animal> animal;
    private ArrayList<Alimento> alimento;
    public Habitat() {

    }
    public void addAnimal(Animal animal) {
    }
    public void removeAnimal(Animal animal) {
    }
    public static void moverAnimal(Habitat habitat1, Habitat habitat2, Animal animal) {
        habitat1.removeAnimal(animal);
        habitat2.addAnimal(animal);
        animal.setHabitat(habitat2);
    }
}
