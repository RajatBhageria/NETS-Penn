import java.util.Set;


public interface AdjacencyStructure {
	void addEdge(int i, int j);
	boolean hasEdge (int i, int j);
	Set<Integer> allVertices();
	int getNumberOfVertices();
	int getLength();
	
	
}
