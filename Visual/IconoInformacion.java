package Visual;

import javax.swing.*;
import Logico.TipoAlimento;

import java.awt.*;
import java.util.Random;

/** Un icono flotante en la pantalla que muestra algo de informacion. Ya sea texto o una cantidad de recurso que ganaste o perdiste*/

public class IconoInformacion{
    public static final int DINERO = 0;
    private String text = null;
    public ImageIcon icono = null;
    public Color colorTexto;
    private int alphaInicial = 255;
    Point posicionInicial;
    Point pos;
    /**Entre mayor perdurancia mas dura el mensaje*/
    private int perdurancia = 1;
    private int edad = 0;

    /**Constructor cuando quieres mostrar un texto*/
    public IconoInformacion(String texto, Point pos){
        perdurancia = 200;
        edad = 1;
        text = texto;
        alphaInicial = 255;
        colorTexto = Color.BLACK;
        posicionInicial = new Point();
        this.pos = pos;
        posicionInicial.x = pos.x;
        posicionInicial.y = pos.y;
    }
    /**Constructor cuando ganas o pierdes una cantidad de comida*/
    public IconoInformacion(int cantidad, TipoAlimento tipoAlimento, Point pos){
        perdurancia = 50;
        edad = 1;
        alphaInicial = 255;
        posicionInicial = new Point();
        this.pos = pos;
        posicionInicial.x = pos.x;
        posicionInicial.y = pos.y;
        if(cantidad > 0){
            colorTexto = Color.green;
            text = "+";
        }
        else if(cantidad < 0){
            colorTexto = Color.red;
            text = "-";
        }
        else colorTexto = Color.gray;
        text += cantidad;

        if(tipoAlimento == TipoAlimento.CARNE){
            icono = new ImageIcon("recursos/iconos/carne.png");
        }
        if(tipoAlimento == TipoAlimento.FOLLAJE){
            icono = new ImageIcon("recursos/iconos/follaje.png");
        }
        if(tipoAlimento == TipoAlimento.FRUTA){
            icono = new ImageIcon("recursos/iconos/fruta.png");
        }
        if(tipoAlimento == TipoAlimento.PESCADO){
            icono = new ImageIcon("recursos/iconos/pescado.png");
        }
    }
    /**Constructor para cualquier recurso que no sea comida. Como dinero o otros que añadamos mas tarde*/
    public IconoInformacion(int cantidad, int tipoRecurso, Point pos){
        perdurancia = 50;
        edad = 1;
        alphaInicial = 255;
        posicionInicial = new Point();
        this.pos = pos;
        posicionInicial.x = pos.x;
        posicionInicial.y = pos.y;
        text = "";
        if(cantidad > 0){
            colorTexto = Color.green;
            text = "+";
        }
        else if(cantidad < 0){
            colorTexto = Color.red;
            text = "-";
        }
        else colorTexto = Color.gray;
        text += cantidad;
        if(tipoRecurso == DINERO){
            icono = new ImageIcon("recursos/iconos/dinero.png");
        }
    }
    /** retorna 0 si ya a exisitido lo suficiente*/
    public int tick(){
        if(edad<perdurancia){
            edad++;
            pos.y = posicionInicial.y - 40*edad/perdurancia;
            colorTexto = new Color(colorTexto.getRed(),colorTexto.getGreen(),colorTexto.getBlue(),alphaInicial-250*edad/perdurancia);
            return 1;
        }
        return 0;
    }
    public Image getImage(){return icono.getImage();}
    public String getText() {return text;}
    public int getX(){return pos.x;}
    public int getY(){return pos.y;}
}
