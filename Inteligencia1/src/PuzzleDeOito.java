import java.util.ArrayList;

public class PuzzleDeOito implements IEstado {

    // private int hash = Integer.MAX_VALUE;
    private final int[][] goalMatriz = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 0 } };

    private int[][] matriz = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 0, 8 } };

    private String[] position = { "Positions:", "0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1" };

    public PuzzleDeOito(int[][] novo) {
        matriz = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matriz[i][j] = novo[i][j];
            }
        }
    }

    public PuzzleDeOito() {

    }

    /*
     * fun��o heur�stica
     * retorna o valor de h associado ao estado
     */
    @Override
    public double h() {
        int first = 0;
        int second = 0;
        double soma = 0;

        for (int k = 1; k < 9; k++) {
            String[] s = position[k].split(",");

            first = Integer.parseInt(s[0]);
            second = Integer.parseInt(s[1]);

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (matriz[i][j] == k) {
                        soma += Math.abs(i - first) + Math.abs(j - second);
                        break;
                    }
                }
            }
        }

        return soma;
    }

    /*
     * retorna true se o estado for final (um objetivo)
     */
    @Override
    public boolean goal() {
        int a = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (goalMatriz[i][j] == matriz[i][j]) {
                    a++;
                }
            }
        }
        if (a == 9) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * retorna uma cole��o com os estados sucessores, e o custo de transi��o de cada
     * um
     */
    @Override
    public ArrayList<Acao> suc() {
        ArrayList<Acao> s = new ArrayList<Acao>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (matriz[i][j] == 0) {

                }

                if (i == 0 && matriz[i][j] > 0 && matriz[i + 1][j] == 0) { // baixo para cima
                    int[][] novo = new int[3][3];
                    for (int k = 0; k < 3; k++) {
                        for (int h = 0; h < 3; h++) {
                            novo[k][h] = matriz[k][h];
                        }

                    }
                    novo[i + 1][j] = novo[i][j];
                    novo[i][j] = 0;
                    PuzzleDeOito novoEstado = new PuzzleDeOito(novo);
                    s.add(new Acao(novoEstado, 1, "baixo"));
                }

                if (i == 1 && matriz[i][j] > 0 && matriz[i - 1][j] == 0) {
                    int[][] novo = new int[3][3];
                    for (int k = 0; k < 3; k++) {
                        for (int h = 0; h < 3; h++) {
                            novo[k][h] = matriz[k][h];
                        }

                    }
                    novo[i - 1][j] = novo[i][j];
                    novo[i][j] = 0;
                    PuzzleDeOito novoEstado = new PuzzleDeOito(novo);
                    s.add(new Acao(novoEstado, 1, "cima"));
                }

                if (j > 0 && matriz[i][j - 1] > 0 && matriz[i][j] == 0) { // esquerda para a direita
                    int[][] novo = new int[3][3];
                    for (int k = 0; k < 3; k++) {
                        for (int h = 0; h < 3; h++) {
                            novo[k][h] = matriz[k][h];
                        }

                    }
                    novo[i][j] = novo[i][j - 1];
                    novo[i][j - 1] = 0;
                    PuzzleDeOito novoEstado = new PuzzleDeOito(novo);
                    s.add(new Acao(novoEstado, 1, "direita"));
                }

                if (j < 2 && matriz[i][j] == 0 && matriz[i][j + 1] > 0) { // direita para a esquerda
                    int[][] novo = new int[3][3];
                    for (int k = 0; k < 3; k++) {
                        for (int h = 0; h < 3; h++) {
                            novo[k][h] = matriz[k][h];
                        }

                    }
                    novo[i][j] = novo[i][j + 1];
                    novo[i][j + 1] = 0;
                    PuzzleDeOito novoEstado = new PuzzleDeOito(novo);
                    s.add(new Acao(novoEstado, 1, "esquerda"));
                }
            }
        }

        return s;
    }

    /*
     * retorna true se este estado for igual ao objeto p
     */
    @Override
    public boolean equals(Object p) {
        if (this == p) {
            return true;
        }
        if (!(p instanceof PuzzleDeOito)) {
            return false;
        }

        PuzzleDeOito np = (PuzzleDeOito) p;
        int a = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                if (np.matriz[i][j] == this.matriz[i][j]) {
                    a++;
                }
            }
        }
        if (a == 12) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * retorna um inteiro com o valor do hash code deste estado
     */
    @Override
    public int hashCode() {
        int soma = 0;
        int n = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 6; j++) {
                soma += this.matriz[i][j] * Math.pow(5, n);
                n++;
            }
        }

        return soma;
    }

    public String toString() {
        return "'''''''''''\n'''''''''''\n" + matriz[0][0] + "|" + matriz[0][1] + "|" + matriz[0][2] + "\n" +
                "------------\n" +
                matriz[1][0] + "|" + matriz[1][1] + "|" + matriz[1][2] + "\n" +
                "------------\n" +
                matriz[2][0] + "|" + matriz[2][1] + "|" + matriz[2][2];

    }

    public static void main(String[] args) {
        PuzzleDeOito n = new PuzzleDeOito();

        System.out.println(n.h());

        ArrayList<Acao> s = n.suc();

        System.out.println(n);
        for (Acao a : s) {
            System.out.println(a.getEstado());
            System.out.println(a.getEstado().goal());
        }
        /*
         * PuzzleDeOito n2 = new PuzzleDeOito();
         * 
         * System.out.println(n);
         * ArrayList<Acao> sim = n.suc();
         * ArrayList<Acao> ama = new ArrayList<>();
         * ArrayList<Acao> ama2 = new ArrayList<>();
         * for (Acao a : sim) {
         * ama.addAll(a.getEstado().suc());
         * }
         * for (Acao a : ama) {
         * ama2.addAll(a.getEstado().suc());
         * }
         * 
         * for (Acao a : ama2) {
         * if (a.getEstado().goal())
         * System.out.println(a.getEstado());
         * }
         * 
         * System.out.println(n);
         * System.out.println(n2);
         * System.out.println("\n" + n.hashCode());
         * System.out.println(n2.equals(n));
         */
        // usar hashcode de PuzzelDeSeis

    }

}