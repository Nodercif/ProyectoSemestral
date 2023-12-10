package Visual;

import java.awt.*;
import java.util.ArrayList;
import java.lang.Math;
class PuntoFloat {
    float x;
    float y;
    public PuntoFloat(float x, float y){
        this.x = x;
        this.y = y;
    }
}
public abstract class Mob {
    protected float rapidez;
    protected PuntoFloat posicion;
    protected ArrayList<PuntoFloat> camino;
    public Mob(){
        camino = new ArrayList<PuntoFloat>();
        posicion = new PuntoFloat(0f,0f);
        rapidez = 0.01f;
        String archivoDeCaminos = "recursos/caminos.txt";
    }
    public void tick() {
        //moverse
        if(!camino.isEmpty()){
            PuntoFloat siguiente = camino.get(0);
            float dx = siguiente.x - posicion.x;
            float dy = siguiente.y - posicion.y;
            if( (dx*dx + dy*dy)<25 )camino.remove(0);
            float norma = (float)Math.sqrt(dx*dx+dy*dy)+0.00001f;
            float pasoX = rapidez * dx/norma;
            float pasoY = rapidez * dy/norma;
            if(Math.abs(dx)<Math.abs(pasoX)) pasoX = dx;
            if(Math.abs(dy)<Math.abs(pasoY)) pasoY = dy;
            posicion.x += pasoX;
            posicion.y += pasoY;
        }
    }
    public void addDestino(int x, int y){
        camino.add(new PuntoFloat(x,y));
    }
    public void addDestino(Point p){camino.add(new PuntoFloat(p.x,p.y));}

    public int getPosX(){return (int)posicion.x;}
    public int getPosY(){return (int)posicion.y;}
    public int getLargoCamino(){
        if(camino != null)return camino.size();
        return 0;
    }
    public void setPosicion(int x, int y){
        posicion.x = x;
        posicion.y = y;
    }
    public void setPosicion(Point punto){
        posicion.x = punto.x;
        posicion.y = punto.y;
    }
    public void setRapidez(float rapidez){
        this.rapidez = rapidez;
    }
}
