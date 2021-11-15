
public class Acao {
	private IEstado estado;
	private double custo;
	private String descr;
	
	public Acao(IEstado estado, double custo, String descricao) {
		this.estado = estado;
		this.custo = custo;
		this.descr = descricao;
	}

	public IEstado getEstado() {
		return estado;
	}

	public double getCusto() {
		return custo;
	}

	public String getDescr() {
		return descr;
	}
}
