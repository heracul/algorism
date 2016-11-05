package algorism.fibonacci;

import java.util.Scanner;

public class FibonacciSequence2 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = scan.nextInt();
		int a = 0;
		int b = 1;
		int c = 0;
		try{
			for(int i=0; i<cnt; i++) {
				c = a+b;
				a = b;
				b = c;
			}
			System.out.println(a);
		}finally{
			if(scan != null) {
				scan.close();
			}
		}
		
	}
}
