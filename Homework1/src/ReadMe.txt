In this program, I have an AdjacencyMatrix class that is a wrapper of a 2D array. It contains various methods to add, subtract, or change edges.

I use this AdjacencyMatrix class in the Searches class. This class takes in a AdjacencyMatrix as a parameter and then runs BFS or DFS on it. There are two BFS methods: take in a root node and run BFS on the entire graph, or take in a root node and a target node and try to find the target node. These are overloaded methods that both rely on the findAdjacentEdges() method.

In the main class, I use a BufferedReader to read in the text file of edges, parse the list, and represent the data as an AdjacencyMatrix. Then I create an instance of the Searches class by passing in the newly created AdjacencyMatrix and use it to run any methods from the Searches class.

