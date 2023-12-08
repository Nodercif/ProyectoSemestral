package Logico;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Random;

public class InformacionVisitantes {
    private static InformacionVisitantes instance;
    private Random rand;
    private ArrayList<String> nombres;
    private ArrayList<String> comentariosRandom;
    private ArrayList<String> nombresVIP;
    private Map<String,ArrayList<String>> compentariosVIP;
    public InformacionVisitantes(){
        nombres = new ArrayList<String>();
        comentariosRandom = new ArrayList<String>();
        nombresVIP = new ArrayList<String>();
        compentariosVIP = new HashMap<String,ArrayList<String>>();
        rand = new Random(123);

        String archivoDeComentarios = "recursos/comentarios.txt";
        String archivoDeNombresRandom = "recursos/nombres.txt";
        String archivoDeInformacionVIP = "recursos/visitantesVIP.txt";

        //Leer nombres normales:
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoDeNombresRandom))) {
            String line;
            while ((line = reader.readLine()) != null) {
                nombres.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Leer comentarios random:
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoDeComentarios))) {
            String line;
            while ((line = reader.readLine()) != null) {
                comentariosRandom.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Leer informacion de visitantes vip:
        try (BufferedReader reader = new BufferedReader(new FileReader(archivoDeInformacionVIP))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] items = line.split(";");
                nombresVIP.add(items[0]); //el primer string es el nombre
                ArrayList<String> comentarios = new ArrayList<String>();
                //el resto son los comentarios que hace el visitante
                for(int i=1; i< items.length; i++){
                    comentarios.add(items[i]);
                }
                compentariosVIP.put(items[0],comentarios);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void printNombres(){
        for(String s : nombres){
            System.out.println(s);
        }
    }

    public String nombreRandom(){
        int n = rand.nextInt(nombres.size());
        return nombres.get(n);
    }
    public String nombreRandomVIP(){
        return nombresVIP.get(rand.nextInt(nombresVIP.size()));
    }
    public String ComentarioRandom() { return comentariosRandom.get(rand.nextInt(comentariosRandom.size())); }
    public ArrayList<String> getComentariosVIP(String nombre){
        return compentariosVIP.get(nombre);
    }
    public ArrayList<String> getNombres(){return nombres;}
    public static InformacionVisitantes getInstance(){
        if(instance == null){
            instance = new InformacionVisitantes();
        }
        return  instance;
    }
}
