package algorism.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
	
	public static Integer[] getRandomIntegerArrayNoDup(int totalCount, int figures) {
		Random random = new Random();
		Integer[] intArray = null;
		List<Integer> list = new ArrayList<Integer>();
		int temp =0;
		for(int i=0; i<totalCount; i++) {
			temp = random.nextInt(figures);
			if(!list.contains(temp)) {
				list.add(temp);
			} else {
				i--; //중복된 건수만큼 재처리해야 전체 건수에 맞출 수 있음. 
			}
		}
		intArray = new Integer[list.size()];
		list.toArray(intArray);
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
	
	public static void printElapseTime(long startTime, long endTime) {
		System.out.println((endTime-startTime)+"ms 소요되었습니다. ");
		
	}
	
	public static String getKeyboardInput(BufferedReader br) {
		br = new BufferedReader(new InputStreamReader(System.in));
		String inputParameter = "";
		try {
			inputParameter = br.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return inputParameter;
	}
	
	public static void closeBufferedReader(BufferedReader br) {
		try {
			if(br != null) {
				br.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
