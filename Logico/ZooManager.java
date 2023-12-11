package Logico;
/** Esta clase representa el control general del zoológico: la compra de habitats y el manejo del dinero.
 * En un ArrayList se almacenan las 5 habitats que se pueden tener dentro del zoologico. */
public class ZooManager {
    private int money;
    public Habitat habitats[] = new Habitat[5];
    private static ZooManager instance;

    /** El constructor de la clase inicializa el ArrayList con habitats vacía y una cantidad dinero inicial.
     * @param dineroInicial es la cantidad con la que se comienza el juego. */
    public ZooManager(int dineroInicial) {
        this.money = dineroInicial;
        for(int i=0;i<5;i++){
            habitats[i]=null;
        }
    }

    /** El método getInstance crea una instancia de la clase y le pasa un valor inicial de dinero. */
    public static ZooManager getInstance() {
        if(instance == null){
            instance = new ZooManager(10000);
        }
        return instance;
    }

    /** El método comprarHabitat sirve para hacer la compra de un habitat.
     * @param compra es el habitat que se compró.
     * @param costo es el valor del habitat. Éste será restado a la cantidad de dinero almacenada..
     * @param habitatSeleccionada es el identificador del habitat, ésta será su poscicion en el ArrayList.
     * @return booleano, si funciono o no la compra*/
    public boolean comprarHabitat(Habitat compra, int costo, int habitatSeleccionada) {
        if(costo > money){
            return false;
        }
        habitats[habitatSeleccionada] = compra;
        this.money -= costo;
        return true;
    }

    /** El método addMoney es llamado cuando se requiere agregar dinero. */
    public void addMoney(int cantidad){this.money += cantidad;}

    /** El método removeMoney es llamado cuando se hace una compra, para remover dinero del deposito. */
    public void removeMoney(int cantidad){this.money -= cantidad;}

    /** El método getMoney entrega la cantidad total de dinero que hay almacenada. */
    public int getMoney(){return this.money;}
}
