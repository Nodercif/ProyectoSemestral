package Visual;

import Logico.*;

import javax.swing.*;
import java.awt.*;

public class PanelInformacionAnimal extends JTextArea {
    public PanelInformacionAnimal() {
        this.setLayout(null);
    }
    public void setAnimal(Animal animal) {
        this.setVisible(true);
        this.setBounds(20, 100, 260, 85);
        this.setBackground(new Color(160, 230, 140));
        this.setFont(new Font("Arial", Font.BOLD, 12));
        if(animal == null) {
            this.setText("No hay animales comprados en este habitat\no no hay seleccionados.");
        }
        else {
            // Para la infromacion del animal:
            this.setText("  Animal: " + animal.getEspecie() + ".\n  Nombre: " + animal.getNombre() +
                    ".\n  Temperaturas optimas:\n  Desde los " + animal.getMinTemp() + " grados hasta los " + animal.getMaxTemp() +
                    " grados.\n  Humedad optima: Desde " + animal.getMinHum() + " a " + animal.getMaxHum() +
                    ".\n  Tamaño del animal: " + animal.getGranditud() + ".");
        }
        this.setEditable(false);

    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
