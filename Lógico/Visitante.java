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
    public String observarHabitat(Habitat hab){
        int satisfaccion = rand.nextInt(20);
        String ret = "comentario hacerca del habitat";
        for(Animal a : hab.getAnimales()){
            satisfaccion += a.getAtractividad();
            if(a == animalFavorito){
                satisfaccion+=(a.atractividad*2);
                ret = "Wow, ¡Es mi animal favorito!";
            }
        }
        ZooManager.getInstance().addMoney(satisfaccion);
        //TODO añadir mas comentarios de otros casos (habitat vacio, pocos animales...)
        return ret;
    }
}
