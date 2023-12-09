package Visual;

import Logico.Animal;
import Logico.Habitat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class PanelHabitat extends JPanel {
    public Image imagenHabitat;
    private Habitat habitat;
    private ArrayList<AnimalVisual> animalesVis;
    private Random rand = new Random();
    public boolean esteHabitatEstaSeleccionado;
    public PanelHabitat(Habitat habitat) {
        if(habitat == null){
            imagenHabitat = (new ImageIcon("recursos/habitats/noHabitat.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
        }
        esteHabitatEstaSeleccionado = false;
        this.habitat = habitat;
        setBackground(new Color(0,0,0,0));
        animalesVis = new ArrayList<AnimalVisual>();

    }
    public void tick(){
        if(habitat != null) if(rand.nextInt(1000)<15){
            habitat.dueloAnimal();
        }
        Iterator<AnimalVisual> iterator = animalesVis.iterator();
        while(iterator.hasNext()){
            AnimalVisual a = iterator.next();
            a.tick();
            if(!a.estaVivo()){
                iterator.remove();
            }
        }
    }
    public void addAnimal(AnimalVisual ani){
        animalesVis.add(ani);
    }

    public Habitat getHabitat() {return habitat;}
    public ArrayList<AnimalVisual> getAnimalesVisual() {return animalesVis;}
    public void setHabitat(Habitat habitat) {this.habitat = habitat;}
    public void setImagenHabitat(Image imagen){this.imagenHabitat = imagen;}
    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.drawImage(imagenHabitat, 0, 0, this);
        Graphics2D g2d = (Graphics2D)g;

        for(AnimalVisual a : animalesVis){
            int x = a.getPosX();
            int y = a.getPosY();
            g2d.drawImage(a.getImagen(),a.getPosX(),a.getPosY(),this);
        }
        if(esteHabitatEstaSeleccionado){
            g2d.setColor(Color.green);
            g2d.drawOval(10 ,10, 10, 10);
        }
    }
}
