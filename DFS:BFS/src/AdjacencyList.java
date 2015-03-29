import java.awt.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


public class AdjacencyList implements AdjacencyStructure {
	
	private Map<Integer, LinkedList<Integer>> map;
	int n = 0;
	
	/**
	 * @param The height and width of the matrix
	 */
	public AdjacencyList(int pN){
		n = pN;
		map = new HashMap<Integer, LinkedList<Integer>>(n);
		for (int i = 0; i < map.size(); i++){
			map.put(i, new LinkedList<Integer>());
		}
	}
	
	/**
	 * @param The two nodes (i,j) in which there exists an edge. 
	 */
	public void addEdge(int i, int j){
		LinkedList<Integer> test;
		if (map.containsKey(i)){
			 test = map.get(i);
			 if (!test.contains(j)) test.add(j);
		}
		else if (map.containsKey(j)){
			test = map.get(j);
			if (!test.contains(i)) test.add(i);

		}
	}

	
	/**
	 * @param The two nodes (i,j) that you want to check whether there is an edge
	 * @return Whether there is an edge at the particular
	 *  position in the adjacency matrix
	 */
	public boolean hasEdge(int i, int j){
		LinkedList<Integer> test;
		if (map.containsKey(i)){
			 test = map.get(i);
			 return test.contains(j);
		}
		else if (map.containsKey(j)){
			test = map.get(j);
			return test.contains(i);
		}		
		return false; 
	}
	
	
	/**
	 * @return A set with all the vertices in the graph. 
	 */
	public Set<Integer> allVertices(){
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < map.size(); i++){
			for (int j = 0; j < map.get(i).size();j++){
					if (!set.contains(j)) set.add(j);
			}
		}
		numberOfVertices = set.size();
		return set; 
	}


	
	/**
	 * @return The number of different edges in the graph 
	 */
	public int getNumberOfVertices(){
		return numberOfVertices;
	}
	
	
	/**
	 * @return Return Length/Height of Matrix
	 */
	public int getLength(){
		return n;
	}

	
	private int numberOfVertices=0;
	
}

