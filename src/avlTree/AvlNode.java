package avlTree;

/**
 * This is a node class for AVL tree. I intentionally leave the height to be zero by default.
 * height use as part of rotation.
 */
public class AvlNode {
	public int key;
	public int height;
	public AvlNode left;
	public AvlNode right;
	
	public AvlNode(int key) {
		this(key, null, null);
	}
	
	// comment
	public AvlNode(int key, AvlNode left, AvlNode right) {
		this.key = key;
		this.left = left;
		this.right = right;
		height = 0;
	}
}
