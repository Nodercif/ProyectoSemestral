package Lógico;

public class ZooManager {
    private int money;
    public Habitat habitat1;
    public Habitat habitat2;
    public Habitat habitat3;
    public Habitat habitat4;
    private static ZooManager instance;
    public ZooManager(int dineroInicial) {
        this.money = dineroInicial;
        habitat1 = null;
        habitat2 = null;
        habitat3 = null;
        habitat4 = null;
    }
    public static ZooManager getInstance() {
        if(instance == null){
            instance = new ZooManager(10000);
        }
        return instance;
    }
    public void comprarHabitat(Habitat compra, int costo, int habitatSeleccionada) {
        switch (habitatSeleccionada) {
            case 1 : habitat1 = compra; break;
            case 2 : habitat2 = compra; break;
            case 3 : habitat3 = compra; break;
            case 4 : habitat4 = compra; break;
        }
        this.money -= costo;
    }
    public void addMoney(int cantidad){this.money += cantidad;}
    public void removeMoney(int cantidad){this.money -= cantidad;}
    public int getMoney(){return this.money;}
}
