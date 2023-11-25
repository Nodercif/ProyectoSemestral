package Lógico;

public class ZooManager {
    private int money;
    public Habitat habitat1;
    public Habitat habitat2;
    public Habitat habitat3;
    public Habitat habitat4;
    public ZooManager(int dineroInicial){
        this.money = dineroInicial;
        habitat1 = null;
        habitat2 = null;
        habitat3 = null;
        habitat4 = null;

    }
    public void comprarHabitat(Habitat compra, int costo){

    }
    public void addMoney(int cantidad){this.money += cantidad;}
    public void removeMoney(int cantidad){this.money -= cantidad;}
    public int getMoney(){return this.money;}

}
