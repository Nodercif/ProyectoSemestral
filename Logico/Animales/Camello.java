package Logico.Animales;
import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;
public class Camello extends Animal {
    public Camello(Habitat habitat) {
        super(habitat);
        this.tempMax = 50;
        this.tempMin = 0;
        this.granditud = 90;
        this.comidaPreferida = TipoAlimento.FOLLAJE;
        this.humMax = 10;
        this.humMin = -100;
        this.ferocidad = 20;
        this.atractividad = 150;
    }
    @Override
    public String getSonido() {
        return "guap guap";
    }
    public String getEspecie(){ return "camello"; }
    public int getPrecio(){ return 800;}
}
