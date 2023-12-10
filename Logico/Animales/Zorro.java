package Logico.Animales;
import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;

public class Zorro extends Animal {
    public Zorro(Habitat habitat) {
        super(habitat);
        this.tempMax = 24;
        this.tempMin = -5;
        this.granditud = 50;
        this.comidaPreferida = TipoAlimento.FRUTA;
        this.humMax = 20;
        this.humMin = -10;
        this.ferocidad = 50;
        this.atractividad = 100;
    }
    @Override
    public String getSonido() {
        return "jijiji";
    }
    public String getEspecie(){ return "zorro"; }
    public int getPrecio(){ return 700;}
}
