import java.util.ArrayList;

public class PuzzleDeSeis implements IEstado{

	//private int hash = Integer.MAX_VALUE;
	private final int[][] goalMatriz = {{0,0,0,0,0,0},{1,2,3,4,5,6}};
	
	private int[][] matriz = {{1,0,0,0,0,5},{0,2,3,4,0,6}};

	public PuzzleDeSeis(int[][] novo) {
		matriz = new int[2][6];
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				matriz[i][j] = novo[i][j];
			}
		}
	}
	
	public PuzzleDeSeis() {
	//amanha	
	}

	/*
	 * fun��o heur�stica
	 * retorna o valor de h associado ao estado
	 */
	@Override
	public double h() {
		return 0;
	}

	/*
     * retorna true se o estado for final (um objetivo)
     */
	@Override
	public boolean goal() {
		int a = 0;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				if(goalMatriz[i][j] == matriz[i][j]) {
					a++;
				}
			}
		}
		
		return a == 12;
	}

	/*
     * retorna uma cole��o com os estados sucessores, e o custo de transi��o de cada um
     */
	@Override
	public ArrayList<Acao> suc() {
		ArrayList<Acao> s = new ArrayList<>();
		for(int i = 0; i < 2; i++) {
			for (int j = 0; j < 6; j++) {
				if(i == 0 && matriz[i][j] > 0 && matriz[i+1][j] == 0) {   //baixo para cima
					int[][] novo = new int[2][6];
					for(int k = 0; k < 2; k++) {
						for(int h = 0; h < 6; h++) {
							novo[k][h] = matriz[k][h];
						}
						
					}
					novo[i+1][j] = novo[i][j];
					novo[i][j] = 0;
					PuzzleDeSeis novoEstado = new PuzzleDeSeis(novo);
					s.add(new Acao(novoEstado, 1));
				}
				
				if(i == 1 && matriz[i][j] > 0 && matriz[i-1][j] == 0) {
					int[][] novo = new int[2][6];
					for(int k = 0; k < 2; k++) {
						for(int h = 0; h < 6; h++) {
							novo[k][h] = matriz[k][h];
						}
						
					}
					novo[i-1][j] = novo[i][j];
					novo[i][j] = 0;
					PuzzleDeSeis novoEstado = new PuzzleDeSeis(novo);					
					s.add(new Acao(novoEstado, 1));
				}
				
				if(j > 0 && matriz[i][j-1] > 0 && matriz[i][j] == 0) {     //esquerda para a direita
					int[][] novo = new int[2][6];
					for(int k = 0; k < 2; k++) {
						for(int h = 0; h < 6; h++) {
							novo[k][h] = matriz[k][h];
						}
						
					}
					novo[i][j] = novo[i][j-1];
					novo[i][j-1] = 0;
					PuzzleDeSeis novoEstado = new PuzzleDeSeis(novo);
					s.add(new Acao(novoEstado, 1));
				}

				
				if(j < 5 && matriz[i][j] == 0 && matriz[i][j+1] > 0) {    //direita para a esquerda
					int[][] novo = new int[2][6];
					for(int k = 0; k < 2; k++) {
						for(int h = 0; h < 6; h++) {
							novo[k][h] = matriz[k][h];
						}
						
					}
					novo[i][j] = novo[i][j+1];
					novo[i][j+1] = 0;
					PuzzleDeSeis novoEstado = new PuzzleDeSeis(novo);
					s.add(new Acao(novoEstado, 1));
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
		if (this == p){
			return true;
		}
		if (!(p instanceof PuzzleDeSeis)){
			return false;
		}

		PuzzleDeSeis np = (PuzzleDeSeis) p;
		int a = 0;
		for(int i = 0; i < 2; i++) {
			for(int j = 0; j < 6; j++) {
				if(np.matriz[i][j] == this.matriz[i][j]) {
					a++;
				}
			}
		}
		
		return a == 12;
	}
	
	/*
     * retorna um inteiro com o valor do hash code deste estado
     */
	@Override
	public int hashCode() {
		int soma = 0;
		int n = 0;
		for(int i = 0; i < 2; i++){
			for(int j = 0; j < 6; j++){
				soma += this.matriz[i][j] * Math.pow(5, n);
				n++;
			}
		}

		return soma;
	}
	
	public String toString() {
		return "'''''''''''\n"+matriz[0][0]+"|"+matriz[0][1]+"|"+matriz[0][2]+"|"+matriz[0][3]+"|"+matriz[0][4]+"|"+matriz[0][5]+"\n"+
				"------------\n"+
				matriz[1][0]+"|"+matriz[1][1]+"|"+matriz[1][2]+"|"+matriz[1][3]+"|"+matriz[1][4]+"|"+matriz[1][5];
		
	}
	
	public static void main(String[] args) {
		PuzzleDeSeis n = new PuzzleDeSeis();
		PuzzleDeSeis n2 = new PuzzleDeSeis();

		
		System.out.println(n);
		ArrayList<Acao> sim = n.suc();
		ArrayList<Acao> ama = new ArrayList<>();
		ArrayList<Acao> ama2 = new ArrayList<>();
		for(Acao a: sim) {
			ama.addAll(a.getEstado().suc());
		}
		for(Acao a: ama) {
			ama2.addAll(a.getEstado().suc());
		}
		
		for(Acao a : ama2) {
			if(a.getEstado().goal())
				System.out.println(a.getEstado());
		}


		System.out.println(n);System.out.println(n2);
		System.out.println("\n"+ n.hashCode());
		System.out.println(n2.equals(n)); //usar hashcode de PuzzelDeSeis
	}

}
