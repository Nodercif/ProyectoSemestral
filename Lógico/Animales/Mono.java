package Lógico.Animales;
import Lógico.Animal;
import Lógico.Habitat;

public class Mono extends Animal {
    public Mono(int metabolismo, int ferocidad, String nombre, Habitat habitat) {
        super(metabolismo,ferocidad,nombre,habitat);
    }
    @Override
    public String getSonido() {
        return null;//TODO
    }
}
