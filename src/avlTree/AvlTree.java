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
		
		assert(root.height == 1 + Math.max(left, right));
		assert(Math.abs(left - right) <= 1);
		
		verifyAVLTree(root.left, min, root.key);
		verifyAVLTree(root.right, root.key, max);
	}
   
   
   // check if the tree is balanced. balanced tree define to have left and right
   // subtree height differ by at most 1 
   public boolean balance() {
      return balanceHelper(root);
   }
   
   // balance helper method
   private boolean balanceHelper(AvlNode root) {
   
      if (root == null)
         return true;
         
      int diff = heightHelper(root.left) - heightHelper(root.right);
      if (Math.abs(diff) > 1)
         return false;
         
      return balanceHelper(root.left) && balanceHelper(root.right);
   }
   
   // helper method to find the height.
   private int heightHelper(AvlNode root) {
      if(root == null)
         return 0;
         
      int left = 1 + heightHelper(root.left);
      int right = 1 + heightHelper(root.right);
      return Math.max(left, right);
           
   }
}
