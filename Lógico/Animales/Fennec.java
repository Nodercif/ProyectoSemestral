package Lógico.Animales;
import Lógico.Animal;
import Lógico.Habitat;

public class Fennec extends Animal {
    public Fennec(int metabolismo, int ferocidad, String nombre, Habitat habitat) {
        super(metabolismo,ferocidad,nombre,habitat);
    }
    @Override
    public String getSonido() {
        return "gupiguip";
    }
}
