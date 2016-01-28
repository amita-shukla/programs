/**
Clone an undirected graph. 
Each node in the graph contains a label and a list of its neighbors.
**/

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
        HashMap<UndirectedGraphNode,UndirectedGraphNode> mappings = new HashMap<>();
        
        //init copyHead
        UndirectedGraphNode copyHead = new UndirectedGraphNode(node.label);
        
        mappings.put(node, copyHead);
        
        //Init Queue
        Queue<UndirectedGraphNode> Q = new LinkedList<>();
        Q.add(node);
        
        //BFS
        while(!Q.isEmpty()){
            UndirectedGraphNode u = Q.remove();
            UndirectedGraphNode copyU = mappings.get(u);
            List<UndirectedGraphNode> copyNeighbors = new ArrayList<>();;
            
            for(UndirectedGraphNode v : u.neighbors){
                UndirectedGraphNode copyV;
                if(!mappings.containsKey(v)){
                    copyV = new UndirectedGraphNode(v.label);
                    mappings.put(v,copyV);
                    
                    Q.add(v);
                }else{
                    copyV = mappings.get(v);
                }
                copyNeighbors.add(copyV);
                //System.out.println("added neighbour of "+copyU.label+" : "+copyV.label );
                
            }
            copyU.neighbors = copyNeighbors;
            mappings.put(u,copyU);
        }
        return copyHead;
    }
}

