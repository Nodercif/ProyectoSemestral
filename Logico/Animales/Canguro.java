package Logico.Animales;
import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;
public class Canguro extends Animal {
    public Canguro(Habitat habitat) {
        super(habitat);
        this.tempMax = 50;
        this.tempMin = -5;
        this.granditud = 80;
        this.comidaPreferida = TipoAlimento.FOLLAJE;
        this.humMax = 30;
        this.humMin = -100;
        this.ferocidad = 50;
        this.atractividad = 150;
    }
    @Override
    public String getSonido() {
        return "guar guar";
    }
    public String getEspecie(){ return "canguro"; }
    public int getPrecio(){ return 900;}
}
