import java.awt.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;


public class AdjacencyList {
	
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
	 * @param The height (w) and the  width (w) of the matrix
	 */
	public void addEdge(int w, int h){
	}
	
	/**
	 * @param The height (w) and the  width (w) of the matrix
	 */
	public void removeEdge(int w, int h){
	}
	
	/**
	 * @param The height (w) and the  width (w) of the matrix
	 * @return Whether there is an edge at the particular
	 *  position in the adjacency matrix
	 */
	public void hasEdge(int w, int h){
		
	}
	
	/**
	 * @return The number of different edges in the graph 
	 */
	public int getNumberOfVertices(){
		return numberOfVertices; 
	}
	
	public Set<Integer> allVertices(){
		Set<Integer> set = new HashSet<Integer>();
		//for (int i = 0; i < matrix.length; i++){
		//	for (int j = 0; j < matrix.length; j++){
				
				//if (matrix[i][j]){
					//if (!set.contains(i)) set.add(i);
					//if (!set.contains(j)) set.add(j);
				//}
			//}
		//}
		numberOfVertices = set.size();
		return set; 
	}
	
	/**
	 * @return Return Length/Height of Matrix
	 */
	public int getLength(){
		return n;
	}
	
	/**
	 * @return Representation of the AdjacencyMatrix
	 */
	/**
	public String toString(){
		String out = "";
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix.length; j++){
				out = out + " " + matrix[i][j] + " ";
			}
			out = out + "\n";
		}
		return out;
	}
	*/
	
	private int numberOfVertices =0;
	
}

