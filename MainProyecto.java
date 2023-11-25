import Lógico.*;
import Lógico.Animales.*;

import javax.swing.plaf.PanelUI;
public class MainProyecto {
    public static void main(String[] args){
        Visitante vis1 = new Visitante();
        Visitante vis2 = new Visitante();
        Visitante vis3 = new VisitanteVIP();
        System.out.println(vis1.getNombre() +": "+  vis1.comentarioRandom());
        System.out.println(vis2.getNombre() +": "+  vis2.comentarioRandom());
        System.out.println(vis3.getNombre() +": "+  vis3.comentarioRandom());
    }
}
