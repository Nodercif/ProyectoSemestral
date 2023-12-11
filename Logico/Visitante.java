package Logico;

import java.util.Random;

/** La siguiente clase representa a los visitantes que ingresan al zoologico. */
public class Visitante {
    protected Random rand = new Random();
    protected String nombre;
    protected String archivoImagen;
    Animal animalFavorito;
    protected int asombro;

    /** Mediante el constructor se le asigna un nombre aleatorio y una imagen al visitante. Los nombres son
     tomados de un archivo .txt. */
    public Visitante() {
        this.nombre = InformacionVisitantes.getInstance().nombreRandom();
        this.archivoImagen = "recursos/visitantes/visitanteGenerico"+rand.nextInt(8)+".png";
    }

    /** El método observarHabitat sirve para generar dinero según el animal que el visitante observe.
     * @param  hab es el habitat al cual el visitante llegó. */
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
        return ret;
    }
    public String comentarioRandom(){
        return InformacionVisitantes.getInstance().ComentarioRandom();
    }
    public String getNombre() {return nombre;}
    public int getAsombro(){return asombro;}
    public String getArchivoImagen(){return archivoImagen;}
}
