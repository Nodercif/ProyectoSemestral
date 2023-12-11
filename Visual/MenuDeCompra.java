package Visual;
import Logico.*;
import Logico.Animales.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.util.ArrayList;

public class MenuDeCompra extends JPanel{
    /**te fijas como te 'mueves' al apretar la flecha para ver mas botones? esto es esa poscicion*/
    private int indiceDisplayBotones;
    private ArrayList<JButton> botonesDeCompraHabitat;
    private ArrayList<JButton> botonesDeCompraAnimal;
    private ArrayList<JButton> botonesDeCompraComida;
    private ArrayList<JButton> botonesQueEstamosUsando;
    private JButton botonMoverseIzquierda;
    private JButton botonMoverseDerecha;
    private int numeroHabitatSeleccionado;
    private PanelHabitat panelHabitatSeleccionado;
    public static final int COMPRAHABITAT = 1;
    public static final int COMPRAANIMAL = 2;
    public static final int COMPRACOMIDA = 3;
    public MenuDeCompra() {
        this.setVisible(false);
        botonesDeCompraHabitat = new ArrayList<>();
        botonesDeCompraAnimal = new ArrayList<>();
        botonesDeCompraComida = new ArrayList<>();
        indiceDisplayBotones = 0;
        this.setBackground(new Color(220, 250, 180));
        this.setBorder(new LineBorder(Color.gray,5));
        this.setBounds(20, 550, 1220, 120);
        this.setLayout(null);
        //inicializar los botones para comprar habitat
        for(int i = 0; i < 5; i++) {
            botonesDeCompraHabitat.add(new JButton());
            final int tipoHabitat = i+1;
            botonesDeCompraHabitat.get(i).addActionListener(e -> comprarHabitat(tipoHabitat));
            ImageIcon icono = new ImageIcon("recursos/botones/habitat" + i + ".png");
            icono.setImage(icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            botonesDeCompraHabitat.get(i).setIcon(icono);
        }
        //inizializar botones para comprar animales
        for(int i = 0; i < 12; i++) {
            botonesDeCompraAnimal.add(new JButton());
            final int tipoAnimal = i + 1;
            botonesDeCompraAnimal.get(i).addActionListener(e -> comprarAnimal(tipoAnimal));
            ImageIcon icono = new ImageIcon("recursos/botones/animal" + i + ".png");
            icono.setImage(icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            botonesDeCompraAnimal.get(i).setIcon(icono);
        }
        //inicializar botones para comprar comida
        for(int i = 0; i < 4; i++) {
            botonesDeCompraComida.add(new JButton());
            final int tipoComida = i + 1;
            botonesDeCompraComida.get(i).addActionListener(e -> comprarComida(tipoComida));
            ImageIcon icono = new ImageIcon("recursos/botones/comida" + i + ".png");
            icono.setImage(icono.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH));
            botonesDeCompraComida.get(i).setIcon(icono);
        }
        //inicializar botones para navegar el menu
        botonMoverseDerecha = new JButton("->");
        botonMoverseDerecha.addActionListener(e -> desplazarseDerecha());
        botonMoverseDerecha.setBounds(1140,30,60,60);

        botonMoverseIzquierda = new JButton("<-");
        botonMoverseIzquierda.addActionListener(e -> desplazarseIzquierda());
        botonMoverseIzquierda.setBounds(20,30,60,60);
    }
    public void abrirMenu(int habitatSeleccionado, int tipoCompra) {
        cerrarMenu();
        this.add(botonMoverseDerecha);
        this.add(botonMoverseIzquierda);
        this.numeroHabitatSeleccionado = habitatSeleccionado;
        this.panelHabitatSeleccionado = PanelPrincipal.getInstance().panelesHabitat[numeroHabitatSeleccionado];
        panelHabitatSeleccionado.esteHabitatEstaSeleccionado = true;
        this.setVisible(true);
        switch (tipoCompra) {
            case COMPRAHABITAT:
                botonesQueEstamosUsando = botonesDeCompraHabitat;
                break;
            case COMPRAANIMAL:
                botonesQueEstamosUsando = botonesDeCompraAnimal;
                break;
            case COMPRACOMIDA:
                botonesQueEstamosUsando = botonesDeCompraComida;
                break;
        }
        indiceDisplayBotones = 0;
        botonMoverseIzquierda.setVisible(false);
        if (botonesQueEstamosUsando.size() <= 4) botonMoverseDerecha.setVisible(false);
        else {
            botonMoverseDerecha.setVisible(true);
        }
        addBotonesQueEstamosUsando();
    }
    /** quita los botones que ya estan, aumenta el indice en uno y despues coloca los correctos*/
    private void desplazarseDerecha(){
        for(int i=indiceDisplayBotones; i < i+4 && i<botonesQueEstamosUsando.size() ; i++)
            this.remove(botonesQueEstamosUsando.get(i));
        for(int i=0;i < (4-botonesQueEstamosUsando.size()-indiceDisplayBotones);i++)
            this.remove(botonesQueEstamosUsando.get(i));

        indiceDisplayBotones++;

        if(indiceDisplayBotones >= botonesQueEstamosUsando.size()-4){
            botonMoverseDerecha.setVisible(false);
        }
        addBotonesQueEstamosUsando();

        botonMoverseIzquierda.setVisible(true);
    }
    /**quita los botones que ya estan y disminuye el indice en uno, despues coloca los botones a partir del indice*/
    private void desplazarseIzquierda(){
        for(int i=indiceDisplayBotones; i < i+4 && i<botonesQueEstamosUsando.size() ; i++)
            this.remove(botonesQueEstamosUsando.get(i));
        for(int i=0;i < (4-botonesQueEstamosUsando.size()-indiceDisplayBotones);i++)
            this.remove(botonesQueEstamosUsando.get(i));

        indiceDisplayBotones--;
        if(indiceDisplayBotones <= 0) {
            botonMoverseIzquierda.setVisible(false);
        }
        addBotonesQueEstamosUsando();
        botonMoverseDerecha.setVisible(true);
    }
    /** dado el arreglo de botones que tenemos seleccionado, coloca cuatro botones en el panel a partir del indice*/
    private void addBotonesQueEstamosUsando(){
        int counter=0;
        for(int i=indiceDisplayBotones; i < indiceDisplayBotones+4 && i<botonesQueEstamosUsando.size() ; i++){
            JButton b = botonesQueEstamosUsando.get(indiceDisplayBotones+counter);
            b.setBounds(200+200*counter,10,100,100);
            this.add(b);
            counter++;
        }
        for(int i=0;i < (4-botonesQueEstamosUsando.size()-indiceDisplayBotones);i++){
            JButton b = botonesQueEstamosUsando.get(indiceDisplayBotones+counter);
            b.setBounds(200+200*counter,10,100,100);
            this.add(b);
            counter++;
        }
    }

    /** Mediante el método comprarHabitat se puede escoger el tipo de habitat que se quiere comprar en el
     área seleccionada.
     @param tipoHabitat es el tipo de habitat que se seleccionó.
     Una vez verificado el tipo de seleccion, se le asigna al habitat una representación visual mediante una imagen y se
     resta dinero en el depósito general de dinero a travéz del ZooManager. */
    public void comprarHabitat(int tipoHabitat) {
        Habitat habitat;
        Image imagen;
        switch (tipoHabitat) {
            // Habitat bosque:
            case 1:
                habitat = new Habitat(15, 30);
                if(ZooManager.getInstance().comprarHabitat(habitat, 3000, numeroHabitatSeleccionado)){
                    imagen = (new ImageIcon("recursos/habitats/habitatBosque.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
                    panelHabitatSeleccionado.setHabitat(habitat);
                    panelHabitatSeleccionado.setImagenHabitat(imagen);
                    Point pos =botonesDeCompraHabitat.get(0).getLocation();
                    pos.x += this.getX();  pos.y += this.getY();
                    PanelPrincipal.getInstance().mostrarIconoInformacion(new IconoInformacion(-3000,IconoInformacion.DINERO,pos));
                }else{
                    Point pos =botonesDeCompraHabitat.get(0).getLocation();
                    pos.x += this.getX();  pos.y += this.getY();
                    IconoInformacion dineroInsuficiente = new IconoInformacion("dinero insuficiente!",pos);
                    PanelPrincipal.getInstance().mostrarIconoInformacion(dineroInsuficiente);
                }
                break;

            // Habitat sabana:
            case 2:
                habitat = new Habitat(30, -30);
                if(ZooManager.getInstance().comprarHabitat(habitat, 3000, numeroHabitatSeleccionado)){
                    imagen = (new ImageIcon("recursos/habitats/habitatSabana.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
                    panelHabitatSeleccionado.setHabitat(habitat);
                    panelHabitatSeleccionado.setImagenHabitat(imagen);
                    Point pos =botonesDeCompraHabitat.get(1).getLocation();
                    pos.x += this.getX();  pos.y += this.getY();
                    PanelPrincipal.getInstance().mostrarIconoInformacion(new IconoInformacion(-3000,IconoInformacion.DINERO,pos));
                }else{
                    Point pos =botonesDeCompraHabitat.get(1).getLocation();
                    pos.x += this.getX();  pos.y += this.getY();
                    IconoInformacion dineroInsuficiente = new IconoInformacion("dinero insuficiente!",pos);
                    PanelPrincipal.getInstance().mostrarIconoInformacion(new IconoInformacion(-3000,IconoInformacion.DINERO,pos));
                    PanelPrincipal.getInstance().mostrarIconoInformacion(dineroInsuficiente);
                }
                break;

            // Habitat desierto:
            case 3:
                habitat = new Habitat(40, -40);
                if(ZooManager.getInstance().comprarHabitat(habitat, 3000, numeroHabitatSeleccionado)){
                    imagen = (new ImageIcon("recursos/habitats/habitatDesierto.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
                    panelHabitatSeleccionado.setHabitat(habitat);
                    panelHabitatSeleccionado.setImagenHabitat(imagen);
                    Point pos =botonesDeCompraHabitat.get(2).getLocation();
                    pos.x += this.getX();  pos.y += this.getY();
                    PanelPrincipal.getInstance().mostrarIconoInformacion(new IconoInformacion(-3000,IconoInformacion.DINERO,pos));
                }else{
                    Point pos =botonesDeCompraHabitat.get(2).getLocation();
                    pos.x += this.getX();  pos.y += this.getY();
                    IconoInformacion dineroInsuficiente = new IconoInformacion("dinero insuficiente!",pos);
                    PanelPrincipal.getInstance().mostrarIconoInformacion(dineroInsuficiente);
                }
                break;

            // Habitat acuatica:
            case 4:
                habitat = new Habitat(25, 100);
                if(ZooManager.getInstance().comprarHabitat(habitat, 3000, numeroHabitatSeleccionado)){
                    imagen = (new ImageIcon("recursos/habitats/habitatAcuatica.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
                    panelHabitatSeleccionado.setHabitat(habitat);
                    panelHabitatSeleccionado.setImagenHabitat(imagen);
                    Point pos =botonesDeCompraHabitat.get(3).getLocation();
                    pos.x += this.getX();  pos.y += this.getY();
                    PanelPrincipal.getInstance().mostrarIconoInformacion(new IconoInformacion(-3000,IconoInformacion.DINERO,pos));
                }else{
                    Point pos =botonesDeCompraHabitat.get(3).getLocation();
                    pos.x += this.getX();  pos.y += this.getY();
                    IconoInformacion dineroInsuficiente = new IconoInformacion("dinero insuficiente!",pos);
                    PanelPrincipal.getInstance().mostrarIconoInformacion(dineroInsuficiente);
                }
                break;

            // Habitat polar:
            case 5:
                habitat = new Habitat(-40, 100);
                if(ZooManager.getInstance().comprarHabitat(habitat, 3000, numeroHabitatSeleccionado)){
                    imagen = (new ImageIcon("recursos/habitats/habitatPolar.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
                    panelHabitatSeleccionado.setHabitat(habitat);
                    panelHabitatSeleccionado.setImagenHabitat(imagen);
                    Point pos =botonesDeCompraHabitat.get(4).getLocation();
                    pos.x += this.getX();  pos.y += this.getY();
                    PanelPrincipal.getInstance().mostrarIconoInformacion(new IconoInformacion(-3000,IconoInformacion.DINERO,pos));
                }else{
                    Point pos =botonesDeCompraHabitat.get(4).getLocation();
                    pos.x += this.getX();  pos.y += this.getY();
                    IconoInformacion dineroInsuficiente = new IconoInformacion("dinero insuficiente!",pos);
                    PanelPrincipal.getInstance().mostrarIconoInformacion(dineroInsuficiente);
                }
                break;
        }
        cerrarMenu();
    }
    public void comprarComida(int tipoComida) {
        Habitat habitat = panelHabitatSeleccionado.getHabitat();
        switch (tipoComida) {
            // Comida carne:
            case 1:
                habitat.addComida(20, TipoAlimento.CARNE);
                ZooManager.getInstance().removeMoney(200);
                break;

            // Comida follaje:
            case 2:
                habitat.addComida(50, TipoAlimento.FOLLAJE);
                ZooManager.getInstance().removeMoney(200);
                break;
            // Comida pescado:
            case 3:
                habitat.addComida(30, TipoAlimento.PESCADO);
                ZooManager.getInstance().removeMoney(200);
                break;
            // Comida fruta:
            case 4:
                habitat.addComida(40, TipoAlimento.FRUTA);
                ZooManager.getInstance().removeMoney(200);
                break;
        }
    }
    public void comprarAnimal(int tipoAnimal) {
        switch (tipoAnimal) {
            // Animal oso polar:
            case 1:
                comprarAnimal(OsoPolar.class);
                break;
            // Animal zorro artico:
            case 2:
                comprarAnimal(ZorroArtico.class);
                break;
            // Animal camello:
            case 3:
                comprarAnimal(Camello.class);
                break;
            // Animal canguro:
            case 4:
                comprarAnimal(Canguro.class);
                break;
            // Animal ajolote:
            case 5:
                comprarAnimal(Ajolote.class);
                break;
            // Animal flamenco:
            case 6:
                comprarAnimal(Flamenco.class);
                break;
            // Animal cebra:
            case 7:
                comprarAnimal(Cebra.class);
                break;
            // Animal leon:
            case 8:
                comprarAnimal(Leon.class);
                break;
            // Animal oso panda:
            case 9:
                comprarAnimal(Panda.class);
                break;
            // Animal zorro:
            case 10:
                comprarAnimal(Zorro.class);
                break;
            //Animal jirafa:
            case 11:
                comprarAnimal(Jirafa.class);
                break;
            // Animal informatico:
            case 12:
                comprarAnimal(Informatico.class);
                break;
        }
        //TODO resto de animales
    }
    public <T> void comprarAnimal(Class<T> claseAnimal) {
        Habitat habitat = panelHabitatSeleccionado.getHabitat();
        Animal animal;
        AnimalVisual animalVisual;
        try {
            animal = (Animal)claseAnimal.getDeclaredConstructor(Habitat.class).newInstance(habitat);
            animalVisual = new AnimalVisual(panelHabitatSeleccionado, animal);
            animalVisual.setImagen((new ImageIcon("recursos/animales/" + animal.getEspecie().replaceAll("\\s", "") + ".png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH));
            habitat.addAnimal(animal);
            panelHabitatSeleccionado.addAnimal(animalVisual);
            ZooManager.getInstance().removeMoney(animal.getPrecio());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void cerrarMenu(){
        this.setVisible(false);
        if(panelHabitatSeleccionado != null)
            panelHabitatSeleccionado.esteHabitatEstaSeleccionado = false;
        this.removeAll();
    }
    public PanelHabitat getPanelHabitatSeleccionado(){return panelHabitatSeleccionado;}
}
