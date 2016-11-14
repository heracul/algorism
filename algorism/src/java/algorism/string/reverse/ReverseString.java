package algorism.string.reverse;

public class ReverseString {

	/**
	 * 단어단위의 reverse
	 * @param args
	 */
	public static void main(String[] args) {
		String textMix = "SK C&C 플랫폼기술팀 박세일입니다.";
		
		char[]cArr = textMix.toCharArray();
		StringBuilder sb = new StringBuilder();
		for(int i=cArr.length-1; i>=0; i--) {
			sb.append(cArr[i]);
		}
		System.out.print("역순출력 : ");
		System.out.println(sb.toString());
		
		
	}

}
