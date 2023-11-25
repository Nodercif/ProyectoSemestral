import Lógico.Animal;
import Lógico.Animales.*;
import Lógico.Habitat;

import javax.swing.plaf.PanelUI;

public class MainProyecto {
    public static void main(String[] args){
        Animal frio = new OsoPolar("bob",new Habitat());

        System.out.println(frio.getMaxTemp());
        System.out.println(calor.getMaxTemp());
    }
}
