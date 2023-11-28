package Visual;

import javax.swing.*;
import java.awt.*;

public class Ventana extends JFrame {
    static Ventana instance;
    private PanelPrincipal panelPrincipal;
    public Ventana() {
        super();
        panelPrincipal = new PanelPrincipal();
        this.setLayout(new BorderLayout());
        this.setTitle("El Increíble Zoológico Digital");
        this.setSize(1280, 720);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.add(panelPrincipal);
        this.setVisible(true);
    }

    public static Ventana getInstance() {
        if(instance == null) {
            instance = new Ventana();
        }
        return instance;
    }
}
