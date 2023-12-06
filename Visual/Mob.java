package Visual;

import java.util.ArrayList;
import java.lang.Math;
class Punto{
    float x;
    float y;
    public Punto(float x, float y){
        this.x = x;
        this.y = y;
    }
}
public abstract class Mob {
    protected float rapidez;
    protected Punto posicion;
    protected ArrayList<Punto> camino;
    public Mob(){
        camino = new ArrayList<Punto>();
        posicion = new Punto(0f,0f);
        rapidez = 0.01f;
        String archivoDeCaminos = "recursos/caminos.txt";
    }
    public void tick() {
        //moverse
        if(!camino.isEmpty()){
            Punto siguiente = camino.get(0);
            float dx = siguiente.x - posicion.x;
            float dy = siguiente.y - posicion.y;
            if( (dx*dx + dy*dy)<25 )camino.remove(0);
            float norma = (float)Math.sqrt(dx*dx+dy*dy);
            posicion.x += rapidez * dx/norma;
            posicion.y += rapidez * dy/norma;
        }
    }
    public void addDestino(int x, int y){
        camino.add(new Punto(x,y));
    }

    public int getPosX(){return (int)posicion.x;}
    public int getPosY(){return (int)posicion.y;}
    public void setRapidez(float rapidez){
        this.rapidez = rapidez;
        if(this.rapidez >= 5)this.rapidez = 4.99f;
    }
}
