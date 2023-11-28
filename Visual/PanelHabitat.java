package Visual;

import Lógico.Habitat;

import javax.swing.*;
import java.awt.*;

public class PanelHabitat extends JPanel {
    public Image imagenHabitat;
    private Habitat habitat;
    public PanelHabitat(Image imagenHabitat, Habitat habitat) {
        this.imagenHabitat = imagenHabitat;
        this.habitat = habitat;
    }

    public void setHabitat(Habitat habitat, Image imagenHabitat) {
        this.habitat = habitat;
        this.imagenHabitat = imagenHabitat;
    }
    public void paint(Graphics g) {
        g.drawImage(imagenHabitat, 0, 0, this);
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(Color.BLUE);
        g2d.drawRect(0,0,this.getWidth()-1,this.getHeight()-1);
    }
}
