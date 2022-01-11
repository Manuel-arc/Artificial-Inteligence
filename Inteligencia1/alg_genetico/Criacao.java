import java.util.ArrayList;
import java.util.Random;

public class Criacao {

    private static ArrayList<Individuo> grupo = new ArrayList<>();

    public Criacao(){
        grupo = new ArrayList<>();
    }


    public static void criarIndividuo(){
        Individuo ind;

        for(int i = 0; i < 2; i++){
            ind = new Individuo();            
            grupo.add(ind);
        }

    }

    //juntar dois individuos
    public static void juntaIndividuo(){
        Individuo[] ind = new Individuo[2];
        Random rand = new Random();

        int n = grupo.size();

        ind[0] = grupo.get(rand.nextInt(n));
        ind[1] = grupo.get(rand.nextInt(n));

        while(ind[0] == ind[1]){
            ind[1] = grupo.get(rand.nextInt(n));
        }

        Individuo novo = new Individuo();
        Gene[] arr = new Gene[64];

        int num = rand.nextInt(2);

        switch(num){
            case 0:
                for(int i = 0; i < 32; i++){
                    arr[i] = ind[0].getCromossoma()[i];
                }
                for(int i = 32; i < 64; i++){
                    arr[i] = ind[1].getCromossoma()[i];
                }

                novo.setCromossoma(arr);
            break;

            case 1:
                for(int i = 0; i < 32; i++){
                    arr[i] = ind[1].getCromossoma()[i];
                }
                for(int i = 32; i < 64; i++){
                    arr[i] = ind[0].getCromossoma()[i];
                }

                novo.setCromossoma(arr);
            break;
            
            default:{
                System.out.println("ERRO!");
            }
        }

        grupo.add(novo);

    }
    

    //Mutacao do gene aleatorio
    public static void mutacaoGene(){
        Random rand = new Random();

        int n = grupo.size();

        
    }


    //selecionar 16 individuos
    public static void selectIndividuos(){
        
    }

    public static void printIndividuo(){
        int i = 0;
        for (Individuo a : grupo) {
            i += 1;
            System.out.println(i +"º:");
            for(int j = 0; j < 64; j++){
                System.out.print(a.getCromossoma()[j].getGen()+" ");
            }
            System.out.println();
            System.out.println();
        }
    }


    
    public static void main(String[] args) {
        criarIndividuo();

        for(int i = 0; i < 14; i++){
            juntaIndividuo();
        }

        printIndividuo();
    }

}
