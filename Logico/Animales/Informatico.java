package Logico.Animales;
import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;
public class Informatico extends Animal {
    public Informatico(Habitat habitat) {
        super(habitat);
        this.tempMax = 100;
        this.tempMin = -100;
        this.granditud = 60;
        this.comidaPreferida = TipoAlimento.CARNE;
        this.humMax = 100;
        this.humMin = -100;
        this.ferocidad = 40;
        this.atractividad = 200;
    }
    @Override
    public String getSonido() {
        return "ñam ñam, grrrr";
    }
    public String getEspecie(){ return "informatico"; }
    public int getPrecio(){ return 5000;}
}
