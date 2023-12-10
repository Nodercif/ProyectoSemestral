package Visual;

import Logico.Habitat;
import Logico.InformacionVisitantes;
import Logico.Visitante;

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
    /** dado un cruze adyacente a un habitat, guarda el indice de este habitat en panelPrincipal*/
    private Map<Point,Integer> indicesHabitats= new HashMap<>();

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
                if(Objects.equals(valores[0],"habitat")){
                    //si es un habitat le sigue el indice del nodo de los cruzes,
                    //luego el indice del habitat del cual esta cerca
                    Point cruze = cruzes.get(Integer.parseInt(valores[1]));
                    cruzesDeHabitat.add(cruze);
                    indicesHabitats.put(cruze,Integer.parseInt(valores[2]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /** retorna el punto del indice-esimo cruze*/
    public Point getCruze(int indice){
        return cruzes.get(indice);
    }
    public int getCantCruzes(){return cruzes.size();}
    public Habitat getHabitat(int indiceCruze){
        Point nodo = cruzes.get(indiceCruze);
        if(!cruzesDeHabitat.contains(nodo))return null;
        PanelHabitat panelHabitat = PanelPrincipal.getInstance().panelesHabitat[indicesHabitats.get(nodo)];
        return panelHabitat.getHabitat();
    }

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
    public void irA(VisitanteVisual vis, int indiceLLegada){
        int cantidadDeNodos = cruzes.size();
        Map<Point, Point> previos = new HashMap<>();
        Map<Point, Integer> distancias = new HashMap<>();
        for(Point p : cruzes){
            previos.put(p,null);
            distancias.put(p,99999);
        }
        Point origen = cruzes.get(vis.indiceCruze);
        ArrayList<Point> queue = new ArrayList<>();
        queue.add(origen);
        distancias.put(origen,0);
        while(!queue.isEmpty()){
            Point nodo = queue.get(0);
            queue.remove(0);
            for(Point v : listaDeAdyacencia.get(nodo)){
                if(distancias.get(nodo)+1 < distancias.get(v)){

                    distancias.put(v,distancias.get(nodo)+1);
                    previos.put(v,nodo);
                    queue.add(v);
                }
            }
        }
        Point destino = cruzes.get(indiceLLegada);
        ArrayList<Point> ruta = new ArrayList<>();
        ruta.add(destino);
        while(ruta.get(ruta.size()-1) != origen){
            ruta.add(previos.get(ruta.get(ruta.size()-1)));
            if(!cruzes.contains(ruta.get(ruta.size()-1))){
                break;
            }
        }
        for(int i=ruta.size()-1;i>=0;i--){
            vis.addDestino(ruta.get(i));
        }
        vis.indiceCruze = cruzes.indexOf(destino);
    }
    /** le añade destinos al visitante de forma que termine en un habitat. Usa Dijkstra por que no se mas algoritmos*/
    public void hacerVisitanteIrAUnHabitat(VisitanteVisual vis){
        irA(vis,cruzes.indexOf(cruzesDeHabitat.get(rand.nextInt(cruzesDeHabitat.size()))));
    }
    public boolean esEsteCruzeAlLadoDeUnHabitat(int indiceCruze){
        if(indiceCruze > cruzes.size()-1)return false;
        return cruzesDeHabitat.contains(cruzes.get(indiceCruze));
    }

    public static InformacionCaminos getInstance() {
        if(instance == null){
            instance = new InformacionCaminos();
        }
        return instance;
    }
}
