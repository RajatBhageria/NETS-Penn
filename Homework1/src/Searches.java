import java.util.*;


public class Searches {
	private AdjacencyMatrix matrix;
	
	public Searches(AdjacencyMatrix pMatrix){
		matrix = pMatrix; 
	}
	
	/**
	 * This method runs the BFS algorithm and returns back the 
	 * shortest distance between the starting "root" and a target
	 * node. 
	 * @param The starting "root" of the algorithm
	 * @param The target node to be checked. 
	 * @return The number of nodes that the algorithm processed. 
	 */
	public int runBFS(int root, int target){
		if (root == target) return 0; 
		Deque<Integer> deque = new ArrayDeque<Integer>();	
		Set<Integer> set = new HashSet<Integer>();
		deque.add(root);
		set.add(root);
		int count = 0;
		while (!deque.isEmpty()){
			int current = deque.pop();
			ArrayList<Integer> adjacentEdges = findAdjacentEdges(current);
			//System.out.println(adjacentEdges);
			if (set.size()==matrix.getNumberOfVertices()){
				System.out.println("All Edges Have Been Examined");
			}
			if (adjacentEdges.size()>0) count++;
			for (int e = 0; e < adjacentEdges.size(); e++){
				int adjacentVertex = adjacentEdges.get(e);
				//if (set.contains(e)) adjacentEdges.remove(e);
				if (!set.contains((int) adjacentVertex)){
					if (adjacentVertex == target) return count;
					deque.add(adjacentVertex);
					set.add(adjacentVertex);
					matrix.removeEdge(e, adjacentVertex);
					matrix.removeEdge(adjacentVertex, e);
				}
			}
		}
		System.out.println("All nodes have been examined");
		System.out.println("Node " + target + " was not found");
		System.out.println(set);
		set.clear();
		deque.clear();
		return Integer.MAX_VALUE; 
	}
	
	
	/**
	 * Overloaded method for runBFS(). Instead of taking in a target node, 
	 * this method checks every single node.
	 * @param The starting "root" of the algorithm
	 * @param The target node to be checked. 
	 * @return The number of nodes that the algorithm processed. 
	 */
	public int runBFS(int root){
		Deque<Integer> deque = new ArrayDeque<Integer>();	
		Set<Integer> set = new HashSet<Integer>();
		deque.add(root);
		set.add(root);
		int count = 0;
		while (!deque.isEmpty()){
			if (set.size()==matrix.getNumberOfVertices()){
				System.out.println("All Edges Have Been Examined. "
						+ "The Graph is Fully Connected");
				//return count;
			}
			int current = deque.remove();
			ArrayList<Integer> adjacentEdges = findAdjacentEdges(current);
			System.out.println(adjacentEdges);
			if (adjacentEdges.size()>0) count++;
			for (int e = 0; e < adjacentEdges.size(); e++){
				int adjacentVertex = adjacentEdges.get(e);
				//if (set.contains(e)) adjacentEdges.remove(e);
				if (!set.contains((int) adjacentVertex)){
					deque.add(adjacentVertex);
					set.add(adjacentVertex);
					matrix.removeEdge(e, adjacentVertex);
					matrix.removeEdge(adjacentVertex, e);
					
					
				}
			}
			
		}
		System.out.println("All nodes have been examined");
		//set.clear();
		deque.clear();
		//System.out.println(set.size());
		return count;
	}

	
	/**
	 * Given a starting node, findAdjacentEdges returns an ArrayList with 
	 * all the nodes that are adjacent to the node that was passed in 
	 * as a parameter. 
	 * @param The starting "root" of the algorithm
	 * @return An ArrayList of all adjacent edges. 
	 */
	public ArrayList<Integer> findAdjacentEdges(int node){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < matrix.getLength(); i++){
			if (matrix.hasEdge(node,i)) arr.add(i);
		}
		return arr;
	}
	
	/**
	 * This method runs the DFS algorithm. p
	 * @param The starting "root" of the algorithm
	 */
	public void runDFS(int root){
		Set<Integer> set = new HashSet<Integer>();
		set.add(root);
		ArrayList<Integer> adjacentEdges = findAdjacentEdges(root);
		for (int e = 0; e < adjacentEdges.size(); e++){
			int adjacentVertex = adjacentEdges.get(e);
			if (!set.contains((int) adjacentVertex)){
				runDFS(adjacentVertex);
			}
		}
	}
	
	
	public int distanceOfFour(int root){
		Set<Integer> set = matrix.allVertices();
		int count =0;
		for (int i = 0; i < set.size(); i++){
			while (set.iterator().hasNext()){
				if (runBFS(root, set.iterator().next())==4) count++;
			}
		}
		
		return count;
	}
	
	
}
