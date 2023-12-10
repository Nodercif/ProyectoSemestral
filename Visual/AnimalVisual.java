package Visual;

import Logico.Animal;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AnimalVisual extends Mob {
    private JPanel panelHabitat;
    private Random rand;
    private Image imagen;
    private Animal animal;

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
    public boolean estaVivo(){return animal.estaVivo();}
    @Override
    public void tick(){
        super.tick();
        if(rand.nextInt(1000)<5)
            addDestino(rand.nextInt(panelHabitat.getWidth()-50), rand.nextInt(panelHabitat.getHeight()-40));
        if(rand.nextInt(1000)<15){
            animal.pasoTiempo();
            animal.comerAlimento();
        }
    }
}
