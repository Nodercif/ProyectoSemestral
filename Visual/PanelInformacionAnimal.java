package Visual;

import Logico.*;

import javax.swing.*;
import java.awt.*;

public class PanelInformacionAnimal extends JTextArea {
    private Animal animal;
    private Image imagenAnimal;
    public PanelInformacionAnimal() {
        this.setLayout(null);
    }
    public void setAnimal(Animal animal) {
        this.setVisible(true);
        this.animal = animal;
        this.setBounds(20, 100, 260, 85);
        this.setBackground(new Color(160, 230, 140));
        this.setFont(new Font("Arial", Font.BOLD, 12));
        this.setText("  Animal: " + animal.getEspecie() + ".\n  Nombre: " + /*animal.getNombre +*/
                ".\n  Temperaturas optimas:\n  Desde los " + animal.getMinTemp() + " grados hasta los " + animal.getMaxTemp() +
                " grados.\n  Humedad optima: Desde " + animal.getMinHum() + " a " + animal.getMinHum() +
                ".\n  Tamaño del animal: " /*+ animal.getTamaño + "."*/);
        this.setEditable(false);
    }
    public void setImagenAnimal(Image imagenAnimal) {
        this.imagenAnimal = imagenAnimal;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
