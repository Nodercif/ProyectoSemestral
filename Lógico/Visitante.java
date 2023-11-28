package Lógico;

import java.util.Random;

public class Visitante {
    protected Random rand = new Random();
    protected String nombre;
    Animal animalFavorito;
    public Visitante() {
        this.nombre = InformacionVisitantes.getInstance().nombreRandom();
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
        return InformacionVisitantes.getInstance().ComentarioRandom();
    }
    public String getNombre() {return nombre;}
}
