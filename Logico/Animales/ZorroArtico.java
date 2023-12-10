package Logico.Animales;

import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;

public class ZorroArtico extends Animal {
    public ZorroArtico(Habitat habitat) {
        super(habitat);
        this.tempMax = 25;
        this.tempMin = -60;
        this.granditud = 50;
        this.comidaPreferida = TipoAlimento.FRUTA;
        this.humMax = 100;
        this.humMin = 0;
        this.ferocidad = 50;
        this.atractividad = 100;
    }
    @Override
    public String getSonido() {
        return "jijiji";
    }
    public String getEspecie(){ return "zorro artico"; }
    public int getPrecio(){ return 800;}
}