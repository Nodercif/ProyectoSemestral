package Lógico.Animales;

import Lógico.Animal;
import Lógico.Habitat;

public class Ajolote extends Animal {
    public Ajolote(int metabolismo, int ferocidad, String nombre, Habitat habitat) {
        super(metabolismo,ferocidad,nombre,habitat);
    }
    public String getSonido() {
        return "gip";
    }
}
