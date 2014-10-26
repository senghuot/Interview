package LinkedList;

public class LinkedList {
	
	private Node root;
	
	public LinkedList() {
		root = null;
	}
	
	// add method
	public void add(int data) {
		if(root == null) {
			root = new Node(data);
		} else {
			Node tmp = root;
			while(tmp.next != null)
				tmp = tmp.next;
			
			tmp.next = new Node(data);
		}
	}
	
	// embedded Node class
	public class Node {
		private int data;
		private Node next;
		
		public Node(int data) {
			this.data = data;
		}
	}
	
	@Override
	public String toString() {
		if(root == null)
			return "";
		
		StringBuilder res = new StringBuilder();
		res.append(root.data);
		
		Node tmp = root;
		while(tmp.next != null) {
			tmp = tmp.next;
			res.append(", " + tmp.data);
		}
		return res.toString();
	}
}
