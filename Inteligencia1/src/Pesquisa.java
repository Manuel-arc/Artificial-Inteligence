import java.util.ArrayList;

public class Pesquisa {

    public static void pesquisaLargura(){
        boolean resolve = false;

        ArrayList<Node> no = new ArrayList<Node>();

        Node n = new Node(new PuzzleDeSeis(), null, null);

        no = n.getNosSucessores();

        Node goal = new Node();

        while(!resolve){
            if(no.get(0).getEstado().goal()){ 
                resolve = true;
                goal = no.get(0);
                break;
            }
        }

        System.out.println("Nó final: "+ goal.getEstado());
    }

    public static void main(String[] args) {
        pesquisaLargura();
        System.out.println("Hello World!");
    }
}
