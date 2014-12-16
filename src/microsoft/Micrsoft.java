package microsoft;

public class Micrsoft {
	
	public static void main(String[] args) {
		
	}
	
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
