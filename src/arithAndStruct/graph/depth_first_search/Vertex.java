package arithAndStruct.graph.depth_first_search;

public class Vertex {
	public char label;
	public boolean wasVisited;
	
	public Vertex(char lab) {
		label = lab;
		wasVisited = false;
	}
}
