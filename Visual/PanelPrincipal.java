package Visual;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PanelPrincipal extends JPanel {
    private PanelHabitat panelHabitat;
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
    }
    public void paint(Graphics g) {
        super.paint(g);
        g.drawImage(fondo, 0, 0, this);
    }
}
