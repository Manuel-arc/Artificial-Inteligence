import java.util.ArrayList;

public class Pesquisa {

    public static void pesquisaLargura(){
        boolean resolve = false;

        ArrayList<Node> nosFronteira = new ArrayList<Node>();
        ArrayList<Node> estadoFechado = new ArrayList<Node>(); 

        Node n = new Node(new PuzzleDeSeis(), null, null);

        nosFronteira.add(n);


        Node goal = new Node();

        while(!resolve){
            System.out.println(nosFronteira.get(0).getEstado());

            if(nosFronteira.get(0).getEstado().goal()){ 
                resolve = true;
                goal = nosFronteira.get(0);
            } else{
                estadoFechado.add(nosFronteira.get(0));
            }

            ArrayList<Node> nfo = nosFronteira.get(0).getNosSucessores(); 
            int i = 0;
            while(i != nfo.size()){
                boolean sim = false;
                for(Node nfe : estadoFechado){
                    if(nfo.get(i).getEstado().equals(nfe.getEstado())){
                        sim = true;
                    }
                }
                
                if(sim){
                    nfo.remove(i);
                    i--;
                }
                i++;
            }
            nosFronteira.addAll(nfo);

            System.out.println("Profundidade: "+ nosFronteira.get(0).getProfundidade());
            nosFronteira.remove(0);
        }

        System.out.println("\nNó final:\n"+ goal.getEstado());
        System.out.println("Profundidade Final: "+ goal.getProfundidade());
        System.out.println("Custo Final: "+ goal.g());
    }

    public static void pesquisaProfundidade(){

    }

    public static void main(String[] args) {
        pesquisaLargura();
    }
}
