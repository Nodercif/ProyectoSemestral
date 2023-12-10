package Logico.Animales;
import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;
public class Flamenco extends Animal {
    public Flamenco(Habitat habitat) {
        super(habitat);
        this.tempMax = 25;
        this.tempMin = -10;
        this.granditud = 20;
        this.comidaPreferida = TipoAlimento.FOLLAJE;
        this.humMax = 100;
        this.humMin = -10;
        this.ferocidad = 10;
        this.atractividad = 90;
    }
    @Override
    public String getSonido() {
        return "guac guac";
    }
    public String getEspecie(){ return "flamenco"; }
    public int getPrecio(){ return 600;}
}