package Visual;

import javax.swing.*;
import java.awt.*;

public class VisitanteVisual extends Mob{
    private Image imagen;
    public VisitanteVisual() {
        super();
        imagen = (new ImageIcon("recursos/visitantes/visitante.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
    }
}
