package Lógico.Animales;

import Lógico.Animal;
import Lógico.Habitat;

public class Cebra extends Animal {
    public Cebra(int metabolismo, int ferocidad, String nombre, Habitat habitat) {
        super(metabolismo,ferocidad,nombre,habitat);
    }
    @Override
    public String getSonido() {
        return "gupiguip";
    }
}
