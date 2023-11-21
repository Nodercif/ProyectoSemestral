package Lógico.Animales;
import Lógico.Animal;
import Lógico.Habitat;

public class ZorroBlanco extends Animal {
    public ZorroBlanco(int metabolismo, int ferocidad, String nombre, Habitat habitat) {
        super(metabolismo,ferocidad,nombre,habitat);
    }
    @Override
    public String getSonido() {
        return null;//TODO
    }
}
