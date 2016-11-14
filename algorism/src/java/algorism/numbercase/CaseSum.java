package algorism.numbercase;

import java.util.Scanner;

public class CaseSum {

	static int[] result;
    static int[] coin;
    static int n, k;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        k = Integer.parseInt(scan.nextLine().trim());

        result = new int[k + 1];
        coin = new int[n];

        for (int i = 0; i < coin.length; i++) {
            coin[i] = Integer.parseInt(scan.nextLine().trim());
        }
        coinDP();
        System.out.println(result[k]);
    }

    static public void coinDP() {
        result[0] = 1;
        for (int j = 0; j < coin.length; j++) {
            for (int i = 1; i < k + 1; i++) {
                if (coin[j] <= i) {
                    result[i] = result[i] + result[i - coin[j]];
//                	printLine(result);
                }
            }
        }
    }
    
    public static void printLine(int[]intArray) {
    	for(int i : intArray) {
    		System.out.print(i+" ");
    	}
    	System.out.println();
    		
    }

}
