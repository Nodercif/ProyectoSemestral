package Lógico.Animales;
import Lógico.Animal;
import Lógico.Habitat;

public class OsoPolar extends Animal {
    public OsoPolar(int metabolismo, int ferocidad, String nombre, Habitat habitat) {
        super(metabolismo,ferocidad,nombre,habitat);
        this.tempMax = 5;
        this.tempMin = -60;
    }
    @Override
    public String getSonido() {
        return null;//TODO
    }
}
