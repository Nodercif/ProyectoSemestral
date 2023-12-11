package Visual;

import Logico.Habitat;
import Logico.Visitante;
import Logico.ZooManager;

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
    /** cooldown de observar on habitat, para que no espamee*/
    private int coolDownObservacion;
    /** si el visitante ya esta satisfecho se va*/
    public boolean satisfecho;
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
        this.satisfecho=false;
        this.setRapidez(0.7f);
        this.setPosicion(InformacionCaminos.getInstance().getCruze(indiceCruze));
        imagen = (new ImageIcon(visitante.getArchivoImagen())).getImage().getScaledInstance(30,50,Image.SCALE_SMOOTH);
    }
    @Override
    public void tick(){
        super.tick();
        //moverse
        if(getLargoCamino()<3 && !satisfecho){
            int chance = 90;
            if(InformacionCaminos.getInstance().esEsteCruzeAlLadoDeUnHabitat(indiceCruze))
                chance=15;
            if(rand.nextInt(10000)<chance){
                InformacionCaminos.getInstance().hacerVisitanteIrAUnHabitat(this);
            }
        }
        //irse
        if(rand.nextInt(6969)==69){
            satisfecho=true;
            InformacionCaminos.getInstance().irA(this,0);
        }
        //observar habitats
        if(coolDownObservacion >0){
            coolDownObservacion--;
        }else
        if(InformacionCaminos.getInstance().esEsteCruzeAlLadoDeUnHabitat(indiceCruze) && getLargoCamino()==0){
            Habitat habitat = InformacionCaminos.getInstance().getHabitat(indiceCruze);
            if(habitat!=null){
                visitante.observarHabitat(habitat);
                ZooManager.getInstance().addMoney(visitante.getAsombro()*2);
                PanelPrincipal.getInstance().mostrarIconoInformacion(new IconoInformacion(visitante.getAsombro()*2,IconoInformacion.DINERO,getPoint()));
                coolDownObservacion=100;
            }
        }
    }
    public boolean enLaSalida(){return indiceCruze==0 && getLargoCamino()==0;}

    public Image getImagen(){return imagen;}
}
