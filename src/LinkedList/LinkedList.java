package LinkedList;

import java.util.HashSet;
import java.util.Set;

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
	
	public void removeDuplicate() {
		// too short
		if(root == null || root.next == null)
         return;
      
		Node curr = root;
		Node next;
		Set<Integer> mem = new HashSet<Integer>();
		while(curr.next.next != null) {
			next = curr.next;
			
			// deleting the current node
			if(mem.contains(curr.data)) {   
				curr.data = next.data;
				curr.next = next.next;
			} else {
				mem.add(curr.data);
				curr = curr.next;
			}
		}
		mem.add(curr.data);
		if(mem.contains(curr.next.data))
			curr.next = null;
	}
}
