package algorism.anagram;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CompareAnagram {

	public static boolean doCompare(String str1, String str2) {
		char[]char1 = str1.toCharArray();
		char[]char2 = str2.toCharArray();
		boolean canDo = false;
		if(str1.length() == str2.length()) {
			Arrays.sort(char1);
			Arrays.sort(char2);
			for(int i=0; i<char1.length; i++) {
				if(char1[i]==char2[i]) {
					canDo = true;
				} else {
					canDo = false;
				}
			}
		} else {
			return false;
		}
		return canDo;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int cnt = scan.nextInt();
		List<String> strArray1 = new ArrayList<String>();
		List<String> strArray2 = new ArrayList<String>();
		
		for(int i=0; i< cnt; i++) {
			strArray1.add(scan.next());
			strArray2.add(scan.next());
			
		}
		
		for(int i=0; i<cnt; i++) {
			if(CompareAnagram.doCompare(strArray1.get(i), strArray2.get(i))) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			};
		}
		
	}

}
