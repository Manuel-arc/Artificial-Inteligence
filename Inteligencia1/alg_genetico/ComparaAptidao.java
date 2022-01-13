import java.util.Comparator;

public class ComparaAptidao implements Comparator<Individuo> {

    @Override
    public int compare(Individuo o1, Individuo o2) {
        return (int) (o2.getAptidao() - o1.getAptidao());
    }

}