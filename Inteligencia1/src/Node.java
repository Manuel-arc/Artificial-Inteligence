import java.util.ArrayList;

public class Node {
	private IEstado estado;
	private Node nodoPai;
	private double g; //CUSTO DO CAMINHO ATE AO MOMENTO
	private int profundidade;
	private ArrayList<Node> nosSucessores;
	private String operacao;
	
	public Node(IEstado estado, Node estadoPai, String operacao) {
		this.estado = estado;
		this.nodoPai = estadoPai;
		this.operacao = operacao;
		
		if(this.nodoPai == null){
			g = 0;
		} else {
			g = nodoPai.g() + 1;
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

	public ArrayList<Node> getNosSucessores(){
		return nosSucessores;
	}
	
	/*
	 * Criar os nos Fronteiras do atual nodo
	 */
	public void criarNosSucessores(){
		nosSucessores = new ArrayList<>();
		ArrayList<Acao> sucessor = estado.suc();
		
		for(Acao s : sucessor) {
			Node n = new Node(s.getEstado(), this, s.getDescr());
			nosSucessores.add(n);
		}
	}
	
	//estados associados ao n�
	//associar o pai do n� -> o n� anterior -> apontador para o pai
	//custo do caminho -> soma de tudo ate oa momento -> caminho ja andado
	//estimativa de quanto custa ate o estado final -> o que pode faltar ate o fim -> est� no estado
	//criar o no, calcular o h do estado e guardar numa variavel -> pegar no ha do estado

	public static void main(String[] args) {
		PuzzleDeSeis a = new PuzzleDeSeis();
		Node n = new Node(a, null, null);

		System.out.println("Primeiro estado");
		System.out.println(n.getEstado());
		System.out.println(n.getOperacao());
		System.out.println(n.g());
		System.out.println(n.getProfundidade());

		n.criarNosSucessores();

		System.out.println("Nos Fronteira");
		for(Node no : n.getNosSucessores()){
			System.out.println(no.getEstado());
			System.out.println(no.getOperacao());
			System.out.println(no.g());
			System.out.println(no.getProfundidade());
		}

		Node am = n.getNosSucessores().get(0);
		am.criarNosSucessores();

		System.out.println("\nNos fronteira 2 lvl");
		for(Node no : am.getNosSucessores()){
			System.out.println(no.getEstado());
			System.out.println(no.getOperacao());
			System.out.println(no.g());
			System.out.println(no.getProfundidade());
		}
	}

}
