import java.util.HashSet;
import java.util.Set;


public class AdjacencyMatrix implements AdjacencyStructure {
	
	private boolean [][] matrix; 
	int n = 0;
	
	/**
	 * @param The height and width of the matrix
	 */
	public AdjacencyMatrix(int pN){
		n = pN;
		matrix = new boolean[n][n];
	}
	
	/**
	 * @param The height (w) and the  width (w) of the matrix
	 */
	public void addEdge(int w, int h){
		matrix[w][h] = true;
	}
	
	/**
	 * @param The height (w) and the  width (w) of the matrix
	 */
	public void removeEdge(int w, int h){
		matrix[w][h] = false;
	}
	
	/**
	 * @param The height (w) and the  width (w) of the matrix
	 * @return Whether there is an edge at the particular
	 *  position in the adjacency matrix
	 */
	public boolean hasEdge(int w, int h){
		return matrix[w][h];
	}
	
	/**
	 * @return The number of different edges in the graph 
	 */
	public int getNumberOfVertices(){
		return numberOfVertices; 
	}
	
	
	/**
	 * @return A set with all the vertices in the graph. 
	 */
	public Set<Integer> allVertices(){
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < matrix.length; i++){
			for (int j = 0; j < matrix.length; j++){
				
				if (matrix[i][j]){
					if (!set.contains(i)) set.add(i);
					if (!set.contains(j)) set.add(j);
				}
			}
		}
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
	 * @return Printed Representation of the AdjacencyMatrix
	 */
	@Override
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
	
	
	private int numberOfVertices =0;
	
	/**
	 * @return the 2D Array that the AdjacencyMatrix is a wrapper of
	 */
	public boolean[][] get2DArray(){
		return matrix;
	}
	
}
