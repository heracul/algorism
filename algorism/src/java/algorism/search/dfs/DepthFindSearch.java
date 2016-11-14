package algorism.search.dfs;

public class DepthFindSearch {
	
	public static final int[][] map =  { 
											{ 1, 1, 1, 1, 1 }, 
											{ 1, 0, 1, 0, 1 },
											{ 1, 0, 1, 0, 1 }, 
											{ 1, 0, 1, 1, 1 },
											{ 1, 1, 1, 1, 1 }, 
											{ 1, 0, 0, 0, 0 },
											{ 1, 1, 1, 1, 1 }
											
										};
	
	private static final int xLength = map[0].length;
	private static final int yLength = map.length;
	private static int arriveX = 0;
	private static int arriveY = 0;
	private static int min = xLength*yLength;
	
	public static void findRoad(int x, int y, int distance) {
		if(x == arriveX-1 && y == arriveY-1) {
			if(distance < min) {
				min = distance;
				return;
			}
		}
		
		map[y][x] = 0;
		
		if(y>0 && map[y-1][x] != 0) findRoad(x, y-1, distance+1);
		if(y<yLength-1 && map[y+1][x] != 0) findRoad(x, y+1, distance+1);
		if(x>0 && map[y][x-1] != 0) findRoad(x-1, y, distance+1);
		if(x<xLength-1 && map[y][x+1] != 0) findRoad(x+1, y, distance+1);
		
		map[y][x] = 1;
	}
	
	public static void main(String[] args) {
		arriveX=5; arriveY=7;
		findRoad(0, 0, 1);
		System.out.println(map);
		System.out.println("총 거리는 : "+ min);
	}

}
