package Visual;

import Lógico.InformacionVisitantes;

import java.awt.*;
import java.util.ArrayList;

/**
 * informacion caminos es un singleton que leera la informacin de los caminos por donde pueden caminar
 * visitantes al zoologico
 * los caminos se guardan como un grafo
 */
public class InformacionCaminos {
    private static InformacionCaminos instance;
    private ArrayList<Point> cruzes;

    /**
     * el constructor va a cargar la informacion de un archivo de texto
     */
    public InformacionCaminos(){

    }
}
