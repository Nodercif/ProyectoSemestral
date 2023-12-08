package Visual;

import Logico.*;

import javax.swing.*;
import java.awt.*;

public class PanelInformacionAnimal extends JPanel {
    private Animal animal;
    private JTextArea informacionAnimal;
    private Image imagenAnimal;
    public PanelInformacionAnimal() {
    }
    public void setAnimal(Animal animal) {
        this.animal = animal;
        informacionAnimal = new JTextArea("Animal: " + animal.getEspecie() + ".\nNombre: " + /*animal.getNombre +*/
                ".\nTemperaturas optimas: " + animal.getMinTemp() + " - " + animal.getMaxTemp() + ".\nHumedad optima: " +
                animal.getMinHum() + " - " + animal.getMinHum() + ".");
    }
    public void setImagenAnimal(Image imagenAnimal) {
        this.imagenAnimal = imagenAnimal;
    }

}
