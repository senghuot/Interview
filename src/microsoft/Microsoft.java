package microsoft;

public class Microsoft {
	
	public static void main(String[] args) {
		UpTree t = new UpTree();
		t.root.data = 50;
		
		t.root.left = new Node(25);
		t.root.left.parent = t.root; 
		
		t.root.right = new Node(75);
		t.root.right.parent = t.root;
		t.root.right.left = new Node(60);
		t.root.right.left.parent = t.root.right;
		t.root.right.right = new Node(100);
		t.root.right.right.parent = t.root.right;
		
		Node n1 = t.root.right.left;
		Node n2 = t.root.right.right;
		System.out.println(t.commonAncestor(n1, n2).data);
	}
	
	/**
	 * @param arr
	 * @return if arr is empty then res.max is a wildcard.
	 * @throws Exception iff arr is null
	 */
	public Pair Resize(int[] arr) throws Exception {
		if (arr == null)
			throw new IllegalArgumentException("Input can't be null.");
		
		Pair res = new Pair();
		res.size = arr.length;
		if (arr.length == 0)
			return res;
		
		int maxTmp = arr[0];
		for (int i = 1; i < arr.length; i++)
			maxTmp = Math.max(maxTmp, arr[i]);
		
		res.max = maxTmp;
		return res;
	}
	
	class Pair {
		public int size;
		public int max;
	}

}
