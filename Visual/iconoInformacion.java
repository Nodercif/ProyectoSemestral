package Visual;

import javax.swing.*;
import Logico.TipoAlimento;
/** Un icono flotante en la pantalla que muestra algo de informacion. Ya sea texto o una cantidad de recurso que ganaste o perdiste*/

public class iconoInformacion extends JLabel {
    public static final int DINERO = 0;

    /**Constructor cuando quieres mostrar un texto*/
    public iconoInformacion(String texto){
        super(texto);
    }
    /**Constructor cuando ganas o pierdes una cantidad de comida*/
    public iconoInformacion(int cantidad, TipoAlimento tipoAlimento){
        //TODO
    }
    /**Construcor para cualquier recurso que no sea comida. Como dinero o otros que añadamos mas tarde*/
    public iconoInformacion(int cantidad, int tipoRecurso){
        //TODO
    }

}
