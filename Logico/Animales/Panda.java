package Logico.Animales;
import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;

public class Panda extends Animal {
    public Panda(Habitat habitat) {
        super(habitat);
        this.tempMax = 30;
        this.tempMin = 0;
        this.granditud = 100;
        this.comidaPreferida = TipoAlimento.FOLLAJE;
        this.humMax = 20;
        this.humMin = -20;
        this.ferocidad = 80;
        this.atractividad = 150;
    }
    @Override
    public String getSonido() {
        return "grrr";
    }
    public String getEspecie(){ return "oso panda"; }
    public int getPrecio(){ return 1000;}
}
