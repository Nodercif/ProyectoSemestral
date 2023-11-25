package Lógico;

import java.util.ArrayList;
import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class Visitante {
    protected Random rand = new Random();
    private static final String[] comentarios = {"uwu","me gusta el zoologico","xd"};
    String nombre;
    Animal animalFavorito;
    public Visitante() {
        this.nombre = GeneradorDeNombres.getInstance().nombreRandom();
    }
    public String observarHabitat(Habitat hab) {
        int satisfaccion = rand.nextInt(20);
        String ret = "comentario hacerca del habitat";
        for(Animal a : hab.getAnimales()) {
            satisfaccion += a.getAtractividad();
            if(a == animalFavorito){
                satisfaccion += (a.atractividad*2);
                ret = "Wow, ¡Es mi animal favorito! Un " + animalFavorito.getEspecie() + ".";
            }
        }
        ZooManager.getInstance().addMoney(satisfaccion);
        //TODO añadir mas comentarios de otros casos (habitat vacio, pocos animales...)
        return ret;
    }
    public String comentarioRandom(){
        return comentarios[rand.nextInt(comentarios.length)];
    }

    public String getNombre() {return nombre;}
}
