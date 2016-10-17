package algorism.replace.chracter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpecialChracterReplacer {

	public static void main(String[] args) {
		List<String> inputStrList = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
		String inputLine = "";
		char c = 20;
		long temp = 0l;
		try {
			for(int i=0; i<cases; i++) {
				inputLine = sc.next();
				if(!inputLine.isEmpty()) {
					for(int j=0; j<inputLine.toCharArray().length; j++) {
						c = inputLine.toCharArray()[j];
						if(inputLine.length() >=3 && c == '%') {
							temp = Long.parseLong(inputLine.substring(j+1, j+3), 16);
							inputLine = inputLine.replace(inputLine.substring(j, j+3), ((char)temp)+"");
						}
					}
					inputStrList.add(inputLine);
				}
			}
			
			for(String input : inputStrList) {
				System.out.println(input);
			}
		} finally {
			if(sc != null) {
				sc.close();
			}
		}
	}
}
