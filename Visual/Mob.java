package Visual;

import java.util.ArrayList;
class Punto{
    int x;
    int y;
}
public abstract class Mob {
    private int velocidad;
    private int tiempo;
    private int posicion;
    private ArrayList<Punto> camino;
    public Mob(){
        camino = new ArrayList<Punto>();
        String archivoDeCaminos = "recursos/caminos.txt";
    }
    public void tick() {
        //caminar hacia camino.firt
        //TODO
        /*posicicion += (camino.get(0)-posicion)/algo;
        if(posicion - camino.get(0)<3)camino.remove(0);
        //Trabaja con las variables velocidad y tiempo.*/
        
    }
}
