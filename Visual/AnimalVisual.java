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
        this.posicion = new Punto(rand.nextInt(habitat.getWidth()), rand.nextInt(habitat.getHeight()));
    }
    public Image getImagen(){
        return imagen;
    }
    public void setImagen(Image imagen){this.imagen = imagen; }
    @Override
    public void tick(){
        super.tick();
        if(rand.nextInt(1000)<5)
            addDestino(rand.nextInt(panelHabitat.getWidth()-50), rand.nextInt(panelHabitat.getHeight()-40));
    }
}
