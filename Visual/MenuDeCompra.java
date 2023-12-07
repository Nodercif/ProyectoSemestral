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
    public static final int COMPRAHABITAT = 1;
    public static final int COMPRAANIMAL = 2;
    public MenuDeCompra() {
        this.setLayout(new GridLayout(1,5));
        this.setVisible(false);
        botonesHabitat = new ArrayList<JButton>();
        this.setBackground(Color.white);
        this.setBounds(20, 550, 1220, 120);

        for(int i = 0; i < 5; i++) {
            botonesHabitat.add(new JButton());
        }
        // Asignar acciones a los botones para comprar habitats ////////////////////////////////////////////
        ActionListener comprarHabitatBosque = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprarHabitat(1);
            }
        };
        botonesHabitat.get(0).addActionListener(comprarHabitatBosque);
        ActionListener comprarHabitatSabana = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprarHabitat(2);
            }
        };
        botonesHabitat.get(1).addActionListener(comprarHabitatSabana);
        ActionListener comprarHabitatDesierto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprarHabitat(3);
            }
        };
        botonesHabitat.get(2).addActionListener(comprarHabitatDesierto);
        ActionListener comprarHabitatAcuatica = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprarHabitat(4);
            }
        };
        botonesHabitat.get(3).addActionListener(comprarHabitatAcuatica);
        ActionListener comprarHabitatPolar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comprarHabitat(5);
            }
        };
        botonesHabitat.get(4).addActionListener(comprarHabitatBosque);
        /////////////////////////////////////////////////////////////////////////////////////////////////////
        int i=0;
        for(JButton b : botonesHabitat){
            ImageIcon icono = new ImageIcon("recursos/botones/boton" + i + ".png");
            icono.setImage(icono.getImage().getScaledInstance(240, 120, Image.SCALE_SMOOTH));
            b.setIcon(icono);
            i++;
        }
    }
    public void abrirMenu(int habitatSeleccionado, int tipoCompra) {
        cerrarMenu();
        this.numeroHabitatSeleccionado = habitatSeleccionado;
        this.panelHabitatSeleccionado =PanelPrincipal.getInstance().panelesHabitat[numeroHabitatSeleccionado];
        panelHabitatSeleccionado.esteHabitatEstaSeleccionado = true;
        this.setVisible(true);
        if(tipoCompra == COMPRAHABITAT){
            for(JButton b : botonesHabitat){
                b.setVisible(true);
                this.add(b);
            }
        }else if(tipoCompra == COMPRAANIMAL){
            //TODO
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
                ZooManager.getInstance().comprarHabitat(habitat, 3000, 1);
                panelHabitatSeleccionado.setHabitat(habitat);
                panelHabitatSeleccionado.setImagenHabitat(imagen);
                break;

            // Habitat sabana:
            case 2:
                habitat = new Habitat(30, -30);
                imagen = (new ImageIcon("recursos/habitats/habitatSabana.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
                ZooManager.getInstance().comprarHabitat(habitat, 5000, 2);
                panelHabitatSeleccionado.setHabitat(habitat);
                panelHabitatSeleccionado.setImagenHabitat(imagen);
                break;

            // Habitat desierto:
            case 3:
                habitat = new Habitat(40, -40);
                imagen = (new ImageIcon("recursos/habitats/habitatDesierto.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
                ZooManager.getInstance().comprarHabitat(habitat, 7000, 3);
                panelHabitatSeleccionado.setHabitat(habitat);
                panelHabitatSeleccionado.setImagenHabitat(imagen);
                break;

            // Habitat acuatica:
            case 4:
                habitat = new Habitat(25, 100);
                imagen = (new ImageIcon("recursos/habitats/habitatAcuatica.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
                ZooManager.getInstance().comprarHabitat(habitat, 9000, 4);
                panelHabitatSeleccionado.setHabitat(habitat);
                panelHabitatSeleccionado.setImagenHabitat(imagen);
                break;

            // Habitat polar:
            case 5:
                habitat = new Habitat(-40, 100);
                imagen = (new ImageIcon("recursos/habitats/habitatPolar.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
                ZooManager.getInstance().comprarHabitat(habitat, 11000, 5);
                panelHabitatSeleccionado.setHabitat(habitat);
                panelHabitatSeleccionado.setImagenHabitat(imagen);
                break;
        }
        cerrarMenu();
    }
    public void cerrarMenu(){
        this.setVisible(false);
        if(panelHabitatSeleccionado != null)
            panelHabitatSeleccionado.esteHabitatEstaSeleccionado = false;
    }
    public PanelHabitat getPanelHabitatSeleccionado(){return panelHabitatSeleccionado;}
}
