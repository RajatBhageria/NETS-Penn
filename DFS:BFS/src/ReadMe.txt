In this program, I have created a interface called AdjacencyStructure that contains various methods to add, subtract, or change edges. I have now implemented an AdjacencyMatrix class (my main data structure) that is a wrapper of a 2D array; and an AdjacencyList class (for extra credit) that uses a Map<Integer, LinkedList<Integer>>.  

The Searches class takes in an AdjacencyStructure and then allow the user to run BFS or DFS on it. There are two BFS methods: take in a root node and run BFS on the entire graph, or take in a root node and a target node and try to find the target node. These are overloaded methods that both rely on the findAdjacentEdges() method.

In the main class, I use a BufferedReader to read in the text file of edges, parse the list, and represent the data as either an AdjacencyMatrix or an AdjacencyList. Then I create an instance of the Searches class by passing in the newly created AdjacencyMatrix (or AdjacencyList) and use it to run any methods from the Searches class.

Again, the AdjacencyList is for extra credit. 

In the main class, I first answered all the questions and then towards the bottom of the main method, I have added various timer calls to measure the efficiency of the matrix vs the list. 