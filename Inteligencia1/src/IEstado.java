import java.util.ArrayList;

public interface IEstado {
	double h();
	
	boolean goal();
	
	ArrayList<Acao> suc();
	
	static ArrayList<IEstado> getIniciais(){
		return new ArrayList<>();
	}
	
	boolean equals(Object p);
	
	int hashCode();
}
