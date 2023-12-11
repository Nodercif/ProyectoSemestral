package Logico;
import Visual.IconoInformacion;
import Visual.PanelPrincipal;

import java.util.Random;

/**
 * La clase animal representa los animales del zoologico. las subclases van a ser los animales especificos
 */
public abstract class Animal {
    protected int tempMax;
    protected int tempMin;
    protected int humMax;
    protected int humMin;

    /** el tamaño del animal. cuanta comida nececita basicamente*/
    protected int granditud;
    protected int hambre = 0;

    /** un animal que es significativamente mas feroz que otro lo va a atacar*/
    protected int ferocidad;

    /** que tan genial es el animal. la gente paga mas por ver un oso panda que una vaca */
    protected int atractividad;
    /** La categoria de alimento que este animal puede consumir*/
    protected TipoAlimento comidaPreferida;
    /** el habitat en el que reside este animal*/
    private Habitat habitat;
    private Random numeroAlAzar = new Random();
    /** si el animal esta vivo*/
    private boolean vivo;
    /** el nombre de este animal en especifico, que no se confunda con la especie*/
    private String nombre;

    /**
     * al crear un animal este tiene que estar en un habitat
     * @param habitat el habitat donde vivira el animal
     */
    public Animal(Habitat habitat){
        this.habitat = habitat;
        vivo = true;
        this.nombre = InformacionVisitantes.getInstance().nombreAnimalRandom();
    }
    /** el animal da un bocado de la comida disponible, dependiendo de su tamaño y cuanta hambre tiene*/
    public void comerAlimento() {
        int bocado = (int)((granditud * 0.2) + (hambre * 0.2));
        hambre -= habitat.quitarComida(bocado, comidaPreferida);
        if(hambre < 0) {
            hambre = 0;
        }
    }
    public void pasoTiempo() {
        hambre += (int)(granditud * numeroAlAzar.nextFloat());
        if(hambre >= 1000) {
            this.morir();
        }
    }
    /** el animal se quita del habitat, se le añade carne al habitat, y el animal deja de estar vivo*/
    public void morir() {
        habitat.addComida(granditud, TipoAlimento.CARNE);
        habitat.removeAnimal(this);
        vivo = false;
    }
    /**onomatopeya*/
    public abstract String getSonido();
    /**retorna 0 si esta muerto y cualquier otro numero si esta vivo*/
    public boolean estaVivo(){return vivo;}
    public void setHabitat(Habitat habitat) {this.habitat = habitat;}
    public int getMaxTemp(){return this.tempMax;}
    public int getMinTemp(){return this.tempMin;}
    public int getMaxHum(){return this.humMax;}
    public int getMinHum(){return this.humMin;}
    public int getAtractividad(){return this.atractividad;}
    public int getFerocidad(){return  this.ferocidad;}
    public int getGranditud(){return this.granditud;}
    public String getNombre(){return  this.nombre;}
    public abstract String getEspecie();
    public abstract int getPrecio();
}
