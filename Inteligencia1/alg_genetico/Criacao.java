import java.util.ArrayList;
import java.util.Random;

public class Criacao {

    private static Individuo[] grupo = new Individuo[16];
    private static ArrayList<Individuo> grupoGrande = new ArrayList<>();

    public Criacao(){
        grupo = new Individuo[16];
        grupoGrande = new ArrayList<>();
    }



    //criar 16 individuos
    public static void criarIndividuo(){
        Individuo ind;
        Random ran = new Random();
        int n;
        Gene g;

        for(int i = 0; i < 16; i++){
            ind = new Individuo();

            for(int k = 0; k < 64; k++){
                n = ran.nextInt(2);
                g = new Gene(n);

                ind.getCromossoma()[k] = g;
            }
            
            grupo[i] = ind;

        }

        
    }

    //Mutacao do gene aleatorio
    public static void mutacaoGene(){

    }

    //juntar dois individuos
    public static void juntaIndividuo(){

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
        //criarIndividuo();

        //printIndividuo();

        
        
    }

}
