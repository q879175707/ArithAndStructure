package arithAndStruct.graph.mst;

public class MSTApp {
	public static void main(String[] args) {
		Graph theGraph = new Graph();
		theGraph.addVertex('A');
		theGraph.addVertex('B');
		theGraph.addVertex('C');
		theGraph.addVertex('D');
		theGraph.addVertex('E');
		
		theGraph.addEdge(0, 1);	//AB
		theGraph.addEdge(0, 2);	//AC
		theGraph.addEdge(0, 3);	//AD
		theGraph.addEdge(0, 4);	//AE
		theGraph.addEdge(1, 2);	//BC
		theGraph.addEdge(1, 3);	//BD
		theGraph.addEdge(1, 4);	//BE
		theGraph.addEdge(2, 3);	//CD
		theGraph.addEdge(2, 4);	//CE
		theGraph.addEdge(3, 4);	//DE
		
		System.out.print("Minimun spanning tree: ");
		theGraph.mst();
		System.out.println();
	}
}
