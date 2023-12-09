package Logico;
import java.util.ArrayList;
/** La clase Habitat representa un espacio en el zoologico en el cual se podrán tener animales.
 * Hay cinco tipos de Habitats: Bosque, sabána, desierto, acuático y polar.
 * La vitalidad de cada animal dependerá de las condiciones del habitat en el que está: su temperatura y su humedad. */
public class Habitat {
    private int temperatura;
    private int humedad;
    private int cantCarne;
    private int cantPescado;
    private int cantFruta;
    private int cantFollaje;
    private ArrayList<Animal> animales;

    /** En el constructor de la clase se inicializan las condiciones del habitat.
     * @param temp indica la temperatura.
     * @param hum indica la humedad. */
    public Habitat(int temp, int hum) {
        animales = new ArrayList<>();
        this.temperatura = temp;
        this.humedad = hum;
    }

    /** En el método addAnimal se agregan los animales que se compran, al habitat.
     * @param animal es el animal que se agrega/compra.*/
    public void addAnimal(Animal animal) {
        animales.add(animal);
    }

    /**En el método removeAnimal se eliminan animales del habitat.
     * @param animal es el animal que se elimina.*/
    public void removeAnimal(Animal animal) {
        animales.remove(animal);
    }

    /**En el método quitarComida se elimina comida del habitat.
     * @param cantComida es la cantidad de comida que se eliminará.
     * @param comida es el tipo de comida que se eliminará (Carne, pescado, follaje o fruta).
     * Si la cantidad a eliminar es mayor a la cantidad de comida que se tiene guardada, entonces la cantidad de
       comida guardada queda en 0. La comida guardada no queda en números negativos.*/
    public int quitarComida(int cantComida, TipoAlimento comida) {
        if (comida == TipoAlimento.CARNE) {
            if (cantComida < this.cantCarne) {
                this.cantCarne -= cantComida;
                return cantComida;
            } else {
                int ret = this.cantCarne;
                this.cantCarne = 0;
                return ret;
            }
        } else if (comida == TipoAlimento.PESCADO) {
            if (cantComida < this.cantPescado) {
                this.cantPescado -= cantComida;
                return cantComida;
            } else {
                int ret = this.cantPescado;
                this.cantPescado = 0;
                return ret;
            }
        } else if (comida == TipoAlimento.FRUTA) {
            if (cantComida < this.cantFruta) {
                this.cantFruta -= cantComida;
                return cantComida;
            } else {
                int ret = this.cantFruta;
                this.cantFruta = 0;
                return ret;
            }
        } else if (comida == TipoAlimento.FOLLAJE) {
            if (cantComida < this.cantFollaje) {
                this.cantFollaje -= cantComida;
                return cantComida;
            } else {
                int ret = this.cantFollaje;
                this.cantFollaje = 0;
                return ret;
            }
        }
        return 0;
    }
    public void addComida(int cantComida, TipoAlimento comida) {
        if (comida == TipoAlimento.CARNE)
            this.cantCarne += cantComida;

        if (comida == TipoAlimento.PESCADO)
            this.cantPescado += cantComida;

        if (comida == TipoAlimento.FRUTA)
            this.cantFruta += cantComida;

        if (comida == TipoAlimento.FOLLAJE)
            this.cantFollaje += cantComida;
    }
    public ArrayList<Animal> getAnimales(){
        return animales;
    }
    public int getTemperatura() { return temperatura;}
    public int getHumedad() { return humedad; }
    public int getCantCarne() { return cantCarne; }
    public int getCantPescado() { return cantPescado; }
    public int getCantFruta() { return cantFruta; }
    public int getCantFollaje() { return cantFollaje; }
}
