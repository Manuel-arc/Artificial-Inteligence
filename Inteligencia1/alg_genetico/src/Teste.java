import java.util.Random;

public class Teste {
    public static void main(String[] args) {

        final int CICLOS = 10000000;
        Criacao p = new Criacao();
        int x = 0;
        int num_mutacoes = 0;
        int choice = 0;

        Random rand = new Random();

        while (x <= CICLOS) {
            /*
             * p.printIndividuo();
             * System.out.println("------------------------------------------");
             */
            p.juntaIndividuo();

            choice = rand.nextInt(1000);

            if (choice == 5) {
                num_mutacoes++;
                p.mutacaoGene();
            }

            if (p.getGrupo().size() > 16) {
                p.selectIndividuos();
            }

            x++;

        }

        p.printIndividuo();

        System.out.println("Nº de mutações: " + num_mutacoes);

    }
}
