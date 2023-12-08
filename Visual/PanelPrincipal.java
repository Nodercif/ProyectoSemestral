package Visual;
import Lógico.Animal;
import Lógico.Animales.OsoPolar;
import Lógico.Visitante;
import Lógico.VisitanteVIP;
import Lógico.ZooManager;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PanelPrincipal extends JPanel {
    static PanelPrincipal instance;
    public PanelHabitat panelesHabitat[] = new PanelHabitat[5];
    private PanelInformacion panelInformacion;
    private ArrayList<VisitanteVisual> visitantes;
    private Image fondo;
    private MenuDeCompra menuDeCompra;
    public PanelPrincipal() {
        super();
        instance = this;
        menuDeCompra = new MenuDeCompra();
        add(menuDeCompra);
        panelInformacion = new PanelInformacion();
        add(panelInformacion);
        visitantes = new ArrayList<VisitanteVisual>();
        try {
            fondo = ImageIO.read(new File("recursos/fondo.png"));
        }catch (IOException e){
            System.err.print("No se ha podido cargar la imagen de fondo =(");
            System.exit(69);
        }
        this.setLayout(null);
        for(int i=0;i<5;i++)panelesHabitat[i] = new PanelHabitat( ZooManager.getInstance().habitats[i]);
        panelesHabitat[0].setBounds(130,150,300,160);
        panelesHabitat[1].setBounds(130,380,300,160);
        panelesHabitat[2].setBounds(550,150,300,160);
        panelesHabitat[3].setBounds(550,380,300,160);
        panelesHabitat[4].setBounds(900,250,300,160);
        for(int i=0;i<5;i++){this.add(panelesHabitat[i]);panelesHabitat[i].setVisible(true);}

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int contador = 0;
                boolean sinSeleccion = true;
                if(panelInformacion.isVisible() && panelInformacion.getBounds().contains(e.getPoint()))
                    return;
                for(PanelHabitat h : panelesHabitat) {
                    if(h.getBounds().contains(e.getPoint())) {
                        sinSeleccion = false;
                        if(h!=menuDeCompra.getPanelHabitatSeleccionado())
                            menuDeCompra.cerrarMenu();
                        if(h!=panelInformacion.getPanelHabitatSeleccionado())
                            panelInformacion.cerrarMenu();
                        if(h.getHabitat() == null){
                            menuDeCompra.abrirMenu(contador,MenuDeCompra.COMPRAHABITAT);
                        }else{
                            //abrir panel informacion
                            panelInformacion.abrirMenu(contador);
                        }

                    }
                    contador += 1;
                }
                if(sinSeleccion){
                    menuDeCompra.cerrarMenu();
                    panelInformacion.cerrarMenu();
                }
            }
        });
        //visitantes
        Timer timer = new Timer(20, e -> {
            for(VisitanteVisual v : visitantes){
                v.tick();
            }
        });
        timer.start();
        //testing
        Animal ani = new OsoPolar("jeff",panelesHabitat[0].getHabitat());
        AnimalVisual aniv =new AnimalVisual(panelesHabitat[0],ani);
        aniv.addDestino(100,60);
        panelesHabitat[0].addAnimal(aniv);
        for(int i=0;i<9;i++){
            Visitante vis = new Visitante();
            visitantes.add(new VisitanteVisual(vis));
        }

    }
    public static PanelPrincipal getInstance() {
        return instance;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(fondo, 0, 0, this);
        paintChildren(g);
        for(VisitanteVisual v : visitantes){
            g.drawImage(v.getImagen(),v.getPosX(), v.getPosY(), this);
        }
    }
}
