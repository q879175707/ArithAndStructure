package arithAndStruct.graph.mst;

public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[]; // array of vertices
	private int adjMat[][]; // adjacency matrix
	private int nVerts;
	private StackX theStack;

	public Graph() {
		vertexList = new Vertex[MAX_VERTS];

		adjMat = new int[MAX_VERTS][MAX_VERTS]; // set adjacency matrix to 0
		nVerts = 0;
		for (int j = 0; j < MAX_VERTS; j++)
			for (int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = 0;

		theStack = new StackX();
	}

	public void addVertex(char lab) {
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}

	public void mst() {

		vertexList[0].wasVisited = true; // start at 0 mark it
		theStack.push(0);

		while (!theStack.isEmpty()) {// until stack empty
			// get stack top
			int currentVertex = theStack.peek();
			// get next unvisited neighbor
			int v = getAdjUnvisitedVertex(currentVertex);
			if (v == -1) // if no more neighbors pop it away
				theStack.pop();
			else {// got a neighbor

				vertexList[v].wasVisited = true; // mark it
				theStack.push(v); // push it
				displayVertex(currentVertex); // from current V
				displayVertex(v); // to v
				System.out.print(" ");
			}
		} // end while(stack not empty)

		for (int j = 0; j < nVerts; j++)
			vertexList[j].wasVisited = false;
	}

	public int getAdjUnvisitedVertex(int v) {
		for (int j = 0; j < nVerts; j++)
			if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
				return j;
		return -1;
	}
}
