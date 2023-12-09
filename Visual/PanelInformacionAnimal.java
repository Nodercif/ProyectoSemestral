package Visual;

import Logico.*;

import javax.swing.*;
import java.awt.*;

public class PanelInformacionAnimal extends JPanel {
    private Animal animal;
    private JTextArea informacionAnimal;
    private Image imagenAnimal;
    public PanelInformacionAnimal() {
        this.setLayout(null);
        this.setVisible(true);
        informacionAnimal = new JTextArea();
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
        informacionAnimal.setBounds(20, 180, 260, 180);
        informacionAnimal.setBackground(new Color(160, 230, 140));
        informacionAnimal.setFont(new Font("Arial", Font.BOLD, 14));
        informacionAnimal = new JTextArea("Animal: " + animal.getEspecie() + ".\nNombre: " + /*animal.getNombre +*/
                ".\nTemperaturas optimas: " + animal.getMinTemp() + " - " + animal.getMaxTemp() + ".\nHumedad optima: " +
                animal.getMinHum() + " - " + animal.getMinHum() + ".");
        this.add(informacionAnimal);
    }
    public void setImagenAnimal(Image imagenAnimal) {
        this.imagenAnimal = imagenAnimal;
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
