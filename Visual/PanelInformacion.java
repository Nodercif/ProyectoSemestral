package Visual;

import Lógico.Habitat;

import javax.swing.*;
import java.awt.*;

public class PanelInformacion extends JPanel {
    private int numeroHabitatSeleccionado;
    private PanelHabitat panelHabitatSeleccionado;
    private Habitat habitat;

    public PanelInformacion() {
        this.setLayout(null);
        this.setVisible(false);
        this.setBackground(Color.white);
        this.setBounds(20, 550, 300, 600);

    }
    public void abrirMenu(int habitatSeleccionado){
        cerrarMenu();
        numeroHabitatSeleccionado = habitatSeleccionado;
        panelHabitatSeleccionado = PanelPrincipal.getInstance().panelesHabitat[numeroHabitatSeleccionado];
        habitat = panelHabitatSeleccionado.getHabitat();
        panelHabitatSeleccionado.esteHabitatEstaSeleccionado = true;
        if(habitatSeleccionado<2){
            this.setBounds(690, 70, 300, 550);
        }else{
            this.setBounds(120, 70, 300, 550);
        }
        this.setVisible(true);
    }
    public void cerrarMenu(){
        this.setVisible(false);
        if(panelHabitatSeleccionado != null)
            panelHabitatSeleccionado.esteHabitatEstaSeleccionado = false;
    }
    public PanelHabitat getPanelHabitatSeleccionado(){return panelHabitatSeleccionado;}
}
