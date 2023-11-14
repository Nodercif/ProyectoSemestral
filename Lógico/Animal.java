package Lógico;

public abstract class Animal {
    private int temMax;
    private int temMin;
    private int humMax;
    private int humMin;
    private int hambre;
    private int ferocidad;
    private String nombre;
    private Habitat habitat;
    public Animal(int temperatura, int humedad, int hambre, int ferocidad, String nombre){
        this.nombre = nombre;
        this.hambre = hambre;
        this.ferocidad = ferocidad;
    }

    public Alimento comerAlimento() {
        return;
    }
}
