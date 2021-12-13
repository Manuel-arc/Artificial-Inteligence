import java.util.ArrayList;

public class Node {
	private IEstado estado;
	private Node nodoPai;
	private double g; // CUSTO DO CAMINHO ATE AO MOMENTO
	private double f; // CUSTO DO QUE PODERÁ FALTAR. g() + h()
	private int profundidade;
	private ArrayList<Node> nosSucessores;
	private String operacao;

	public Node(IEstado estado, Node estadoPai, String operacao) {
		this.estado = estado;
		this.nodoPai = estadoPai;
		this.operacao = operacao;

		if (this.nodoPai == null) {
			g = 0;
            f = h();
		} else {
			g = nodoPai.g() + 1;
            f = g() + h();
		}

		if (this.nodoPai == null) {
			profundidade = 1;
		} else {
			profundidade = nodoPai.getProfundidade() + 1;
		}
	}

	public Node() {

	}

	public IEstado getEstado() {
		return estado;
	}

	public Node getEstadoPai() {
		return nodoPai;
	}

	public double g() {
		return g;
	}

	public double h() {
		return estado.h();
	}

	public double f() {
		return f;
	}

	public int getProfundidade() {
		return profundidade;
	}

	public String getOperacao() {
		return operacao;
	}

	/*
	 * Criar os nos Fronteiras do atual nodo
	 */
	public ArrayList<Node> getNosSucessores() {
		nosSucessores = new ArrayList<>();
		ArrayList<Acao> sucessor = estado.suc();

		for (Acao s : sucessor) {
			Node n = new Node(s.getEstado(), this, s.getDescr());
			nosSucessores.add(n);
		}

		return nosSucessores;
	}

	// estados associados ao n�
	// associar o pai do n� -> o n� anterior -> apontador para o pai
	// custo do caminho -> soma de tudo ate oa momento -> caminho ja andado
	// estimativa de quanto custa ate o estado final -> o que pode faltar ate o fim
	// -> est� no estado
	// criar o no, calcular o h do estado e guardar numa variavel -> pegar no ha do
	// estado

}
