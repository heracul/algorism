package algorism.sum;

import java.util.Scanner;

public class SumNumber {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int maxNum = scan.nextInt();
			System.out.println(doSum(maxNum));
		}finally {
			if(scan != null) {
				scan.close();
			}
		}
	}
	
	public static int doSum(int maxNum) {
		if(maxNum % 2 == 0) {
			return (maxNum+1)*(maxNum/2);
		} else {
			return doSum(maxNum-1)+maxNum;
		}
	}

}
