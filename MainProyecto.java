import Visual.Ventana;

public class MainProyecto {
    public static void main(String[] args){
        /*System.out.println("5 visitantes llegan");
        ArrayList<Visitante> visitantes = new ArrayList<Visitante>();
        for(int i = 0; i<4;i++){
            visitantes.add(new Visitante());
        }
        visitantes.add(new VisitanteVIP());
        System.out.println("veamos que dicen: \n");
        for(Visitante v : visitantes){
            System.out.println(v.getNombre()+" dice: "+v.comentarioRandom());
        }*/
        Ventana.getInstance();
    }
}
