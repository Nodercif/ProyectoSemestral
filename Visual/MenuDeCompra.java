package Visual;
import Logico.*;
import Logico.Animales.OsoPolar;
import Logico.Animales.Panda;
import Logico.Animales.Zorro;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class MenuDeCompra extends JPanel{
    /**te fijas como te 'mueves' al apretar la flecha para ver mas botones? esto es esa poscicion*/
    private int indiceDisplayBotones;
    private ArrayList<JButton> botonesDeCompraHabitat;
    private ArrayList<JButton> botonesDeCompraAnimal;
    private ArrayList<JButton> botonesDeCompraComida;
    private ArrayList<JButton> botonesQueEstamosUsando;
    private JButton botonMoverseIzquierda;
    private JButton botonMoverseDerecha;
    private int numeroHabitatSeleccionado;
    private PanelHabitat panelHabitatSeleccionado;
    public static final int COMPRAHABITAT = 1;
    public static final int COMPRAANIMAL = 2;
    public static final int COMPRACOMIDA = 3;
    public MenuDeCompra() {
        this.setVisible(false);
        botonesDeCompraHabitat = new ArrayList<>();
        botonesDeCompraAnimal = new ArrayList<>();
        botonesDeCompraComida = new ArrayList<>();
        indiceDisplayBotones = 0;
        this.setBackground(new Color(220, 250, 180));
        this.setBorder(new LineBorder(Color.gray,5));
        this.setBounds(20, 550, 1220, 120);
        this.setLayout(null);
        //inicializar los botones para comprar habitat
        for(int i = 0; i < 5; i++) {
            botonesDeCompraHabitat.add(new JButton());
            final int tipoHabitat = i+1;
            botonesDeCompraHabitat.get(i).addActionListener(e -> comprarHabitat(tipoHabitat));
            ImageIcon icono = new ImageIcon("recursos/botones/habitat" + i + ".png");
            icono.setImage(icono.getImage().getScaledInstance(240, 120, Image.SCALE_SMOOTH));
            botonesDeCompraHabitat.get(i).setIcon(icono);
        }
        //inizializar botones para comprar animales
        for(int i = 0; i < 12; i++) {
            botonesDeCompraAnimal.add(new JButton());
            final int tipoAnimal = i + 1;
            botonesDeCompraAnimal.get(i).addActionListener(e -> comprarAnimal(tipoAnimal));
            ImageIcon icono = new ImageIcon("recursos/botones/animal" + i + ".png");
            icono.setImage(icono.getImage().getScaledInstance(240, 120, Image.SCALE_SMOOTH));
            botonesDeCompraAnimal.get(i).setIcon(icono);
        }
        //inicializar botones para comprar comida
        for(int i = 0; i < 5; i++) {
            botonesDeCompraComida.add(new JButton());
            final int tipoComida = i + 1;
            botonesDeCompraComida.get(i).addActionListener(e -> comprarComida(tipoComida));
            ImageIcon icono = new ImageIcon("recursos/botones/comida" + i + ".png");
            icono.setImage(icono.getImage().getScaledInstance(240, 120, Image.SCALE_SMOOTH));
            botonesDeCompraComida.get(i).setIcon(icono);
        }
        //inicializar botones para navegar el menu
        botonMoverseDerecha = new JButton("->");
        botonMoverseDerecha.addActionListener(e -> desplazarseDerecha());
        botonMoverseDerecha.setBounds(1140,30,60,60);

        botonMoverseIzquierda = new JButton("<-");
        botonMoverseIzquierda.addActionListener(e -> desplazarseIzquierda());
        botonMoverseIzquierda.setBounds(20,30,60,60);
    }
    public void abrirMenu(int habitatSeleccionado, int tipoCompra) {
        cerrarMenu();
        this.add(botonMoverseDerecha);
        this.add(botonMoverseIzquierda);
        this.numeroHabitatSeleccionado = habitatSeleccionado;
        this.panelHabitatSeleccionado = PanelPrincipal.getInstance().panelesHabitat[numeroHabitatSeleccionado];
        panelHabitatSeleccionado.esteHabitatEstaSeleccionado = true;
        this.setVisible(true);
        switch (tipoCompra) {
            case COMPRAHABITAT:
                botonesQueEstamosUsando = botonesDeCompraHabitat;
                break;
            case COMPRAANIMAL:
                botonesQueEstamosUsando = botonesDeCompraAnimal;
                break;
            case COMPRACOMIDA:
                botonesQueEstamosUsando = botonesDeCompraComida;
                break;
        }
        indiceDisplayBotones = 0;
        botonMoverseIzquierda.setVisible(false);
        if (botonesQueEstamosUsando.size() <= 4) botonMoverseDerecha.setVisible(false);
        else {
            botonMoverseDerecha.setVisible(true);
        }
        addBotonesQueEstamosUsando();

    }
    /** quita los botones que ya estan, aumenta el indice en uno y despues coloca los correctos*/
    private void desplazarseDerecha(){
        for(int i=indiceDisplayBotones; i < i+4 && i<botonesQueEstamosUsando.size() ; i++)
            this.remove(botonesQueEstamosUsando.get(i));
        for(int i=0;i < (4-botonesQueEstamosUsando.size()-indiceDisplayBotones);i++)
            this.remove(botonesQueEstamosUsando.get(i));

        indiceDisplayBotones++;

        if(indiceDisplayBotones >= botonesQueEstamosUsando.size()-4){
            botonMoverseDerecha.setVisible(false);
        }
        addBotonesQueEstamosUsando();

        botonMoverseIzquierda.setVisible(true);
    }
    /**quita los botones que ya estan y disminuye el indice en uno, despues coloca los botones a partir del indice*/
    private void desplazarseIzquierda(){
        for(int i=indiceDisplayBotones; i < i+4 && i<botonesQueEstamosUsando.size() ; i++)
            this.remove(botonesQueEstamosUsando.get(i));
        for(int i=0;i < (4-botonesQueEstamosUsando.size()-indiceDisplayBotones);i++)
            this.remove(botonesQueEstamosUsando.get(i));

        indiceDisplayBotones--;
        if(indiceDisplayBotones <= 0) {
            botonMoverseIzquierda.setVisible(false);
        }
        addBotonesQueEstamosUsando();
        botonMoverseDerecha.setVisible(true);
    }
    /** dado el arreglo de botones que tenemos seleccionado, coloca cuatro botones en el panel a partir del indice*/
    private void addBotonesQueEstamosUsando(){
        int counter=0;
        for(int i=indiceDisplayBotones; i < indiceDisplayBotones+4 && i<botonesQueEstamosUsando.size() ; i++){
            JButton b = botonesQueEstamosUsando.get(indiceDisplayBotones+counter);
            b.setBounds(200+200*counter,10,100,100);
            this.add(b);
            counter++;
        }
        for(int i=0;i < (4-botonesQueEstamosUsando.size()-indiceDisplayBotones);i++){
            JButton b = botonesQueEstamosUsando.get(indiceDisplayBotones+counter);
            b.setBounds(200+200*counter,10,100,100);
            this.add(b);
            counter++;
        }
    }
    public void comprarHabitat(int tipoHabitat) {
        Habitat habitat;
        Image imagen;
        switch (tipoHabitat) {
            // Habitat bosque:
            case 1:
                habitat = new Habitat(15, 30);
                imagen = (new ImageIcon("recursos/habitats/habitatBosque.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
                ZooManager.getInstance().comprarHabitat(habitat, 3000, numeroHabitatSeleccionado);
                panelHabitatSeleccionado.setHabitat(habitat);
                panelHabitatSeleccionado.setImagenHabitat(imagen);
                break;

            // Habitat sabana:
            case 2:
                habitat = new Habitat(30, -30);
                imagen = (new ImageIcon("recursos/habitats/habitatSabana.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
                ZooManager.getInstance().comprarHabitat(habitat, 5000, numeroHabitatSeleccionado);
                panelHabitatSeleccionado.setHabitat(habitat);
                panelHabitatSeleccionado.setImagenHabitat(imagen);
                break;

            // Habitat desierto:
            case 3:
                habitat = new Habitat(40, -40);
                imagen = (new ImageIcon("recursos/habitats/habitatDesierto.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
                ZooManager.getInstance().comprarHabitat(habitat, 7000, numeroHabitatSeleccionado);
                panelHabitatSeleccionado.setHabitat(habitat);
                panelHabitatSeleccionado.setImagenHabitat(imagen);
                break;

            // Habitat acuatica:
            case 4:
                habitat = new Habitat(25, 100);
                imagen = (new ImageIcon("recursos/habitats/habitatAcuatica.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
                ZooManager.getInstance().comprarHabitat(habitat, 9000, numeroHabitatSeleccionado);
                panelHabitatSeleccionado.setHabitat(habitat);
                panelHabitatSeleccionado.setImagenHabitat(imagen);
                break;

            // Habitat polar:
            case 5:
                habitat = new Habitat(-40, 100);
                imagen = (new ImageIcon("recursos/habitats/habitatPolar.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
                ZooManager.getInstance().comprarHabitat(habitat, 11000, numeroHabitatSeleccionado);
                panelHabitatSeleccionado.setHabitat(habitat);
                panelHabitatSeleccionado.setImagenHabitat(imagen);
                break;
        }
        cerrarMenu();
    }
    public void comprarComida(int tipoComida) {
        Habitat habitat = panelHabitatSeleccionado.getHabitat();
        switch (tipoComida) {
            // Comida carne:
            case 1:
                habitat.addComida(20, TipoAlimento.CARNE);
                ZooManager.getInstance().removeMoney(200);
                break;
            // Comida follaje:
            case 2:
                habitat.addComida(50, TipoAlimento.FOLLAJE);
                ZooManager.getInstance().removeMoney(200);
                break;
            // Comida pescado:
            case 3:
                habitat.addComida(30, TipoAlimento.PESCADO);
                ZooManager.getInstance().removeMoney(200);
                break;
            // Comida fruta:
            case 4:
                habitat.addComida(40, TipoAlimento.FRUTA);
                ZooManager.getInstance().removeMoney(200);
                break;
        }
    }
    public void comprarAnimal(int tipoAnimal) {
        switch (tipoAnimal) {
            // Animal Oso polar:
            case 1:
                comprarAnimal(OsoPolar.class);
                break;
            // Animal Panda:
            case 2:
                comprarAnimal(Panda.class);
                break;
            // Animal zorro:
            case 3:
                comprarAnimal(Zorro.class);
                break;
        }
        //TODO resto de animales
    }
    public <T> void comprarAnimal(Class<T> claseAnimal) {
        Habitat habitat = panelHabitatSeleccionado.getHabitat();
        Animal animal;
        AnimalVisual animalVisual;
        try {
            animal = (Animal)claseAnimal.getDeclaredConstructor(Habitat.class).newInstance(habitat);
            animalVisual = new AnimalVisual(panelHabitatSeleccionado, animal);
            animalVisual.setImagen((new ImageIcon("recursos/animales/" + animal.getEspecie().replaceAll("\\s", "") + ".png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
            habitat.addAnimal(animal);
            panelHabitatSeleccionado.addAnimal(animalVisual);
            ZooManager.getInstance().removeMoney(animal.getPrecio());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void cerrarMenu(){
        this.setVisible(false);
        if(panelHabitatSeleccionado != null)
            panelHabitatSeleccionado.esteHabitatEstaSeleccionado = false;
        this.removeAll();
    }
    public PanelHabitat getPanelHabitatSeleccionado(){return panelHabitatSeleccionado;}
}
