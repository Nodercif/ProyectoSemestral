package Visual;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    public Ventana() {
        super();
        this.setLayout(new BorderLayout());
        this.setTitle("El Increíble Zoológico Digital");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
