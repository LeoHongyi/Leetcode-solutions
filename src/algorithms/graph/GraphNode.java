package algorithms.graph;

import java.util.ArrayList;
import java.util.List;
/**
 * @author Qihao He
 * @date 09/24/2019
 */
public class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<>();
    }
}
