package Lógico;

public abstract class Animal {
    private int tempMax;
    private int tempMin;
    private int humMax;
    private int humMin;
    private int metabolismo;
    private int hambre;
    private int ferocidad;
    private String nombre;
    private Habitat habitat;
    public Animal(int metabolismo, int ferocidad, String nombre, Habitat habitat){
        tempMax = -69;
        tempMin = -69;
        humMax = -69;
        humMin = -69;
        this.metabolismo = metabolismo;
        hambre = 0;
        this.ferocidad = ferocidad;
        this.nombre = nombre;
        this.habitat = habitat;
    }
    public void comerAlimento() {
        //Reduce hambre.
    }
    public void pasoTiempo() {
        //Aumenta hambre.
        //LLama a morir.
    }
    public void morir() {
        //hambre >= 100 resta animal de habitat.
        //Añade comida en clase ALimento, Carne.
    }
    public abstract String getSonido();
    public void setHabitat(Habitat habitat) {this.habitat = habitat;}
}
