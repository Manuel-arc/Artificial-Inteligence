
public class Acao {
	private IEstado estado;
	private double custo;
	private String descr;
	
	public Acao(IEstado estado, double custo) {
		this.estado = estado;
		this.custo = custo;
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
