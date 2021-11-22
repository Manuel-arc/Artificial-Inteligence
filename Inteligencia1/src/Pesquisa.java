import java.util.ArrayList;

public class Pesquisa {

    public static void pesquisaLargura(){
        boolean resolve = false;

        ArrayList<Node> nosFronteira = new ArrayList<Node>();

        Node n = new Node(new PuzzleDeSeis(), null, null);

        nosFronteira = n.getNosSucessores();

        Node goal = new Node();
        int i = 0;

        while(!resolve){
            System.out.println(nosFronteira.get(i).getEstado());
            if(nosFronteira.get(i).getEstado().goal()){ 
                resolve = true;
                goal = nosFronteira.get(i);
            }

            nosFronteira.addAll(nosFronteira.get(i).getNosSucessores());
            System.out.println("Profundidade: "+ nosFronteira.get(i).getProfundidade());
            i++;
        }

        System.out.println("\nNó final:\n"+ goal.getEstado());
        System.out.println("Profundidade Final: "+ goal.getProfundidade());
    }

    public static void pesquisaProfundidade(){

    }

    public static void main(String[] args) {
        pesquisaLargura();
    }
}
