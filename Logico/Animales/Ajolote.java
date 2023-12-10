package Logico.Animales;
import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;
public class Ajolote extends Animal {
    public Ajolote(Habitat habitat) {
        super(habitat);
        this.tempMax = 25;
        this.tempMin = -10;
        this.granditud = 20;
        this.comidaPreferida = TipoAlimento.CARNE;
        this.humMax = 100;
        this.humMin = -10;
        this.ferocidad = 10;
        this.atractividad = 70;
    }
    @Override
    public String getSonido() {
        return "bip bip";
    }
    public String getEspecie(){ return "ajolote"; }
    public int getPrecio(){ return 300;}
}
