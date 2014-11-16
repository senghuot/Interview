package parallel;

public class Main {

	public static void main(String[] args) {
		System.out.println("Parallel starts here:");
		
		int[] arr = new int[100000000];
		for (int i = 0; i < 100000000; i++)
			arr[i] = i + 1;
	
		Sum s = new Sum(arr, 0, 100000000);
		System.out.println(s.sumArray(arr));
		

	}
}
