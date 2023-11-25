package Lógico;
import jdk.jshell.spi.SPIResolutionException;

import java.awt.event.WindowStateListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class GeneradorDeNombres {
    private static GeneradorDeNombres instance;
    private Random rand;
    private ArrayList<String> nombres;
    public GeneradorDeNombres(){
        nombres = new ArrayList<String>();
        rand = new Random(123);

        String archivoDeNombres = "recursos/nombres.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoDeNombres))) {
            String line;

            // Read and print each line from the file
            while ((line = reader.readLine()) != null) {
                nombres.add(line);
            }

        } catch (IOException e) {
            // Handle exceptions
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
    public ArrayList<String> getNombres(){return nombres;}
    public static GeneradorDeNombres getInstance(){
        if(instance == null){
            instance = new GeneradorDeNombres();
        }
        return  instance;
    }
}
