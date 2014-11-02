package dictionary;

public class Dictionary {
	
	private Node root;
	
	public Dictionary() {
		root = new Node("Root");
	}
	
	public void insert(String word, String def) {
		root = insertHelper(root, word, def);
	}
	
	private Node insertHelper(Node root, String word, String def) {
		
		if(word.length() == 0)
			return new Node(def);
		
		if (root.children[word.charAt(0) - 'a'] == null)
			root.children[word.charAt(0) - 'a'] = new Node("");
		
		root.children[word.charAt(0) - 'a'] = insertHelper(root.children[word.charAt(0) - 'a'], 
															word.substring(1, word.length()), def);
		return root;
	}
   
   
   public static void main(String[] args) {
      Dictionary d = new Dictionary();
      d.insert("a", "A small animal with legs");
   }
}
