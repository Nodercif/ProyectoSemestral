package Visual;

import Lógico.Animal;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class AnimalVisual extends Mob {
    private JPanel habitat;
    private Random rand;
    private Image imagen;
    private Animal animal;

    public AnimalVisual(JPanel habitat, Animal animal) {
        super();
        this.habitat = habitat;
        this.animal = animal;
        rand = new Random(867);
        this.setRapidez(0.6f);
        this.posicion = new Punto(rand.nextInt(habitat.getWidth()), rand.nextInt(habitat.getHeight()));
        //TODO cargar imagen del animal
        imagen = (new ImageIcon("recursos/animales/animal.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
    }
    public Image getImagen(){
        return imagen;
    }
    @Override
    public void tick(){
        super.tick();
        if(rand.nextInt(1000)<5)
            addDestino(rand.nextInt(habitat.getWidth()), rand.nextInt(habitat.getHeight()));

    }
}
