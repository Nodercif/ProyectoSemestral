package Visual;

import javax.swing.*;
import Logico.TipoAlimento;

import java.awt.*;

/** Un icono flotante en la pantalla que muestra algo de informacion. Ya sea texto o una cantidad de recurso que ganaste o perdiste*/

public class IconoInformacion{
    public static final int DINERO = 0;
    private String text = null;
    public ImageIcon icono = null;
    public Color color;
    Point posicionInicial;
    Point pos;

    /**Constructor cuando quieres mostrar un texto*/
    public IconoInformacion(String texto, Point pos){
        text = texto;
        color = Color.BLACK;
        posicionInicial = new Point();
        this.pos = pos;
        posicionInicial.x = pos.x;
        posicionInicial.y = pos.y;
    }
    /**Constructor cuando ganas o pierdes una cantidad de comida*/
    public IconoInformacion(int cantidad, TipoAlimento tipoAlimento, Point pos){
        //TODO
    }
    /**Construcor para cualquier recurso que no sea comida. Como dinero o otros que añadamos mas tarde*/
    public IconoInformacion(int cantidad, int tipoRecurso, Point pos){
        //TODO
    }
    /** retorna 0 si ya a exisitido lo suficiente*/
    public int tick(){
        if(pos.y > posicionInicial.y-40){
            pos.y -= 1;
            return 1;
        }
        return 0;
    }
    public Image getImage(){return icono.getImage();}
    public String getText() {return text;}
    public int getX(){return pos.x;}
    public int getY(){return pos.y;}
}
