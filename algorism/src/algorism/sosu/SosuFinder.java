package algorism.sosu;

import java.util.Scanner;
import java.util.TreeSet;

public class SosuFinder {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		TreeSet<Integer> sosuSet = new TreeSet<Integer>();
		TreeSet<Integer> exceptSet = new TreeSet<Integer>();
		int start = scan.nextInt();
		int max = scan.nextInt();
		
		boolean isSosu = true;
		try {
			for(int base=start; base<=max; base++ ) {
				isSosu = true;
				for(int i=1; i<=base; i++) {
					if(base%i == 0) {
						if(i!=1 && i!=base) {
							isSosu = false;
							break;
						} 
					} 
				}
				if(isSosu) {
					if(base != 1) {
						sosuSet.add(base);
					}
				}
			}
		}finally {
			if(scan != null) {
				scan.close();
			}
		}
		
		
		System.out.println(sosuSet);
		
		
	}

}
