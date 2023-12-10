package Visual;

import Logico.Animal;
import Logico.Habitat;
import Logico.TipoAlimento;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class PanelHabitat extends JPanel {
    public Image imagenHabitat;
    private Habitat habitat;
    private ArrayList<AnimalVisual> animalesVis;
    private Random rand = new Random();
    public boolean esteHabitatEstaSeleccionado;
    public PanelHabitat(Habitat habitat) {
        if(habitat == null){
            imagenHabitat = (new ImageIcon("recursos/habitats/noHabitat.png")).getImage().getScaledInstance(300,160,Image.SCALE_SMOOTH);
        }
        esteHabitatEstaSeleccionado = false;
        this.habitat = habitat;
        setBackground(new Color(0,0,0,0));
        animalesVis = new ArrayList<AnimalVisual>();

    }
    public void tick(){
        if(habitat != null) if(rand.nextInt(1000)<15){
            String resultado = habitat.dueloAnimal();
            if(resultado != null){
                IconoInformacion inf =new IconoInformacion(resultado,getLocation());
                PanelPrincipal.getInstance().mostrarIconoInformacion(inf);
            }
        }

        Iterator<AnimalVisual> iterator = animalesVis.iterator();
        while(iterator.hasNext()){
            AnimalVisual a = iterator.next();
            a.tick();
            if(habitat.getTemperatura()>a.animal.getMaxTemp() && rand.nextInt(200)==69){
                a.animal.morir();
                IconoInformacion mensajeDeMuerte =new IconoInformacion(a.animal.getNombre()+" el "+a.animal.getEspecie()+" se a muerto de calor",getLocation());
                PanelPrincipal.getInstance().mostrarIconoInformacion(mensajeDeMuerte);
            }
            if(habitat.getTemperatura()<a.animal.getMinTemp() && rand.nextInt(200)==69){
                a.animal.morir();
                IconoInformacion mensajeDeMuerte = new IconoInformacion(a.animal.getNombre()+" el "+a.animal.getEspecie()+" se murio de frio",getLocation());
                PanelPrincipal.getInstance().mostrarIconoInformacion(mensajeDeMuerte);
            }
            if(habitat.getHumedad()>a.animal.getMaxHum() && rand.nextInt(200)==69){
                a.animal.morir();
                IconoInformacion mensajeDeMuerte = new IconoInformacion(a.animal.getNombre()+" el "+a.animal.getEspecie()+" se murio por estar muy humedo",getLocation());
                PanelPrincipal.getInstance().mostrarIconoInformacion(mensajeDeMuerte);
            }
            if(habitat.getHumedad()<a.animal.getMinHum() && rand.nextInt(200)==69){
                a.animal.morir();
                IconoInformacion mensajeDeMuerte = new IconoInformacion(a.animal.getNombre()+" el "+a.animal.getEspecie()+" se murio de seco",getLocation());
                PanelPrincipal.getInstance().mostrarIconoInformacion(mensajeDeMuerte);
            }
            if(!a.estaVivo()){
                iterator.remove();
                IconoInformacion masCarne = new IconoInformacion(a.animal.getGranditud(), TipoAlimento.CARNE,new Point(a.getPosX()+getX(),a.getPosY()+getY()));
                PanelPrincipal.getInstance().mostrarIconoInformacion(masCarne);
            }
        }
    }
    public void addAnimal(AnimalVisual ani){
        animalesVis.add(ani);
    }

    public Habitat getHabitat() {return habitat;}
    public ArrayList<AnimalVisual> getAnimalesVisual() {return animalesVis;}
    public void setHabitat(Habitat habitat) {this.habitat = habitat;}
    public void setImagenHabitat(Image imagen){this.imagenHabitat = imagen;}
    @Override
    public void paintComponent(Graphics g) {
        //super.paintComponent(g);
        /*
        g.drawImage(imagenHabitat, 0, 0, this);
        for(AnimalVisual a : animalesVis){
            g.drawImage(a.getImagen(),a.getPosX(),a.getPosY(),this);
        }
         */
        if(esteHabitatEstaSeleccionado){
            g.setColor(Color.green);
            g.drawOval(10 ,10, 10, 10);
        }
    }
}
