package Visual;

import Logico.*;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class MenuDeInformacion extends JPanel{
    private int numeroHabitatSeleccionado;
    private PanelHabitat panelHabitatSeleccionado;
    private ArrayList<AnimalVisual> animalesVisuales;
    private Habitat habitat;
    private MenuDeCompra menuDeCompra;
    private JButton botonComprarAnimal;
    private JButton botonComprarComida;
    private JButton cambiarAnimalIzquierda;
    private JButton cambiarAnimalDerecha;
    private JLabel tituloPanel;
    private JTextArea informacionHabitat;
    private PanelInformacionAnimal panelInformacionAnimal;
    private int poscicionListaAnimales;

    public MenuDeInformacion(MenuDeCompra menuDeCompra) {
        this.setLayout(null);
        this.setVisible(false);
        this.setBackground(new Color(220, 250, 180));
        this.setBorder(new LineBorder(Color.gray,5));
        tituloPanel = new JLabel("Informacion Habitat");
        tituloPanel.setBounds(90, 10, 300, 10);
        this.menuDeCompra = menuDeCompra;
        panelInformacionAnimal = new PanelInformacionAnimal();
        //Botones:
        botonComprarAnimal = new JButton("<html>Comprar<br> Animal</html>");
        botonComprarComida = new JButton("<html>Comprar<br> Comida</html>");
        cambiarAnimalIzquierda = new JButton("<-");
        cambiarAnimalDerecha = new JButton("->");
        //Coordenadas botones:
        botonComprarAnimal.setBounds(30, 370, 110, 80);
        botonComprarComida.setBounds(160, 370, 110, 80);
        cambiarAnimalIzquierda.setBounds(20, 70, 50, 30);
        cambiarAnimalDerecha.setBounds(230, 70, 50, 30);
        //Asignar accion:
        botonComprarAnimal.addActionListener(e -> abrirMenuCompraAnimal());
        botonComprarComida.addActionListener(e -> abrirMenuCompraComida());
        cambiarAnimalIzquierda.addActionListener(e -> disminuirPoscicion());
        cambiarAnimalDerecha.addActionListener(e -> incrementarPoscicion());
        //Agregar al panel:
        this.add(tituloPanel);
        this.add(botonComprarAnimal);
        this.add(botonComprarComida);
        this.add(cambiarAnimalIzquierda);
        this.add(cambiarAnimalDerecha);
        this.add(panelInformacionAnimal);
    }
    public void abrirMenu(int habitatSeleccionado){
        cerrarMenu();
        numeroHabitatSeleccionado = habitatSeleccionado;
        panelHabitatSeleccionado = PanelPrincipal.getInstance().panelesHabitat[numeroHabitatSeleccionado];
        animalesVisuales = panelHabitatSeleccionado.getAnimalesVisual();
        habitat = panelHabitatSeleccionado.getHabitat();
        panelHabitatSeleccionado.esteHabitatEstaSeleccionado = true;

        ////////////////////////////////////INFORMACION HABITAT////////////////////////////////////
        int cantidadAnimales;
        if(habitat.getAnimales() == null) {
            cantidadAnimales = 0;
        }
        else {
            cantidadAnimales = habitat.getAnimales().size();
        }
        informacionHabitat = new JTextArea("Temperatura del habitat: " + habitat.getTemperatura() +
                ".\nHumedad del habitat: " + habitat.getHumedad() + ".\nCantidad de animales en el habitat: " +
                cantidadAnimales + ".");
        informacionHabitat.setBounds(20, 130, 260, 45);
        informacionHabitat.setBackground(new Color(160, 230, 140));
        informacionHabitat.setFont(new Font("Arial", Font.BOLD, 12));
        informacionHabitat.setEditable(false);
        this.add(informacionHabitat);
        ////////////////////////////////////INFORMACION HABITAT////////////////////////////////////

        //Mostrar panel segun habitat seleccionada:
        if(habitatSeleccionado < 2){
            this.setBounds(690, 50, 300, 480);
        }else{
            this.setBounds(120, 50, 300, 480);
        }
        this.setVisible(true);
    }
    public void abrirMenuCompraAnimal() {
        menuDeCompra.abrirMenu(numeroHabitatSeleccionado, MenuDeCompra.COMPRAANIMAL);
        cerrarMenu();
    }
    public void abrirMenuCompraComida() {
        menuDeCompra.abrirMenu(numeroHabitatSeleccionado, MenuDeCompra.COMPRACOMIDA);
        cerrarMenu();
    }
    public void incrementarPoscicion() {
        if(habitat.getAnimales().size() > 0) {
            if(poscicionListaAnimales < habitat.getAnimales().size()) {
                poscicionListaAnimales ++;
            }
            else {
                poscicionListaAnimales = 0;
            }
        }
        panelInformacionAnimal.setAnimal(habitat.getAnimales().get(poscicionListaAnimales));
    }
    public void disminuirPoscicion() {
        if(habitat.getAnimales().size() > 0) {
            if(poscicionListaAnimales > 0) {
                poscicionListaAnimales --;
            }
            else {
                poscicionListaAnimales = habitat.getAnimales().size();
            }
        }
        panelInformacionAnimal.setAnimal(habitat.getAnimales().get(poscicionListaAnimales));
    }
    public void cerrarMenu(){
        this.setVisible(false);
        if(panelHabitatSeleccionado != null) {
            panelHabitatSeleccionado.esteHabitatEstaSeleccionado = false;
        }
    }
    public PanelHabitat getPanelHabitatSeleccionado(){ return panelHabitatSeleccionado; }
}
