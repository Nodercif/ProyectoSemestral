import Lógico.Animal;
import Lógico.Animales.*;
import Lógico.Habitat;

import javax.swing.plaf.PanelUI;

public class MainProyecto {
    public static void main(String[] args){
        Animal frio = new OsoPolar(1,1,"bob",new Habitat());
        Animal calor = new León(1,1,"paul",new Habitat());

        System.out.println(frio.getMaxTemp());
        System.out.println(calor.getMaxTemp());
    }
}
