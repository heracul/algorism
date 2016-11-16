package algorism.search.bfs;

public class BreadthFirstSearch {

	public static final int[][] map =  { 
			{ 1, 1, 1, 1, 1 }, 
			{ 1, 0, 1, 0, 1 },
			{ 1, 1, 1, 1, 1 }, 
			{ 1, 0, 0, 0, 1 },
			{ 1, 0, 1, 1, 1 }, 
			{ 1, 0, 1, 0, 0 },
			{ 1, 1, 1, 1, 1 }
			
		};
	static int xLength=map[0].length;
	static int yLength=map.length;
	static int arriveX = 0;
	static int arriveY = 0;
	static int cnt=0;
	static int []x = new int[100]; 
	static int []y = new int[100];
	static int []distance = new int[100];
	
	public static void setQueue(int _x, int _y, int _distance) {
		x[cnt] = _x;
		y[cnt] = _y;
		distance[cnt] = _distance;
		cnt++;
	}
	
	public static void doSearch(int _x, int _y) {
		int pos = 0;
		setQueue(_x, _y, 1);//시작점의 좌표와 길이를 큐에 삽입한다.
		while(pos < cnt && (x[pos] != arriveX-1 || y[pos] != arriveY-1 )) {//더이상 방문할 지점이 없거나 도착지점에 도착하면 루프를 나온다.
			map[y[pos]][x[pos]] = 0; //두번 방문하면 안되기 때문에 지나온 길에 대해 표시를 한다. 
			if(y[pos] > 0 && map[y[pos]-1][x[pos]]==1) setQueue(x[pos], y[pos]-1, distance[pos]+1);//위로 갈수 있다
			if(y[pos] < yLength-1 && map[y[pos]+1][x[pos]]==1) setQueue(x[pos], y[pos]+1, distance[pos]+1);//아래로 갈수 있다면
			if(x[pos] > 0 && map[y[pos]][x[pos]-1]==1) setQueue(x[pos]-1, y[pos], distance[pos]+1); //왼쪽으로 갈 수 있다면
			if(x[pos] < xLength-1 && map[y[pos]][x[pos]+1]==1) setQueue(x[pos]+1, y[pos], distance[pos]+1);//오른쪽으로 갈 수 있다면 
			
//			map[y[pos]][x[pos]] = 1; 
			pos++;
		}
		
		if(pos < cnt) {
			System.out.println("최단거리는 : "+distance[pos]);
		}
	}
	
	public static void main(String[] args) {
		arriveX = 5;
		arriveY = 5;
		doSearch(0, 0);
	}

}
