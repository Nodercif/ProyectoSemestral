package Lógico.Animales;

import Lógico.Animal;
import Lógico.Habitat;

public class León extends Animal {
    protected static final int tempMax = 40;
    public León(int metabolismo, int ferocidad, String nombre, Habitat habitat) {
        super(metabolismo,ferocidad,nombre,habitat);
    }
    @Override
    public String getSonido() {
        return null;//TODO
    }
}
