package algorism.compare;

import java.util.Comparator;

public class StringCompare implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		return o1.compareTo(o2);
	}
	public static void main(String[] args) {
		String str1 = "abcdefg";
		String str2 = "ABCDEFG";
		StringCompare sc = new StringCompare();
		int returnVal = sc.compare(str1, str2);
		System.out.println(returnVal);
		if( returnVal == 0 ){
			System.out.println("동일합니다.");
		} else if(returnVal > 0) {
			System.out.println(str1+"가 "+str2+"에 비해 깁니다.");
		} else {
			System.out.println(str1+"가 "+str2+"에 비해 짧습니다.");
		};
	}
}
