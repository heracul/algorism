package algorism.compare;

public class ImplComparable {

	public void doSort(String str1, String str2) {
		int diff = str1.compareTo(str2);
		if( diff > 0 ) {
			System.out.println("str2 longer than str1");
		} else  if(diff == 0 ) {
			System.out.println("str2 same to str1");
		} else {
			System.out.println("str2 smaller than str1");
		}
	}
}
