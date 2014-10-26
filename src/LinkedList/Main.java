package LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.add(1);
		ll.add(2);
		ll.add(2);
		ll.add(10);
		ll.add(11);
		ll.removeDuplicate();
		System.out.println(ll);
	}

}
