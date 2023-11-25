package Lógico;
import java.util.Random;
public abstract class Animal {
    protected int tempMax;
    protected int tempMin;
    protected int humMax;
    protected int humMin;
    protected int metabolismo;
    protected int hambre = 0;
    protected int ferocidad;
    protected int atractividad;
    private String nombre;
    protected TipoAlimento comidaPreferida;
    private Habitat habitat;
    private Random numeroAlAzar = new Random();
    public Animal(String nombre, Habitat habitat){
        this.nombre = nombre;
        this.habitat = habitat;
    }
    public void comerAlimento() {
        int bocado = (int)((metabolismo * 0.8) + (hambre * 0.2));
        hambre -= habitat.quitarComida(bocado, comidaPreferida);
        if(hambre < 0) {
            hambre = 0;
        }
    }
    public void pasoTiempo() {
        hambre += metabolismo * numeroAlAzar.nextFloat();
        if(hambre >= 1000) {
            this.morir();
        }
    }
    public void morir() {
        habitat.addComida(metabolismo, TipoAlimento.CARNE);
        habitat.removeAnimal(this);
    }
    public abstract String getSonido();
    public void setHabitat(Habitat habitat) {this.habitat = habitat;}
    public int getMaxTemp(){return this.tempMax;}
    public int getAtractividad(){return this.atractividad;}

    //TODO agregar el resto de getters.
}
