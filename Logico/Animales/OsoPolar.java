package Logico.Animales;
import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;

public class OsoPolar extends Animal {
    public OsoPolar(Habitat habitat) {
        super(habitat);
        this.tempMax = 20;
        this.tempMin = -60;
        this.granditud = 100;
        this.comidaPreferida = TipoAlimento.PESCADO;
        this.humMax = 100;
        this.humMin = 20;
        this.ferocidad = 100;
    }
    @Override
    public String getSonido() {
        return null;//TODO
    }
    public String getEspecie(){ return "oso polar"; }
    public int getPrecio(){ return 1000;}
}
