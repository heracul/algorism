package algorism.utils;

import java.util.HashSet;
import java.util.Random;

public class BaseUtils {

	/**
	 * @param totalCount 전체 배열의 건수 
	 * @param figures 난수의 최대 자릿수
	 * @return
	 */
	public static int[] getRandomIntArray(int totalCount, int figures) {
		Random random = new Random();
		int[] intArray = new int[totalCount];
		for(int i=0; i<totalCount; i++) {
			intArray[i] = random.nextInt(figures);
		}
		return intArray;
	}
	
	public static Integer[] getRandomIntArrayNoDup(int totalCount, int figures) {
		Random random = new Random();
		Integer[] intArray = new Integer[totalCount];
		HashSet<Integer> hashSet = new HashSet<Integer>();
		for(int i=0; i<totalCount; i++) {
			hashSet.add(random.nextInt(figures));
		}
		hashSet.toArray(intArray);
		return intArray;
	}
	
	/**
	 * 라인출력. 개행없음.
	 * @param objArr
	 */
	public static void printLine(Object[]objArr) {
		for(Object obj : objArr) {
			if(obj instanceof Integer) {
				System.out.print(((Integer)obj).intValue()+" ");
			}
		}
		System.out.println("");
	}
}
