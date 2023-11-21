package Lógico.Animales;
import Lógico.Animal;
import Lógico.Habitat;

public class Hormiguero extends Animal {
    public Hormiguero(int metabolismo, int ferocidad, String nombre, Habitat habitat) {
        super(metabolismo,ferocidad,nombre,habitat);
    }
    public String getSonido() {
        return null;//TODO
    }
}
