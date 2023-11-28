package Lógico;

import java.util.ArrayList;

public class ZooManager {
    private int money;
    public Habitat habitats[] = new Habitat[5];
    private static ZooManager instance;
    public ZooManager(int dineroInicial) {
        this.money = dineroInicial;
        for(int i=0;i<5;i++){
            habitats[i]=null;
        }
    }
    public static ZooManager getInstance() {
        if(instance == null){
            instance = new ZooManager(10000);
        }
        return instance;
    }
    public void comprarHabitat(Habitat compra, int costo, int habitatSeleccionada) {
        habitats[habitatSeleccionada] = compra;
        this.money -= costo;
    }
    public void addMoney(int cantidad){this.money += cantidad;}
    public void removeMoney(int cantidad){this.money -= cantidad;}
    public int getMoney(){return this.money;}
}
