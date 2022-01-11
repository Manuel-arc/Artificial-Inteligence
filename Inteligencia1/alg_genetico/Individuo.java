import java.util.Random;

public class Individuo {

    private Gene[] cromossoma;

    public Individuo(){
        cromossoma = new Gene[64];
        criarCromossoma();
    }

    public Gene[] getCromossoma(){
        return cromossoma;
    }

    public void setCromossoma(Gene[] n){
        cromossoma = n;
    }

    private void criarCromossoma(){
        Random rand = new Random();
        for(int i = 0; i < 64; i++){
            cromossoma[i] = new Gene(rand.nextInt(2));
        }
    }

    public void individuoAptidao(){ //ver o numero de sequencias de 3 um
        
    }
}
