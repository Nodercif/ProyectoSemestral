package Visual;
import Lógico.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class MenuDeCompra extends JPanel{
    private ArrayList<JButton> botonesHabitat;
    private int habitatSeleccionada;
    public MenuDeCompra() {
        this.setLayout(new GridLayout(1,5));
        botonesHabitat = new ArrayList<JButton>();
        this.setBackground(Color.white);
        this.setBounds(20, 550, 1220, 120);

        for(int i = 0; i < 5; i++) {
            ImageIcon icono = new ImageIcon("recursos/botones/boton" + i + ".png");
            icono.setImage(icono.getImage().getScaledInstance(240, 120, Image.SCALE_SMOOTH));
            botonesHabitat.add(new JButton(icono));
        }


    }
    public void mostrarPanel(int habitatSeleccionada) {
        this.habitatSeleccionada = habitatSeleccionada;
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
        switch (tipoHabitat) {
            //TODO;
        }
        Habitat habitat = new Habitat(20, 20);
        ZooManager.getInstance().comprarHabitat(habitat, 100, 1);
        PanelPrincipal.getInstance().panelesHabitat[habitatSeleccionada].setHabitat(habitat);
    }

}
