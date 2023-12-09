package Logico.Animales;
import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;

public class Zorro extends Animal {
    public Zorro(Habitat habitat) {
        super(habitat);
        this.tempMax = 5;
        this.tempMin = -60;
        this.granditud = 50;
        this.comidaPreferida = TipoAlimento.PESCADO;
        this.humMax = 999999;
        this.humMin = 999999;
        this.ferocidad = 99999;
    }
    @Override
    public String getSonido() {
        return null;//TODO
    }
    public String getEspecie(){ return "zorro"; }
    public int getPrecio(){ return 800;}
}
