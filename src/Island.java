public class Island {
	
	// only running island problem
	public static void main(String[] args) {
		int[][] pic = {{1, 1, 1}, {0, 0, 0}, {0, 0, 1}};
		
		System.out.println(getIslands(pic));
	}
	
	public static int getIslands(int[][] map) {
		// keeping track of the count 
		int count = 0;
		boolean[][] path = new boolean[map.length][map[0].length];
		for(int i = 0; i < map.length; i++) {
			for(int j = 0; j < map[0].length; j++)
				count += getIslands(map, path, i, j);
		}
		return count;
	}
	
	private static int getIslands(int[][] map, boolean[][] path, int curX, int curY) {
		
		// avoid stepping into negative zone
		if(curX < 0 || curY < 0)
			return 0;
		
		// check if we've been there before using path & weather or not if we bout
		// to step outside of the boundary.
		int x = map.length;
		int y = map[0].length;
		if ((curX < x && curY < y) && !path[curX][curY]) {
			if (map[curX][curY] == 1) {
				path[curX][curY] = true;
				getIslands(map, path, curX, curY + 1);	// up
				getIslands(map, path, curX, curY - 1);	// down
				getIslands(map, path, curX + 1, curY);	// right
				getIslands(map, path, curX - 1, curY);	// left
				
				getIslands(map, path, curX + 1, curY + 1);	// up right 
				getIslands(map, path, curX - 1, curY + 1);	// up left
				getIslands(map, path, curX + 1, curY - 1);	// down right 
				getIslands(map, path, curX - 1, curY - 1);	// down left
				return 1;
			}
		}
		
		// bad things happen return 0
		return 0;
	}
}
