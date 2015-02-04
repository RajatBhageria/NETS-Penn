import java.util.*;


public class Searches {
	private Deque<Integer> deque; 
	private AdjacencyMatrix matrix;
	private Set<Integer> set;
	
	public Searches(AdjacencyMatrix pMatrix){
		deque = new ArrayDeque<Integer>();	
		matrix = pMatrix; 
		set = new HashSet<Integer>();
	}
	

	 
	public int runBFS(int root, int target){
		deque.add(root);
		set.add(root);
		int count = 0;
		while (!deque.isEmpty()){
			int current = deque.pop();
			count++;
			if (current == target){
				return count;
			}
			ArrayList<Integer> adjacentEdges = findAdjacentEdges(current);
			for (int e = 0; e < adjacentEdges.size(); e++){
				int adjacentVertex = adjacentEdges.get(e);
				if (!set.contains((int) adjacentVertex)){
					deque.add(adjacentVertex);
					set.add(adjacentVertex);
				}
			}
			
		}
		System.out.println("All nodes have been examined");
		set.clear();
		deque.clear();
		return count;
	}
	
	public ArrayList<Integer> findAdjacentEdges(int node){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < matrix.getLength(); i++){
			if (matrix.hasEdge(node,i)) arr.add(i);
		}
		return arr;
	}
	
	public void runDFS(){
		
	}
	
	
}