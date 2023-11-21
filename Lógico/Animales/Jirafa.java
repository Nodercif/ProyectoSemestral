package Lógico.Animales;
import Lógico.Animal;
import Lógico.Habitat;

public class Jirafa extends Animal {
    public Jirafa(int metabolismo, int ferocidad, String nombre, Habitat habitat) {
        super(metabolismo,ferocidad,nombre,habitat);
    }
    @Override
    public String getSonido() {
        return null;//TODO
    }
}
