import java.util.Random;

public class Individuo {

    private Gene[] cromossoma;
    private int aptidao;

    public Individuo() {
        cromossoma = new Gene[64];
    }

    public Gene[] getCromossoma() {
        return cromossoma;
    }

    public void setCromossoma(Gene[] n) {
        cromossoma = n;
    }

    public void criarCromossoma() {
        Random rand = new Random();
        for (int i = 0; i < 64; i++) {
            cromossoma[i] = new Gene(rand.nextInt(2));
        }
    }

    public int getAptidao() {
        return aptidao;
    }

    public void individuoAptidao() { // ver o numero de sequencias de 3 um
        int contagem = 0;
        int seq = 0;

        for (int i = 0; i < cromossoma.length; i++) {
            if (cromossoma[i].getGen() == 1 && contagem == 3) {
                contagem = 0;
            } else if (cromossoma[i].getGen() == 1) {
                contagem++;
            }
            if (cromossoma[i].getGen() == 0 && contagem == 3) {
                contagem = 0;
                seq++;
            }
            if (cromossoma[i].getGen() == 0 && contagem < 3) {
                contagem = 0;
            }

        }

        if (contagem == 3) {
            seq++;
        }

        aptidao = seq;
    }
}
