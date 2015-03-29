import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author RajatBhageria 
 */
public class Main {

	/**
	 * @param args
	 */
	private static long startLoadTimeMatrix; 
	private static long estimatedLoadTimeMatrix;
	private static long startLoadTimeList;
	private static long estimatedLoadTimeList;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		AdjacencyMatrix matrix = new AdjacencyMatrix(4039);
		AdjacencyList list = new AdjacencyList(4039);

		int i = 0, j = 0;
		
		String file= "src/facebook_combined.txt";
		//String file = "src/test1.txt";
		try {
		    BufferedReader in = new BufferedReader(new FileReader(file));
		    String str;
		    while ((str = in.readLine()) != null){
		    	int spaceIndex = str.indexOf(" ");
		    	
		    	//Parse the indexes of the txt file and then data to matrix
		    	try{
		    		i = Integer.parseInt((str.substring(0, spaceIndex)));
			    	j = Integer.parseInt((str.substring(spaceIndex+1, str.length())));
			    	
			    	startLoadTimeMatrix = System.nanoTime();    
			    	matrix.addEdge(i,j);
			    	matrix.addEdge(j, i);
			    	estimatedLoadTimeMatrix = estimatedLoadTimeMatrix+ 
			    			System.nanoTime() - startLoadTimeMatrix;

			    	startLoadTimeList = System.nanoTime();    
			    	list.addEdge(i, j);
			    	list.addEdge(j, i);
			    	estimatedLoadTimeList = estimatedLoadTimeList + 
			    			System.nanoTime() - startLoadTimeList;

		    	} catch(ArrayIndexOutOfBoundsException a){
		    		continue;
		    	}
		    }
		    in.close();
		    //System.out.println(matrix.toString());
		} catch (IOException e) {
			System.out.println("ERROR: unable to read file " + file);
		    e.printStackTrace(); 
		}		
		
		//Instantiating Searches Class for Matrix and List
		Searches matrixSearch = new Searches(matrix);
		Searches listSearch = new Searches(list);

		//Distance between nodes 40 and 1050
		System.out.println("The Distance between nodes 40 and 1050 is: " +matrixSearch.runBFS(40, 1050));

		
		//Frontiers Visited
		//System.out.println("The Number of Frontiers Visited from Root 15: " + search.runBFS(15));
		//System.out.println("The Number of Frontiers Visited from Root 2134: " + search.runBFS(2134));
		
		
		//Running Complete BFS
		//System.out.println("Complete BFS: " + matrixSearch.runBFS(0));
		//System.out.println("Complete BFS: " + matrixSearch.runBFS(21));
		System.out.println("Complete BFS: " + matrixSearch.runBFS(1344));
		
		
		
		
		//EXTRA CREDI!!!
		
		//Loading time for Matrix vs. List 
		System.out.println("The Estimated Time Loading for matrix is: " + estimatedLoadTimeMatrix);
		System.out.println("The Estimated Time Loading for list is: " + estimatedLoadTimeList);

		
		//DFS time for Matrix vs. List. 
		long startDFSTimeMatrix = 0; 
		long estimatedDFSTimeMatrix =0;
		long startDFSTimeList = 0;
		long estimatedDFSTimeList =0 ;
    	startDFSTimeMatrix = System.nanoTime();    
		matrixSearch.runDFS(0);
		estimatedDFSTimeMatrix = estimatedDFSTimeMatrix + 
    			System.nanoTime() - startDFSTimeMatrix;
    	startDFSTimeList = System.nanoTime();    
		listSearch.runDFS(0);
		estimatedDFSTimeList = estimatedDFSTimeList + 
    			System.nanoTime() - startDFSTimeList;
		System.out.println("The Estimated Time for DFS for matrix is: " + estimatedDFSTimeMatrix);
		System.out.println("The Estimated Time for DFS for list is: " + estimatedDFSTimeList);
		
		
		
		//BFS time for Matrix vs. List. 
		long startBFSTimeMatrix = 0; 
		long estimatedBFSTimeMatrix =0;
		long startBFSTimeList = 0;
		long estimatedBFSTimeList =0 ;
    	startBFSTimeMatrix = System.nanoTime();    
		matrixSearch.runBFS(0);
		estimatedBFSTimeMatrix = estimatedBFSTimeMatrix + 
    			System.nanoTime() - startBFSTimeMatrix;
    	startBFSTimeList = System.nanoTime();    
		listSearch.runBFS(0);
		estimatedBFSTimeList = estimatedBFSTimeList + 
    			System.nanoTime() - startBFSTimeList;
		System.out.println("The Estimated Time for BFS for matrix is: " + estimatedBFSTimeMatrix);
		System.out.println("The Estimated Time for BFS for list is: " + estimatedBFSTimeList);

	}

}
