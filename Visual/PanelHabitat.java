package Visual;

import Lógico.Animal;
import Lógico.Habitat;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelHabitat extends JPanel {
    public Image imagenHabitat;
    private Habitat habitat;
    private ArrayList<AnimalVisual> animalesVis;
    public PanelHabitat(Image imagenHabitat, Habitat habitat) {
        this.imagenHabitat = imagenHabitat;
        this.habitat = habitat;
        setBackground(new Color(0,0,0,0));
        animalesVis = new ArrayList<AnimalVisual>();
        Timer timer = new Timer(20, e -> {
            for(AnimalVisual a : animalesVis){
                a.tick();
                //super.repaint();
            }
        });
        timer.start();

    }
    public void addAnimal(AnimalVisual ani){
        animalesVis.add(ani);
    }

    public Habitat getHabitat() {return habitat;}
    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        g.drawImage(imagenHabitat, 0, 0, this);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLUE);
        g2d.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);
        System.out.println("painting habitat, animalcount:"+animalesVis.size());

        for(AnimalVisual a : animalesVis){
            int x = a.getPosX();
            int y = a.getPosY();
            System.out.println("painting aniaml, pos:"+x+" "+y);
            g2d.drawImage(a.getImagen(),a.getPosX(),a.getPosY(),this);
        }


    }
}
