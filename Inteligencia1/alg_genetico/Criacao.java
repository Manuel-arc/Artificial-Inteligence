import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class Criacao {

    private ArrayList<Individuo> grupo = new ArrayList<>();

    public Criacao() {
        grupo = new ArrayList<>();
        criarIndividuo();
    }

    private void criarIndividuo() {
        Individuo ind;

        for (int i = 0; i < 2; i++) {
            ind = new Individuo();
            ind.criarCromossoma();
            ind.individuoAptidao();
            grupo.add(ind);
        }

    }

    public ArrayList<Individuo> getGrupo() {
        return grupo;
    }

    // juntar dois individuos
    public void juntaIndividuo() {
        Individuo[] ind = new Individuo[2];
        Random rand = new Random();

        int n = grupo.size();

        ind[0] = grupo.get(rand.nextInt(n));
        ind[1] = grupo.get(rand.nextInt(n));

        while (ind[0] == ind[1]) {
            ind[1] = grupo.get(rand.nextInt(n));
        }

        int num = rand.nextInt(63);
        Individuo novo;
        Gene[] arr;

        for (int i = 0; i < 2; i++) {
            novo = new Individuo();
            arr = new Gene[64];
            if (i == 0) {
                for (int j = 0; j < num; j++) {
                    arr[j] = ind[0].getCromossoma()[j];
                }
                for (int k = num; k < 64; k++) {
                    arr[k] = ind[1].getCromossoma()[k];
                }
            }
            if (i == 1) {
                for (int j = 0; j < num; j++) {
                    arr[j] = ind[1].getCromossoma()[j];
                }
                for (int k = num; k < 64; k++) {
                    arr[k] = ind[0].getCromossoma()[k];
                }
            }
            novo.setCromossoma(arr);
            novo.individuoAptidao();
            grupo.add(novo);
        }
    }

    // Mutacao do gene aleatorio
    public void mutacaoGene() {
        Random rand = new Random();

        int n = grupo.size() - 1;

        Individuo mutante = grupo.get(n);

        int g = rand.nextInt(64);

        if (mutante.getCromossoma()[g].getGen() == 0) {
            mutante.getCromossoma()[g].setGen(1);
        } else {
            mutante.getCromossoma()[g].setGen(0);
        }

    }

    // selecionar 16 individuos
    public void selectIndividuos() {
        Collections.sort(grupo, new ComparaAptidao());

        grupo.remove(16);
        grupo.remove(16);
    }

    public void printIndividuo() {
        int i = 0;
        for (Individuo a : grupo) {
            i += 1;
            System.out.println(i + "º: " + a + "  " + a.getAptidao());
            System.out.println();
        }
    }

}
