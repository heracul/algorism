package algorism.sosu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import algorism.utils.BaseUtils;

public class PrimeFinder {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			int start = scan.nextInt();
			int end = Integer.parseInt(scan.nextLine().trim());
			long startTime = System.currentTimeMillis();
			findPrime(start, end);
			long endTime = System.currentTimeMillis();
			BaseUtils.printElapseTime(startTime, endTime);
		}finally {
			if(scan != null) {
				scan.close();
			}
		}
	}

	private static void findPrime(int start, int end) {
		List<Integer> primeList = new ArrayList<Integer>();
		primeList.add(2);
		for(int i=3; i<end;i++) {
			for(int j=0; j<primeList.size(); j++) {
				if(i%primeList.get(j) == 0) {
					break;
				} 
				if(j+1 == primeList.size()) {
					primeList.add(i);
				}
			}
		}
		for(Integer sosu : primeList) {
			System.out.println(sosu + " ");
		}
		System.out.println("소수의 수  :" +primeList.size());
	}

}
