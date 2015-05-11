import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph implements Runnable {

    @Override
    public void run() {
    }

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Map<Integer, UndirectedGraphNode> nodeMap = new HashMap<>();
        cloneGraph(node, nodeMap);
        List<UndirectedGraphNode> nodeList = new ArrayList<>();
        nodeList.add(node);
        while (!nodeList.isEmpty()) {
            UndirectedGraphNode current = nodeList.remove(0);
            UndirectedGraphNode clone = nodeMap.get(current.label);
            if (clone.neighbors.isEmpty() && !current.neighbors.isEmpty()) {
                for (UndirectedGraphNode neighbor : current.neighbors) {
                    clone.neighbors.add(nodeMap.get(neighbor.label));
                    nodeList.add(neighbor);
                }
            }
        }
        return nodeMap.get(node.label);
    }

    private void cloneGraph(UndirectedGraphNode node, Map<Integer, UndirectedGraphNode> nodeMap) {
        if (nodeMap.containsKey(node.label)) {
            return;
        }
        nodeMap.put(node.label, new UndirectedGraphNode(node.label));
        for (UndirectedGraphNode neighbor : node.neighbors) {
            cloneGraph(neighbor, nodeMap);
        }
    }

}
