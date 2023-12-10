package Visual;
import Logico.TipoAlimento;
import Logico.ZooManager;
import Logico.Visitante;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class PanelPrincipal extends JPanel {
    static PanelPrincipal instance;
    public PanelHabitat panelesHabitat[] = new PanelHabitat[5];
    private MenuDeInformacion menuDeInformacion;
    private MenuDeCompra menuDeCompra;
    private ArrayList<VisitanteVisual> visitantes;
    private JLabel contadorDeDinero;
    private Image fondo;
    private ArrayList<IconoInformacion> iconosInfo;

    public PanelPrincipal() {
        super();
        instance = this;
        menuDeCompra = new MenuDeCompra();
        add(menuDeCompra);
        menuDeInformacion = new MenuDeInformacion(menuDeCompra);
        add(menuDeInformacion);
        visitantes = new ArrayList<VisitanteVisual>();
        iconosInfo = new ArrayList<>();
        contadorDeDinero = new JLabel();
        contadorDeDinero.setBounds(1100, 20, 300, 20);
        contadorDeDinero.setFont(new Font("Arial", Font.BOLD, 14));
        this.add(contadorDeDinero);
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
                if(menuDeInformacion.isVisible() && menuDeInformacion.getBounds().contains(e.getPoint()))
                    return;
                for(PanelHabitat h : panelesHabitat) {
                    if(h.getBounds().contains(e.getPoint())) {
                        sinSeleccion = false;
                        if(h!= menuDeCompra.getPanelHabitatSeleccionado())
                            menuDeCompra.cerrarMenu();
                        if(h!= menuDeInformacion.getPanelHabitatSeleccionado())
                            menuDeInformacion.cerrarMenu();
                        if(h.getHabitat() == null){
                            menuDeCompra.abrirMenu(contador, MenuDeCompra.COMPRAHABITAT);
                        }else{
                            // Abrir panel informacion
                            menuDeInformacion.abrirMenu(contador);
                        }
                    }
                    contador += 1;
                }
                if(menuDeCompra.isVisible() && menuDeCompra.getBounds().contains(e.getPoint())){
                    sinSeleccion = false;
                }
                if(sinSeleccion){
                    menuDeCompra.cerrarMenu();
                    menuDeInformacion.cerrarMenu();
                }
            }
        });
        //testing
        for(int i=0;i<40;i++){
            Visitante vis = new Visitante();
            visitantes.add(new VisitanteVisual(vis));
        }

    }
    /** la ventana va a llamar a tick cada 20 ms */
    public void tick(){
        for(VisitanteVisual v : visitantes){
            v.tick();
        }
        for(int i=0;i<5;i++){
            panelesHabitat[i].tick();
        }
        contadorDeDinero.setText("Dinero: " + ZooManager.getInstance().getMoney());

        iconosInfo.removeIf(info -> info.tick() == 0);
    }
    /**Añade un iconoDeInformacion al panel. De esos que suben y se desvanecen*/
    public void mostrarIconoInformacion(IconoInformacion info){
        iconosInfo.add(info);
    }
    public static PanelPrincipal getInstance() {
        return instance;
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //dibujar fondo
        g.drawImage(fondo, 0, 0, this);
        //dibujar paneles
        for(PanelHabitat p : panelesHabitat){
            g.drawImage(p.imagenHabitat,p.getX(),p.getY(),this);
            for(AnimalVisual a : p.getAnimalesVisual()){
                g.drawImage(a.getImagen(),a.getPosX()+p.getX(),a.getPosY()+p.getY(),this);
            }
        }
        //dibujar visitantes
        for(VisitanteVisual v : visitantes){
            g.drawImage(v.getImagen(),v.getPosX(), v.getPosY(), this);
        }
        Graphics2D g2d = (Graphics2D) g;
        //dibujar esos iconos pop up de informacion
        for(IconoInformacion inf : iconosInfo){
            g2d.setColor(inf.colorTexto);
            g2d.drawString(inf.getText(),inf.getX(),inf.getY());
            if(inf.icono != null){
                g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, inf.colorTexto.getAlpha() / 255.0f));
                g2d.drawImage(inf.getImage(),inf.getX(), inf.getY()+3,this );
            }
        }
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
    }
}
