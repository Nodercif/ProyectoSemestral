package Logico;

import java.util.Random;

public class Visitante {
    protected Random rand = new Random();
    protected String nombre;
    protected String archivoImagen;
    Animal animalFavorito;
    protected int asombro;
    public Visitante() {
        this.nombre = InformacionVisitantes.getInstance().nombreRandom();
        this.archivoImagen = "recursos/visitantes/visitanteGenerico"+rand.nextInt(1)+".png";
    }
    public String observarHabitat(Habitat hab) {
        asombro = 0;
        String ret = "comentario hacerca del habitat";
        for(Animal a : hab.getAnimales()) {
            asombro += a.getAtractividad();
            if(a == animalFavorito){
                asombro += (a.atractividad*2);
                ret = "Wow, ¡Es mi animal favorito! Un " + animalFavorito.getEspecie() + ".";
            }
        }
        //TODO añadir mas comentarios de otros casos (habitat vacio, pocos animales...)
        return ret;
    }
    public String comentarioRandom(){
        return InformacionVisitantes.getInstance().ComentarioRandom();
    }
    public String getNombre() {return nombre;}
    public int getAsombro(){return asombro;}
    public String getArchivoImagen(){return archivoImagen;}
}
