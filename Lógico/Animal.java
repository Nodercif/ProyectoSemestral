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
    public Animal(int tempMax, int tempMin, int humMax, int humMin, int metabolismo, int ferocidad, String nombre){
        this.tempMax = tempMax;
        this.tempMin = tempMin;
        this.humMax = humMax;
        this.humMin = humMin;
        this.metabolismo = metabolismo;
        hambre = 0;
        this.ferocidad = ferocidad;
        this.nombre = nombre;
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
    }
    public void setHabitat(Habitat habitat) {this.habitat = habitat;}
}
