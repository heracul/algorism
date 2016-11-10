package algorism.search.dfs;

import java.util.Scanner;


public class DepthFirstSearch {

	static int nE;
    static int nV;
 
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        nV = scan.nextInt();
        nE = scan.nextInt();
        int[][] ad = new int[nV+1][nV+1]; // Vertex의 이름을 그대로 사용하기 위해 (nV+1)(nV+1)개만큼 배열 생성
        
        for(int i = 0; i < nE; i++){
            int t1 = scan.nextInt();
            int t2 = scan.nextInt();
            ad[t1][t2] = ad[t2][t1] = 1;  // 1대신 가중치를 넣으면 가중치 그래프 
        }
    }

}
