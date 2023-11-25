package Lógico;

import java.util.ArrayList;

public class VisitanteVIP extends Visitante {
    private ArrayList<String> ;
    public VisitanteVIP() {
        super();
    }
    public String observarHabitat(Habitat hab) {
        int satisfaccion = rand.nextInt(20) + 20;
        String ret = "comentario hacerca del habitat";
        for(Animal a : hab.getAnimales()){
            satisfaccion += a.getAtractividad();
            if(a == animalFavorito) {
                satisfaccion += (a.atractividad * 4);
                ret = "Wow, ¡Es mi animal favorito! Un " + animalFavorito.getEspecie() + ".";
            }
        }
        ZooManager.getInstance().addMoney(satisfaccion);
        //TODO añadir mas comentarios de otros casos (habitat vacio, pocos animales...)
        return ret;
    }
}
