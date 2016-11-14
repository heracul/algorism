package algorism.count.repeatstr;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class CountRepeatStr {

	private static final TreeMap<Character, Integer>strMap = new TreeMap<Character, Integer>();
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			String str1 = scan.nextLine();
			countRepeatStr(str1);
			prtNoRepeatLetter(str1);
		}finally{
			if(scan != null) {
				scan.close();
			}
		}
	}
	
	public static void countRepeatStr(String str1) {
		if(str1 == null || str1.isEmpty()) {
			return;
		}
		char[] charArray = str1.toCharArray();
		for(char cha : charArray) {
			if(null ==strMap.get(cha)) {
				strMap.put(cha, 1);
			} else {
				strMap.put(cha, strMap.get(cha)+1);
			};
		}
	}
	
	public static void prtNoRepeatLetter(String str1) {
		Set<Character> keySet = strMap.keySet();
		int firstIndex = str1.length();
		for(char c : keySet) {
			if(1==strMap.get(c)) {
				if(str1.indexOf(c) < firstIndex) {
					firstIndex = str1.indexOf(c);
				}
			}
		}
		System.out.println(str1.charAt(firstIndex));
		
	}

}
