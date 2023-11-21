package Lógico.Animales;
import Lógico.Animal;
import Lógico.Habitat;

public class Coyote extends Animal {
    public Coyote(int metabolismo, int ferocidad, String nombre, Habitat habitat) {
        super(metabolismo,ferocidad,nombre,habitat);
    }
    @Override
    public String getSonido() {
        return "awoooo";
    }
}
