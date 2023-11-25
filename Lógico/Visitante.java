package Lógico;

import java.util.ArrayList;
import java.util.Random;

public class Visitante {
    private Random rand = new Random();
    ArrayList<String> comentarios;
    String nombre;
    Animal animalFavorito;
    public Visitante() {
        //TODO seleccionara nombre al azar de un archivo de texto de nombres random
        this.nombre = "noname";

    }
    public void observarHabitat(Habitat hab){
        int satisfaccion = rand.nextInt(20);
        for(Animal a : hab.getAnimales()){
            satisfaccion += a.getAtractividad();
            if(a == animalFavorito)satisfaccion+=(a.atractividad*2);
        }
        //TODO aumentar la cantidad de dinero dependiendo de la satisfaccion

    }
}
