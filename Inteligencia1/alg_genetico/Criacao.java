import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Criacao {

    private static ArrayList<Individuo> grupo = new ArrayList<>();

    public Criacao(){
        grupo = new ArrayList<>();
    }


    public static void criarIndividuo(){
        Individuo ind;

        for(int i = 0; i < 2; i++){
            ind = new Individuo(); 
            ind.criarCromossoma();
            ind.individuoAptidao();           
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


        int num = rand.nextInt(63);
        Individuo novo;
        Gene[] arr;

        for(int i = 0; i < 2; i++){
            novo = new Individuo();
            arr = new Gene[64];
            if(i == 0){
                for(int j = 0; j < num; j++){
                    arr[j] = ind[0].getCromossoma()[j];
                }
                for(int k = num; k < 64; k++){
                    arr[k] = ind[1].getCromossoma()[k];
                }
            }
            if(i == 1){
                for(int j = 0; j < num; j++){
                    arr[j] = ind[1].getCromossoma()[j];
                }
                for(int k = num; k < 64; k++){
                    arr[k] = ind[0].getCromossoma()[k];
                }
            }
            novo.setCromossoma(arr);
            novo.individuoAptidao();
            grupo.add(novo);
        }
    }
    

    //Mutacao do gene aleatorio
    public static void mutacaoGene(){
        Random rand = new Random();

        int n = grupo.size();




    }


    //selecionar 16 individuos
    public static void selectIndividuos(){
        Collections.sort(grupo, new ComparaAptidao());

        grupo.remove(16);
        grupo.remove(17);
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

        printIndividuo();

        System.out.println(grupo.get(0).getAptidao());
        System.out.println(grupo.get(1).getAptidao());

        Collections.sort(grupo, new ComparaAptidao());

        printIndividuo();
    }

}
