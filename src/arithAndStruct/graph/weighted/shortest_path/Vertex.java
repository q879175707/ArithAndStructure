package arithAndStruct.graph.weighted.shortest_path;

public class Vertex {
	public char label;
	public boolean isInTree;
	
	public Vertex(char lab) {
		label = lab;
		isInTree = false;
	}
}
