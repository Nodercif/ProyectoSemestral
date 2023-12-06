package Visual;
import Lógico.Animal;
import Lógico.Animales.OsoPolar;
import Lógico.ZooManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PanelPrincipal extends JPanel {
    private PanelHabitat panelesHabitat[] = new PanelHabitat[5];
    private PanelInformacion panelInformacion;
    private ArrayList<VisitanteVisual> visitanteVisual;
    private Image fondo;
    public PanelPrincipal() {
        super();
        try {
            fondo = ImageIO.read(new File("recursos/fondo.png"));
        }catch (IOException e){
            System.err.print("No se ha podido cargar la imagen de fondo =(");
            System.exit(69);
        }
        this.setLayout(null);
        for(int i=0;i<5;i++)panelesHabitat[i] = new PanelHabitat(null, ZooManager.getInstance().habitats[i]);
        panelesHabitat[0].setBounds(130,150,300,160);
        panelesHabitat[1].setBounds(630,150,300,160);
        panelesHabitat[2].setBounds(130,380,300,160);
        panelesHabitat[3].setBounds(630,380,300,160);
        panelesHabitat[4].setBounds(1080,130,150,370);
        for(int i=0;i<5;i++){this.add(panelesHabitat[i]);panelesHabitat[i].setVisible(true);}

        //testing
        Animal ani = new OsoPolar("jeff",panelesHabitat[0].getHabitat());
        AnimalVisual aniv =new AnimalVisual(panelesHabitat[0],ani);
        aniv.addDestino(100,60);
        panelesHabitat[0].addAnimal(aniv);

    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, this);
        paintChildren(g);
    }
}
