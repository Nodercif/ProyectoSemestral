package Logico;
import java.util.ArrayList;
import java.util.Random;

public class Habitat {
    private int temperatura;
    private int humedad;
    private int cantCarne;
    private int cantPescado;
    private int cantFruta;
    private int cantFollaje;
    private ArrayList<Animal> animales;
    private Random rand = new Random();

    public Habitat(int temp, int hum) {
        animales = new ArrayList<>();
        this.temperatura = temp;
        this.humedad = hum;
    }

    public void addAnimal(Animal animal) {
        animales.add(animal);
    }

    public void removeAnimal(Animal animal) {
        animales.remove(animal);
    }

    public static void moverAnimal(Habitat habitat1, Habitat habitat2, Animal animal) {
        habitat1.removeAnimal(animal);
        habitat2.addAnimal(animal);
        animal.setHabitat(habitat2);
    }

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
    /** dos animales aleatorios se miran feo. si uno es mucho mas feroz que el otro lo mata */
    public String dueloAnimal(){
        if(animales.isEmpty())return null;
        Animal ani1 = animales.get(rand.nextInt(animales.size()));
        Animal ani2 = animales.get(rand.nextInt(animales.size()));
        if(ani1.getFerocidad() > ani2.getFerocidad()+40){
            String ret = ani1.getNombre()+" a matado a "+ani2.getNombre()+"!";
            ret += " Parece que un "+ani1.getEspecie() + " y un "+ ani2.getEspecie()+" no se llevan bien.";
            return ret;
        }
        if(ani2.getFerocidad() > ani1.getFerocidad()+40){
            String ret = ani2.getNombre()+" a matado a "+ani1.getNombre()+"!";
            ret += " Parece que un "+ani2.getEspecie() + " y un "+ ani1.getEspecie()+" no se llevan bien.";
            return ret;
        }
        return null;
    }
    public int getTemperatura() { return temperatura;}
    public int getHumedad() { return humedad; }
    public int getCantCarne() { return cantCarne; }
    public int getCantPescado() { return cantPescado; }
    public int getCantFruta() { return cantFruta; }
    public int getCantFollaje() { return cantFollaje; }
}
