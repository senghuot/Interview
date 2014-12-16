package microsoft;

public class UpTree {
	public Node root;
	
	public UpTree() {
		root = new Node(0);
	}
	
	// There is a similar solution of this problem in "Cracking the Coding Inteview"
	// book but i will attempt without the solution first.
	// return null iff n1 a& n2 doesn't contains in the same tree or root is null.
	public Node commonAncestor(Node n1, Node n2) {
		// n1 and n2 points to
		if (root == null) return root;
		if (n1 == n2) return n1;
		
		// Let's tackle this problem at a different approach.
		// 1. We can use a data structure (hashset) to save all the parents of n1 then find the parent
		// 		of n2, which ever hit the hashset first is the answer.
		// 2. There's another way to solve it without saving all the parents of n1 but it involve with
		// 		a bit of moving up the parents of n1 & n2. Lets's imagine that n1 is at depth 3 and n2
		//		is at a depth of 4. If we move n2 one level up then there is a chance that n1 and & n2
		//		points to the same node which means they thats the common ancestor.
		//			I.	level n1 and n2 then check if they points to the same node.
		//			II.	if not then keep moving up one level at a time till n1 & n2 points to the same
		//				node or they both hit null which means no common ancestor.
		
		int left = depth(n1);
		int right = depth(n2);
		
		for (int i = left; i > right; i--)
			n1 = n1.parent;
		
		for (int i = right; i > left; i--)
			n2 = n2.parent;
		
		for (int i = 0; i < left; i++) {
			if (n1 == n2)
				return n1;
			n1 = n1.parent;
			n2 = n2.parent;
		}
		
		return null;
	}
	
	// getting the depth of root.
	public int depth(Node root) {
		// define: null to be depth zero
		if (root == null) return -1;
		return 1 + depth(root.parent);
	}
}
