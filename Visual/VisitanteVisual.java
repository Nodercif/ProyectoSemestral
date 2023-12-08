package Visual;

import Lógico.Visitante;

import javax.swing.*;
import java.awt.*;
import java.lang.invoke.VolatileCallSite;
import java.util.Random;

public class VisitanteVisual extends Mob{
    private Random rand;
    private Image imagen;
    private Visitante visitante;
    public VisitanteVisual(Visitante visitante) {
        super();
        this.visitante = visitante;
        rand = new Random(123);
        this.setRapidez(1f);
        this.setPosicion(600,20);
        imagen = (new ImageIcon(visitante.getArchivoImagen())).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);

    }
    public Image getImagen(){return imagen;}
}
