package algorism.search.dijkstra;

import java.util.Stack;

public class DijkstraSearch {
	static int inf = 99999; // 무한대 값
    public static void main(String[] args) {
        int[][] weightMatrix = { 
                //  0    1    2    3    4    5    6
        /* 0 */ {   0,   7, inf, inf,   3,  10, inf},
        /* 1 */ {   7,   0,   4,  10,   2, inf, inf},
        /* 2 */ { inf,   4,   0,   2, inf,   6, inf},
        /* 3 */ { inf,  10,   2,   0,  11,   9,   4},
        /* 4 */ {   3,   2, inf,  11,   0, inf,   5},
        /* 5 */ {  10, inf,   6,   9, inf,   0, inf},
        /* 6 */ { inf, inf, inf,   4,   5, inf,   0}
        };
        dikstra(weightMatrix, 3, 4); // 0 부터 3까지 최단거리
    }
     
    public static void dikstra(int[][] graph, int start, int end) {
        int vCount = graph[0].length; // 정점의 수
        boolean[] isVisits = new boolean[vCount]; // 방문 배열
        int[] distance = new int[vCount]; // 거리배열
        int[] historyPath = new int[vCount]; // 히스토리 배열
 
        int nextVertex = start; // distance 배열의 최소값의 정점
        int min = 0; // distance 배열의 최소값
        // 초기화
        for (int i = 0; i < vCount; i++) {
            isVisits[i] = false; // 방문 한 곳 없다고 초기화
            distance[i] = inf; // 전부 다 무한대로 초기화
            historyPath[i] = inf; // 전부 다 무한대로 초기화
        }
        distance[start] = 0; // 시작점 0 으로 초기화
 
        // 다익스트라 실행
        while (true) {
            min = inf; // 최소값을 infinity 초기화
            for (int j = 0; j < vCount; j++) {
                if (isVisits[j] == false && distance[j] < min) { // 가장 먼저 방문했던
                                                                    // 노드는 제외한다,
                                                                    // 또한 최소값을
                                                                    // 찾기위한
                                                                    // 조사(선택정렬을
                                                                    // 생각하면 된다.)
                    nextVertex = j; // 다음으로 이동할 정점 선택
                    min = distance[j]; // 다음으로 이동한 최소값
                }
            }
            if (min == inf)
                break; // 최소값이 infinity이면 모든 정점을 지났다는 것, 최소값이 모든 정점을 지났으면
                        // infinity
            isVisits[nextVertex] = true; // 다음으로 이동할 정점 방문
 
            for (int j = 0; j < vCount; j++) {
                int distanceVertex = distance[nextVertex]
                        + graph[nextVertex][j]; // 정점에서 방문한 다른 정점의 거리
                if (distance[j] > distanceVertex) // 정점에서 다른 정점에서의 거리가 distance
                                                    // 배열보다 적다면 교체해 준다.
                {
                    distance[j] = distanceVertex; // 교체해 준다.
                    historyPath[j] = nextVertex; // 교체 된다면 그 지점의 정점을 기록을 남긴다.
                }
            }
        }
 
        System.out.print(start + " 부터 " + "도착점 : " + end);
        System.out.println(" 최단거리 : " + distance[end]); // 최종에는 start 정점부터 모든
                                                        // 최단경로가 생성된다.
        printPath(historyPath, start, end);
    }
     
    public static void printPath(int[] historyPath, int start, int end) { // 경로계산
        Stack<Integer> path = new Stack<Integer>();
        int vertex = end; // 거꾸로 탐색한다.
        while (true) {
            path.push(vertex);
            if (vertex == start)
                break; // 시작점이면 리턴한다.
            vertex = historyPath[vertex]; // 탐색
        }
 
        System.out.print(start + " 부터 " + end + " 까지 경로는 : ");
        while (!path.isEmpty())
            // 출력
            System.out.print(" " + path.pop());
    }
}
