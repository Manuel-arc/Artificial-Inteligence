import java.util.ArrayList;

public class Node {
	private IEstado estado;
	private Node nodoPai;
	private double g; //CUSTO DO CAMINHO ATE AO MOMENTO
	private int profundidade;
	private ArrayList<Node> nosFronteira;
	private String operacao;
	
	private Node(IEstado estado, Node estadoPai, double custoCaminho, String operacao) {
		this.estado = estado;
		this.nodoPai = estadoPai;
		this.operacao = operacao;
		
		if(this.nodoPai == null){
			g = custoCaminho;
		} else {
			g = nodoPai.g() + custoCaminho;
		}

		if(this.nodoPai == null){
			profundidade = 1;
		} else{
			profundidade = nodoPai.getProfundidade() + 1;
		}
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

	public int getProfundidade(){
		return profundidade;
	}

	public double h() {
		return estado.h();
	}

	public String getOperacao() {
		return operacao;
	}

	public ArrayList<Node> getNosFronteira(){
		return nosFronteira;
	}
	
	/*
	 * Criar os nos Fronteiras do atual nodo
	 */
	public void criarNosFronteira(){
		nosFronteira = new ArrayList<>();
		ArrayList<Acao> sucessor = estado.suc();
		
		for(Acao s : sucessor) {
			Node n = new Node(s.getEstado(), this, s.getCusto(), s.getDescr());
			nosFronteira.add(n);
		}
	}
	
	//estados associados ao n�
	//associar o pai do n� -> o n� anterior -> apontador para o pai
	//custo do caminho -> soma de tudo ate oa momento -> caminho ja andado
	//estimativa de quanto custa ate o estado final -> o que pode faltar ate o fim -> est� no estado
	//criar o no, calcular o h do estado e guardar numa variavel -> pegar no ha do estado

	public static void main(String[] args) {
		PuzzleDeSeis a = new PuzzleDeSeis();
		Node n = new Node(a, null, 0, null);

		System.out.println("Primeiro estado");
		System.out.println(n.getEstado());

		n.criarNosFronteira();

		System.out.println("Nos Fronteira");
		for(Node no : n.getNosFronteira()){
			System.out.println(no.getEstado());
			System.out.println(no.getOperacao());
		}
	}

}
