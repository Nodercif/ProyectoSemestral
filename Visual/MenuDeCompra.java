package Visual;
import Logico.*;
import Logico.Animales.OsoPolar;
import Logico.Animales.Panda;
import Logico.Animales.Zorro;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuDeCompra extends JPanel{
    private ArrayList<JButton> botonesDeCompraHabitat;
    private ArrayList<JButton> botonesDeCompraAnimal;
    private ArrayList<JButton> botonesDeCompraComida;
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
        //this.setBackground(Color.white);
        this.setBounds(20, 550, 1220, 120);
        for(int i = 0; i < 5; i++) {
            botonesDeCompraHabitat.add(new JButton());
            final int tipoHabitat = i+1;
            botonesDeCompraHabitat.get(i).addActionListener(e -> comprarHabitat(tipoHabitat));
        }
        int i = 0;
        for(JButton b : botonesDeCompraHabitat){
            ImageIcon icono = new ImageIcon("recursos/botones/habitat" + i + ".png");
            icono.setImage(icono.getImage().getScaledInstance(240, 120, Image.SCALE_SMOOTH));
            b.setIcon(icono);
            i++;
        }
        for(i = 0; i < 12; i++) {
            botonesDeCompraAnimal.add(new JButton());
            final int tipoAnimal = i + 1;
            botonesDeCompraAnimal.get(i).addActionListener(e -> comprarAnimal(tipoAnimal));
        }
        i = 0;
        for(JButton b : botonesDeCompraAnimal){
            ImageIcon icono = new ImageIcon("recursos/botones/animal" + i + ".png");
            icono.setImage(icono.getImage().getScaledInstance(240, 120, Image.SCALE_SMOOTH));
            b.setIcon(icono);
            i++;
        }
        for(i = 0; i < 5; i++) {
            botonesDeCompraComida.add(new JButton());
            final int tipoComida = i + 1;
            botonesDeCompraComida.get(i).addActionListener(e -> comprarComida(tipoComida));
        }
        i = 0;
        for(JButton b : botonesDeCompraComida){
            ImageIcon icono = new ImageIcon("recursos/botones/comida" + i + ".png");
            icono.setImage(icono.getImage().getScaledInstance(240, 120, Image.SCALE_SMOOTH));
            b.setIcon(icono);
            i++;
        }
    }
    public void abrirMenu(int habitatSeleccionado, int tipoCompra) {
        cerrarMenu();
        this.numeroHabitatSeleccionado = habitatSeleccionado;
        this.panelHabitatSeleccionado = PanelPrincipal.getInstance().panelesHabitat[numeroHabitatSeleccionado];
        panelHabitatSeleccionado.esteHabitatEstaSeleccionado = true;
        this.setVisible(true);
        if(tipoCompra == COMPRAHABITAT){
            this.setLayout(new GridLayout(1,5));
            for(JButton b : botonesDeCompraHabitat){
                b.setVisible(true);
                this.add(b);
            }
        }else if(tipoCompra == COMPRAANIMAL){
            this.setLayout(new GridLayout(2,6));
            for(JButton b : botonesDeCompraAnimal){
                b.setVisible(true);
                this.add(b);
            }
        }
        else if(tipoCompra == COMPRACOMIDA) {
            this.setLayout(new GridLayout(1,4));
            for(JButton b : botonesDeCompraComida){
                b.setVisible(true);
                this.add(b);
            }
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
       Habitat habitat = panelHabitatSeleccionado.getHabitat();
        Animal animal;
        AnimalVisual animalVisual;
        Image imagen;
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
        cerrarMenu();
    }
    public <T> void comprarAnimal(Class<T> claseAnimal) {
        Habitat habitat = panelHabitatSeleccionado.getHabitat();
        Animal animal;
        AnimalVisual animalVisual;
        try {
            animal = (Animal)claseAnimal.getDeclaredConstructor().newInstance();
            animalVisual = new AnimalVisual(panelHabitatSeleccionado, animal);
            animalVisual.setImagen((new ImageIcon("recursos/animales/" + animal.getEspecie().replaceAll("\\s", "") + ".png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
            panelHabitatSeleccionado.addAnimal(animalVisual);
            habitat.addAnimal(animal);
            ZooManager.getInstance().removeMoney(animal.getPrecio());
        }catch (Exception e){ }
    }
    public void cerrarMenu(){
        this.setVisible(false);
        if(panelHabitatSeleccionado != null)
            panelHabitatSeleccionado.esteHabitatEstaSeleccionado = false;
        this.removeAll();
    }
    public PanelHabitat getPanelHabitatSeleccionado(){return panelHabitatSeleccionado;}
}
