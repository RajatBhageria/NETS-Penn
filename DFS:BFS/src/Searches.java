import java.util.*;

public class Searches {
	private AdjacencyStructure struct;
	
	public Searches(AdjacencyStructure pStruct){
		struct = pStruct;
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
			if (set.size()==struct.getNumberOfVertices()){
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
			if (set.size()==struct.getNumberOfVertices()){
				System.out.println("All Edges Have Been Examined. "
						+ "The Graph is Fully Connected");
				return count;
			}
			if (count == 4) System.out.println("The number of nodes that are a "
					+ "distance of 4 away from the root are: " + set.size());
			int current = deque.remove();
			ArrayList<Integer> adjacentEdges = findAdjacentEdges(current);
			if (adjacentEdges.size()>0) count++;
			for (int e = 0; e < adjacentEdges.size(); e++){
				int adjacentVertex = adjacentEdges.get(e);
				if (set.contains(e)) adjacentEdges.remove(e);
				if (!set.contains((int) adjacentVertex)){
					deque.add(adjacentVertex);
					set.add(adjacentVertex);
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
	private ArrayList<Integer> findAdjacentEdges(int node){
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i = 0; i < struct.getLength(); i++){
			if (struct.hasEdge(node,i)) arr.add(i);
		}
		return arr;
	}
	
	
	private static ArrayList<Integer> adjacentNodes = new ArrayList<Integer>();
	private static Set<Integer> seenNodes = new HashSet<Integer>();
	
	/**
	 * This method runs the DFS algorithm.
	 * @param The starting "root" of the algorithm
	*/
	public Set<Integer> runDFS(int root) {
		runDFSHelper(root);
		return seenNodes;
	}
	
	/**
	 * This is a helper method for the runDFS() method. 
	 * @param The starting "root" of the algorithm
	*/
	public void runDFSHelper(int root) {
		seenNodes.add(root); adjacentNodes = findAdjacentEdges(root);
		for (int i=0;i<adjacentNodes.size();i++) {
			if (!seenNodes.contains((int) adjacentNodes.get(i))) {
			   runDFS(adjacentNodes.get(i));
			}
		}
	}
	
	
	/**
	 * This is an earlier version of the 4 node algorithm.
	 * I am currently not using this algorithm and am incorporating 
	 * the answer to find the distance of 4 in my runBFS method. 
	 * @param The starting "root" of the algorithm
	*/
	public int distanceOfFour(int root){
		Set<Integer> set = struct.allVertices();
		int counter =0;
		for (int i = 0; i < set.size(); i++){
			while (set.iterator().hasNext()){
				if (runBFS(root, set.iterator().next())==4) counter++;
			}
		}
		
		return counter;
	}
	

		
}
