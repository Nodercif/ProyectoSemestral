package Visual;

import Logico.Visitante;

import javax.swing.*;
import java.awt.*;
import java.lang.invoke.VolatileCallSite;
import java.util.Random;

/**
 * la clase visitante visual es la representacion visual de un visitante. Se asocia a un visitante
 * y ademas tiene una imagen y posicion. Ademas se puede mover y todos eso
 */
public class VisitanteVisual extends Mob{
    private Random rand;
    private Image imagen;
    private Visitante visitante;
    /** el indice que se ocupa en el grafo de Informacion Caminos. basicamente en que cruze esta */
    public int indiceCruze;

    /**
     *
     * @param visitante el visitante que esta instancia va a representear
     */
    public VisitanteVisual(Visitante visitante) {
        super();
        this.visitante = visitante;
        rand = new Random();
        this.indiceCruze = 0;
        this.setRapidez(0.7f);
        this.setPosicion(InformacionCaminos.getInstance().getCruze(indiceCruze));
        imagen = (new ImageIcon(visitante.getArchivoImagen())).getImage().getScaledInstance(30,50,Image.SCALE_SMOOTH);
    }
    @Override
    public void tick(){
        super.tick();
        if(getLargoCamino()<3){
            int chance = 90;
            if(InformacionCaminos.getInstance().esEsteCruzeAlLadoDeUnHabitat(indiceCruze))
                chance=15;
            if(rand.nextInt(10000)<chance)
                InformacionCaminos.getInstance().moverVisitante(this);


            if(rand.nextInt(100000)<chance*2){
                InformacionCaminos.getInstance().hacerVisitanteIrAUnHabitat(this);
            }
        }

    }

    public Image getImagen(){return imagen;}
}
