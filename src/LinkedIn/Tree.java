package LinkedIn;

import java.util.*;

public class Tree {
	
	private Node root;
	
	public static class Node {
		int data;
		Node left;
		Node right;
		
		public Node(int num) {
			data = num;
		} 
	} 
	
	public Tree() {
		root = null;
	}
	
	public void add(int n) {
		root = add(root, n);
	}
	
	private Node add(Node root, int n) {
		if (root == null)
			return new Node(n);
		
		if (n <= root.data)
			root.left = add(root.left, n);
		
		if (n > root.data)
			root.right = add(root.right, n);
		
		return root;
	}
	
	public void printLevel() {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		Queue<Node> l = new LinkedList<Node>();
		while (!q.isEmpty()) {
		
			while (!q.isEmpty()) {
				Node curr = q.remove();
				if (curr.left != null)
					l.add(curr.left);
				if (curr.right != null)
					l.add(curr.right);
				System.out.print(curr.data + " ");
			}
			
			while (!l.isEmpty())
				q.add(l.remove());
			System.out.println();
		}
	}
}
