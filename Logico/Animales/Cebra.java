package Logico.Animales;
import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;
public class Cebra extends Animal {
    public Cebra(Habitat habitat) {
        super(habitat);
        this.tempMax = 40;
        this.tempMin = 0;
        this.granditud = 90;
        this.comidaPreferida = TipoAlimento.FOLLAJE;
        this.humMax = 50;
        this.humMin = -10;
        this.ferocidad = 20;
        this.atractividad = 90;
    }
    @Override
    public String getSonido() {
        return "zee zee";
    }
    public String getEspecie(){ return "cebra"; }
    public int getPrecio(){ return 400;}
}