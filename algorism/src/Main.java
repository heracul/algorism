import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = scan.nextInt();
		long a = 0;
		long b = 1;
		long c = 0;
		try{
			for(int i=0; i<cnt; i++) {
				c = a+b;
				a = b;
				b = c;
			}
			System.out.println((a%1000000));
		}finally{
			if(scan != null) {
				scan.close();
			}
		}
	}
}