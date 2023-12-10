package Visual;

import Logico.Animal;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

/** La clase AnimalVisual se encarga de representar visualmente a los animales almacenados en cada habitat. */
public class AnimalVisual extends Mob {
    private JPanel panelHabitat;
    private Random rand;
    private Image imagen;
    private Animal animal;

    /** @param habitat es el panel en el que se encuentra el animal.
     * @param animal es el animal con el que se está trabajando.
     * El contructor recibe ambos parámetros, los inicializa y se encarga de asignarle una velocidad y poscicion aleatorias
     dentro del panel habitat al animal, además de una imagen representativa. */
    public AnimalVisual(JPanel habitat, Animal animal) {
        super();
        this.panelHabitat = habitat;
        this.animal = animal;
        rand = new Random();
        this.setRapidez(0.6f);
        this.setPosicion(rand.nextInt(habitat.getWidth()-30), rand.nextInt(habitat.getHeight()-30));
        imagen = (new ImageIcon("recursos/animales/animal.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
    }
    public Image getImagen(){
        return imagen;
    }
    public void setImagen(Image imagen){this.imagen = imagen; }

    /** Con el método estaVivo se verifica que el animal esté vivo mediante una boolean. */
    public boolean estaVivo(){return animal.estaVivo();}
    @Override
    public void tick(){
        super.tick();
        if(rand.nextInt(1000)<5)
            addDestino(rand.nextInt(panelHabitat.getWidth()-50), rand.nextInt(panelHabitat.getHeight()-40));
        if(rand.nextInt(1000)==69){
            animal.pasoTiempo();
            animal.comerAlimento();
        }
    }
}
