package Logico;

import java.util.ArrayList;

public class VisitanteVIP extends Visitante {
    private ArrayList<String> comentarios;
    private int poscicionEnElCamino;
    public VisitanteVIP() {
        this.nombre = InformacionVisitantes.getInstance().nombreRandomVIP();
        this.comentarios = InformacionVisitantes.getInstance().getComentariosVIP(this.nombre);
        this.archivoImagen = "recursos/visitantes/"+this.nombre.replaceAll("\\s", "") + ".png";
    }
    public String observarHabitat(Habitat hab) {
        asombro = 10;
        String ret = "comentario hacerca del habitat";
        for(Animal a : hab.getAnimales()){
            asombro += a.getAtractividad();
            if(a == animalFavorito) {
                asombro += (a.atractividad * 4);
                ret = "Wow, ¡Es mi animal favorito! Un " + animalFavorito.getEspecie() + ".";
            }
        }
        //TODO añadir mas comentarios de otros casos (habitat vacio, pocos animales...)
        return ret;
    }
    @Override
    public String comentarioRandom(){
        return comentarios.get(rand.nextInt(comentarios.size()));
    }
}
