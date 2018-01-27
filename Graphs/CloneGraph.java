/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return dfs(node, new HashMap<UndirectedGraphNode, UndirectedGraphNode>());
    }
    
    public UndirectedGraphNode dfs(UndirectedGraphNode node, 
                Map<UndirectedGraphNode, UndirectedGraphNode> map) {
        UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
        map.put(node, newNode);
        for (UndirectedGraphNode neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                dfs(neighbor, map);
            }
            map.get(node).neighbors.add(map.get(neighbor));
        }
        return newNode;
    }
}