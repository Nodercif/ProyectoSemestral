package Lógico.Animales;

import Lógico.Animal;
import Lógico.Habitat;

public class Camello extends Animal {
    public Camello(int metabolismo, int ferocidad, String nombre, Habitat habitat) {
        super(metabolismo,ferocidad,nombre,habitat);
    }
    @Override
    public String getSonido() {
        return "brrr";
    }

}
