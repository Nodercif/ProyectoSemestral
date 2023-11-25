package Lógico.Animales;
import Lógico.Animal;
import Lógico.Habitat;
import Lógico.TipoAlimento;

public class Zorro extends Animal {
    public Zorro(String nombre, Habitat habitat) {
        super(nombre,habitat);
        this.tempMax = 5;
        this.tempMin = -60;
        this.metabolismo = 50;
        this.comidaPreferida = TipoAlimento.PESCADO;
        this.humMax = 999999;
        this.humMin = 999999;
        this.ferocidad = 99999;
    }
    @Override
    public String getSonido() {
        return null;//TODO
    }
}
