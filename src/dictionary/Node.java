package dictionary;

public class Node {
	
	public Node[] children;
	public String def;
	
	public Node(String def) {
		
		// children = {null, null, ...}
		children = new Node[26];
		this.def = def;
	}
}
