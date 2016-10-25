package algorism.fibonacci;

import java.util.Scanner;

public class FibonacciSequence {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = scan.nextInt();
		try {
			System.out.print(doSum(cnt));
		}finally {
			if(scan != null) {
				scan.close();
			}
		}
	}
	
	private static int doSum(int num) {
		if(num==0)return 0;
		else if(num == 1) return 1;
		else {
			return doSum(num-1)+doSum(num-2);
		}
	}

}
