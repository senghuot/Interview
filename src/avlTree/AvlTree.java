package avlTree;

public class AvlTree {

	AvlNode root;
	
	public void isAVL() {
		root = null;
	}
	
	public AvlTree(int[] arr) {
		root = buildAvlTree(arr, 0, arr.length - 1);
	}
	
	public AvlNode buildAvlTree(int[] arr, int low, int high) {
		if(low > high)
			return null;
		
		int mid = (high - low) / 2 + low;
		AvlNode root = new AvlNode(arr[mid]);
		root.left = buildAvlTree(arr, low, mid - 1);
		root.right = buildAvlTree(arr, mid + 1, high);
		
		return root;
	}

	public void verifyAVL() {
		System.out.println("We're good to go.");
	}
	
	public void add(int key) {
		root = add(root, key);
	} 
	
	private AvlNode add(AvlNode root, int key) {
		if(root == null)
			return new AvlNode(key);
		
		if(key <= root.key)
			root.left = add(root.left, key);
		else
			root.right = add(root.right, key);
		
		return root;
	}
	
	@Override
	public String toString() {
		return toString(root);
	}
	
	public String toString(AvlNode root) {
		if(root == null)
			return "";
		return toString(root.left)+ 
				", " + root.key + "{" + root.height + "}" + 
				", " + toString(root.right);
	}
	
	public void verifyAVLTree() {
		verifyAVLTree(root, 0, 40);
	}
	
	private void verifyAVLTree(AvlNode root, int min, int max) {
		if(root == null)
			return;
		
		assert(root.key >= min && root.key <= max);
		int left = -1;
		int right = -1;
		
		if(root.left != null) {
			left = root.left.height;
			assert(root.key > root.left.key);
		}
		
		if(root.right != null)
			right = root.right.height;
		
		System.out.println(left);
		System.out.println(root.height);
		System.out.println(right);
		
		assert(root.height == 1 + Math.max(left, right));
		assert(Math.abs(left - right) <= 1);
		
		verifyAVLTree(root.left, min, root.key);
		verifyAVLTree(root.right, root.key, max);
	}
}
