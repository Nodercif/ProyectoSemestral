package Lógico;

public abstract class Animal {
    protected int tempMax;
    protected int tempMin;
    protected int humMax;
    protected int humMin;
    protected int metabolismo;
    protected int hambre = 0;
    protected int ferocidad;
    private String nombre;
    protected TipoAlimento comidaPreferida;
    private Habitat habitat;
    public Animal(String nombre, Habitat habitat){
        this.nombre = nombre;
        this.habitat = habitat;
    }
    public void comerAlimento() {
        hambre -= habitat.quitarComida(metabolismo, comidaPreferida);
    }
    public void pasoTiempo() {
        //Aumenta hambre.
        //LLama a morir.
    }
    public void morir() {
        //hambre >= 100 resta animal de habitat.
        habitat.addComida(metabolismo, TipoAlimento.CARNE);
    }
    public abstract String getSonido();
    public void setHabitat(Habitat habitat) {this.habitat = habitat;}
    public int getMaxTemp(){return this.tempMax;}
}
