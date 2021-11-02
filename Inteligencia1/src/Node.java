import java.util.ArrayList;

public class Node {
	private IEstado estado;
	private Node nodoPai;
	private double custoCaminho;
	private ArrayList<Node> nosFronteira;
	private String operacao;
	
	private Node(IEstado estado, Node estadoPai, double custoCaminho) {
		this.estado = estado;
		this.nodoPai = estadoPai;
		this.custoCaminho = custoCaminho;
	}

	public IEstado getEstado() {
		return estado;
	}

	public Node getEstadoPai() {
		return nodoPai;
	}

	public double getCustoCaminho() {
		return custoCaminho;
	}

	public double getCustoExpectativa() {
		return estado.h();
	}
	
	public String getOperacao() {
		return operacao;
	}
	
	/*
	 * Criar os nos Fronteiras do atual nodo
	 */
	public void criarNosFronteira(){
		nosFronteira = new ArrayList<>();
		ArrayList<Acao> sucessor = estado.suc();
		
		for(Acao s : sucessor) {
			Node n = new Node(s.getEstado(), this, s.getCusto());
			nosFronteira.add(n);
		}
	}
	
	//estados associados ao nó
	//associar o pai do nó -> o nó anterior -> apontador para o pai
	//custo do caminho -> soma de tudo ate oa momento -> caminho ja andado
	//estimativa de quanto custa ate o estado final -> o que pode faltar ate o fim -> está no estado
	//criar o no, calcular o h do estado e guardar numa variavel -> pegar no ha do estado

}
