public class Island {
	
	public static void main(String[] args) {
		
	}
	
	private int[][] Island;
	
	public static int getBlackPixels(int[][] map) {
		int count = 0;
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++)
				count += getBlackPixels(null, -1, -1);
		}
		return count;
	}
	
	private static int getBlackPixels(int[][] pictures, int curX, int curY) {
		return -1;
	}
}
