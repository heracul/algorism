package algorism.string.reverse;

import java.util.Scanner;

public class ReverseString2 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String readLine = scan.nextLine();
		String[]splitStr = readLine.split(" ");
		for(int i=splitStr.length-1; i>=0; i--) {
			System.out.print(splitStr[i]+" ");
		}
	}

}
