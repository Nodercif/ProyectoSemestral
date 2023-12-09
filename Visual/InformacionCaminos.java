package Visual;

import Lógico.InformacionVisitantes;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * informacion caminos es un singleton que leera la informacin de los caminos por donde pueden caminar
 * visitantes al zoologico
 * los caminos se guardan como un grafo
 */
public class InformacionCaminos {
    /** la instancia del singleton */
    private static InformacionCaminos instance;

    /**
     * lista de cruzes donde se puede parar un visitante, al caminar siempre se va a estar
     * moviendo entre cruzes
     */
    private ArrayList<Point> cruzes = new ArrayList<Point>();

    /** los cruzes que estan cerca de un habitat. Si un visitante esta en uno de estos entonces puede ver el habitat */
    private ArrayList<Point> cruzesDeHabitat = new ArrayList<Point>();

    /**
     * un mapa que guarda una lista de cruzes a los que se puede llegar desde cada cruze
     */
    Map<Point,ArrayList<Point>> listaDeAdyacencia = new HashMap<>();

    Random rand = new Random();

    /**
     * el constructor va a cargar la informacion de un archivo de texto
     */
    public InformacionCaminos(){

        try (BufferedReader reader = new BufferedReader(new FileReader("recursos/caminos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] valores = line.split(" ");
                System.out.println(valores[0]);
                if(Objects.equals(valores[0], "nodo")){
                    //se va a añadir otro cruze, los dos siguientes numeros son la posicion
                    Point punto = new Point();
                    punto.x = Integer.parseInt(valores[1]);
                    punto.y = Integer.parseInt(valores[2]);
                    cruzes.add(punto);
                    listaDeAdyacencia.put(punto,new ArrayList<Point>());
                }
                if(Objects.equals(valores[0], "conexion")){
                    //si es una conexion, le sigen dos valores
                    //los indices de dos cruzes de la lista de cruzes.
                    //hay un camino esos dos cruzes
                    //a la lista de adyacencia de el primero se le añade el segundo y viceversa
                    Point cruzeA = cruzes.get(Integer.parseInt(valores[1]));
                    Point cruzeB = cruzes.get(Integer.parseInt(valores[2]));
                    listaDeAdyacencia.get(cruzeA).add(cruzeB);
                    listaDeAdyacencia.get(cruzeB).add(cruzeA);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("caminos inicializados "+cruzes.size());
        for(Point c : cruzes){
            System.out.print(c.x+" "+c.y+": ");
            for(Point p : listaDeAdyacencia.get(c)){
                System.out.println(" "+p.x+" "+p.y+" ");
            }
            System.out.println("");
        }
    }
    /** retorna el punto del indice-esimo cruze*/
    public Point getCruze(int indice){
        return cruzes.get(indice);
    }
    public int getCantCruzes(){return cruzes.size();}

    /**
     * toma un visitante y le añade como destino un cruze que tenga conexion con el cruze en el que esta
     * @param vis el visitante a mover
     */
    public void moverVisitante(VisitanteVisual vis){
        Point cruze = cruzes.get(vis.indiceCruze);
        ArrayList<Point> posiblesDestinos = listaDeAdyacencia.get(cruze);
        Point siguienteCruze = posiblesDestinos.get(rand.nextInt(posiblesDestinos.size()));
        vis.addDestino(siguienteCruze);
        vis.indiceCruze = cruzes.indexOf(siguienteCruze);
    }

    public static InformacionCaminos getInstance() {
        if(instance == null){
            instance = new InformacionCaminos();
        }
        return instance;
    }
}
