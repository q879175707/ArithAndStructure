package arithAndStruct.graph.weighted;

public class Graph {
	private final int MAX_VERTS = 20;
	private final int INFINITY = 1000000;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts;	// current number of vertices
	private int currentVert;
	private PriorityQ thePQ;
	private int nTree;	// number of verts in tree
	
	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int [MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int j = 0; j < MAX_VERTS; j++)		// initialization adjacency matrix 
			for (int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = INFINITY;
		thePQ = new PriorityQ();
	}
	
	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}
	
	public void addEdge(int start, int end, int weight) {
		adjMat[start][end] = weight;
		adjMat[end][start] = weight;
	}
	
	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}
	
	public void mstw() {	// minimun spanning tree
		currentVert = 0;		// start at 0
		
		while (nTree < nVerts - 1) { // while not all vertex in tree
			vertexList[currentVert].isInTree = true;	// put currentVertex in tree
			nTree++;
			
			// insert edges adjacent to currentVertex into Priority queue
			for (int j = 0; j < nVerts; j++) { 	// for each vertex
				if (j == currentVert)				// skip if it's us
					continue;
				if (vertexList[j].isInTree)		// skip if in the tree
					continue;
				
				// 当前节点到 j节点的距离
				int distance = adjMat[currentVert][j];
				
				if (distance == INFINITY)		// skip if no edge
					continue;
				putInPQ(j, distance);			// put it in PQ(maybe)
			}	// end for
			if (thePQ.size() == 0) {				// no vertices in PQ?
				System.out.println("Graph Not Connected");
				return;
			}
			
			// remove edge with minimum distance, from PQ
			Edge theEdge = thePQ.removeMin();
			int sourceVert = theEdge.srcVert;
			currentVert = theEdge.destVert;
			
			// display edge from source to current
			System.out.print(vertexList[sourceVert].label);
			System.out.print(vertexList[currentVert].label);
			System.out.print(" ");
		}	// end while (not all vertex in tree)
		
		// mst is complete
		// unmark vertices
		for (int j = 0; j < nVerts; j++)
			vertexList[j].isInTree = false;
	} // end mstw
	
	public void putInPQ(int newVert, int newDistance) {
		// is there another edge with the same destination vertex?
		int queueIndex = thePQ.find(newVert);// got edge's index
		if (queueIndex != -1) {	
			// 如果找到这个顶点，比较以前的权值与现在的权值
			// 比如以前是从A到C，现在是从B到C。C就是相同的终点。比较两个边的权值，选权值小的。
			Edge tempEdge = thePQ.peekN(queueIndex);	// get edge
			int oldDistance = tempEdge.distance;
			if (oldDistance > newDistance) {	// if newDistance shorter
				thePQ.removeN(queueIndex);	// remove old edge
				Edge theEdge = new Edge(currentVert, newVert, newDistance);
				thePQ.insert(theEdge);			// insert new edge
			}
			// else no action; just leave the old vertex there
		} else {	// no edge with same destination vertex
			Edge theEdge = new Edge(currentVert, newVert, newDistance);
			thePQ.insert(theEdge);
		}
	}
}
