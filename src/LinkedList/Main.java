package LinkedList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
      for (int i=0; i<10000; i++) {
         ll.add(i);
      }

      long startTime = System.currentTimeMillis();
      ll.reverse();
      System.out.println((System.currentTimeMillis() - startTime));
      startTime = System.currentTimeMillis();
      ll.reverse2();
      System.out.println((System.currentTimeMillis() - startTime));
   }
}
