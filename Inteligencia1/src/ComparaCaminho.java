import java.util.Comparator;

public class ComparaCaminho implements Comparator<Node> {

    @Override
    public int compare(Node o1, Node o2) {
        return (int) (o1.f() - o2.f());
    }

}
