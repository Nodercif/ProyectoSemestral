package Visual;
import Lógico.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MenuDeCompra extends JPanel{
    private ArrayList<JButton> botonesHabitat;
    private int numeroHabitatSeleccionado;
    private PanelHabitat panelHabitatSeleccionado;
    public MenuDeCompra() {
        this.setLayout(new GridLayout(1,5));
        this.setVisible(false);
        botonesHabitat = new ArrayList<JButton>();
        this.setBackground(Color.white);
        this.setBounds(20, 550, 1220, 120);

        for(int i = 0; i < 5; i++) {
            ImageIcon icono = new ImageIcon("recursos/botones/boton" + i + ".png");
            icono.setImage(icono.getImage().getScaledInstance(240, 120, Image.SCALE_SMOOTH));
            botonesHabitat.add(new JButton(icono));
        }


    }
    public void abrirMenu(int habitatSeleccionada) {
        cerrarMenu();
        this.numeroHabitatSeleccionado = habitatSeleccionada;
        this.panelHabitatSeleccionado =PanelPrincipal.getInstance().panelesHabitat[habitatSeleccionada];
         panelHabitatSeleccionado.esteHabitatEstaSeleccionado = true;
        this.setVisible(true);
        ActionListener accionComprar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprarHabitat(1);
            }
        };
        for(JButton b : botonesHabitat){
            b.setVisible(true);
            this.add(b);
            b.addActionListener(accionComprar);
        }
    }

    public void comprarHabitat(int tipoHabitat) {
        Habitat habitat;
        Image imagen;
        switch (tipoHabitat) {
            //TODO;
        }
        habitat = new Habitat(20, 20);
        imagen = (new ImageIcon("recursos/habitats/habitat.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);

        ZooManager.getInstance().comprarHabitat(habitat, 100, 1);
        panelHabitatSeleccionado.setHabitat(habitat);
        panelHabitatSeleccionado.setImagenHabitat(imagen);
        cerrarMenu();
    }
    public void cerrarMenu(){
        this.setVisible(false);
        if(panelHabitatSeleccionado != null)
            panelHabitatSeleccionado.esteHabitatEstaSeleccionado = false;
    }
    public PanelHabitat getPanelHabitatSeleccionado(){return panelHabitatSeleccionado;}

}
