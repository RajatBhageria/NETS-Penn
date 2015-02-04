
public class AdjacencyMatrix {
	
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
	
	public int getLength(){
		return n;
	}
	
	
}