package algorism.distinct;

import java.util.TreeSet;

public class DistinctDataForArray {
	public static void main(String[] args) {
		int[] randomInt = {1,3,5,24,7,3,3,10,78,34,39,95,54,12,32,8,94,61,67,87,77,39,12,11,73,74,27,30};
		TreeSet<Integer> set = new TreeSet<Integer>();
		for(int i=0; i<randomInt.length; i++) {
			set.add(randomInt[i]);
		}
		System.out.println(set);
		
	}
}
