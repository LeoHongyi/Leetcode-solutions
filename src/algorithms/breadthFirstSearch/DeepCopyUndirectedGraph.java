package algorithms.breadthFirstSearch;
/**
 * @author Qihao He
 * @date 09/24/2019
 * https://app.laicode.io/app/problem/132
 * Method: recursion (DFS)
 *  for every single recursion function call, we make a copy of the input node,
 *  and leave all other copies of the successors to the recursion functions.
 */

/**
 * class GraphNode {
 *   public int key;
 *   public List<GraphNode> neighbors;
 *   public GraphNode(int key) {
 *     this.key = key;
 *     this.neighbors = new ArrayList<GraphNode>();
 *   }
 * }
 */

public class DeepCopyUndirectedGraph {
    public List<GraphNode> copy(List<GraphNode> graph) {
        // Write your solution here.
        if (graph == null) {
            return null;
        }
        Map<GraphNode, GraphNode> lookup = new HashMap<>();
        for (GraphNode node : graph) {
            // not yet seen, not in map
            if (!lookup.containsKey(node)) {
                lookup.put(node, new GraphNode(node.key));
                cloneGraph(node, lookup);
            }
        }
        return new ArrayList<GraphNode>(lookup.values());
    }
    private void cloneGraph(GraphNode seed, Map<GraphNode, GraphNode> lookup) {
        GraphNode copyNode = lookup.get(seed);
        for (GraphNode nei : seed.neighbors) {
            if (!lookup.containsKey(nei)) {
                lookup.put(nei, new GraphNode(nei.key));
                cloneGraph(nei, lookup);
            }
            copyNode.neighbors.add(lookup.get(nei));
        }
    }
}
