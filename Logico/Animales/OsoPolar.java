package Logico.Animales;
import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;

public class OsoPolar extends Animal {
    public OsoPolar(Habitat habitat) {
        super(habitat);
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
    public String getEspecie(){ return "oso polar"; }
    public int getPrecio(){ return 1000;}
}
