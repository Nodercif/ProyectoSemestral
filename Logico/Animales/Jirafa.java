package Logico.Animales;
import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;

public class Jirafa extends Animal {
    public Jirafa(Habitat habitat) {
        super(habitat);
        this.tempMax = 30;
        this.tempMin = 0;
        this.granditud = 100;
        this.comidaPreferida = TipoAlimento.FOLLAJE;
        this.humMax = 20;
        this.humMin = -20;
        this.ferocidad = 20;
        this.atractividad = 250;
    }
    @Override
    public String getSonido() {
        return "guac";
    }
    public String getEspecie(){ return "jirafa"; }
    public int getPrecio(){ return 800;}
}
