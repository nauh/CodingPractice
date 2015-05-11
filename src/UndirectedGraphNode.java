import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {

    int label;
    List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        this.label = x;
        this.neighbors = new ArrayList<>();
    }

}
