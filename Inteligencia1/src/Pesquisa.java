import java.util.ArrayList;

public class Pesquisa {

    public static void pesquisaLargura(){
        boolean resolve = false;

        ArrayList<Node> nosFronteira = new ArrayList<Node>();
        //ArrayList<Node> estadoFechado = new ArrayList<Node>(); //Tirar comentario para usar estados fechados

        Node n = new Node(new PuzzleDeSeis(), null, null);

        nosFronteira.addAll(n.getNosSucessores());

        Node goal = new Node();

        while(!resolve){
            //Para usar estado fechados
            /*for(Node q : estadoFechado){
                if(q.equals(nosFronteira.get(i).getEstado())){
                    i++;
                    continue;
                }
            }*/

            System.out.println(nosFronteira.get(0).getEstado());
            if(nosFronteira.get(0).getEstado().goal()){ 
                resolve = true;
                goal = nosFronteira.get(0);
            } /*else{ // tirar comentario para usar estados fechados
                estadoFechado.add(nosFronteira.get(i));
            }*/

            nosFronteira.addAll(nosFronteira.get(0).getNosSucessores());
            System.out.println("Profundidade: "+ nosFronteira.get(0).getProfundidade());
            nosFronteira.remove(0);
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
