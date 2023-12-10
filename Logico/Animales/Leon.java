package Logico.Animales;
import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;
public class Leon extends Animal {
    public Leon(Habitat habitat) {
        super(habitat);
        this.tempMax = 40;
        this.tempMin = 0;
        this.granditud = 90;
        this.comidaPreferida = TipoAlimento.CARNE;
        this.humMax = -10;
        this.humMin = 50;
        this.ferocidad = 100;
        this.atractividad = 90;
    }
    @Override
    public String getSonido() {
        return "grrr";
    }
    public String getEspecie(){ return "leon"; }
    public int getPrecio(){ return 500;}
}
