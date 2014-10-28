public class Island {
	
	// only running island problem
	public static void main(String[] args) {
		int[][] pic = {	{0,0,0,0},
					 	{1,0,0,1},
					 	{0,0,1,0},
					 	{1,0,0,0}};
		
		System.out.println(getIslands(pic));
	}
	
	public static int getIslands(int[][] map) {
		// keeping track of the count 
		int count = 0;
		boolean[][] path = new boolean[map.length][map[0].length];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++)
				count += getIslands(map, path, 0, 0);
		}
		return count;
	}
	
	private static int getIslands(int[][] map, boolean[][] path, int curX, int curY) {
		
		// check if we've been there before using path & weather or not if we bout
		// to step outside of the boundary.
		int x = map.length;
		int y = map[0].length;
		if () {
			
		}
	}
}
