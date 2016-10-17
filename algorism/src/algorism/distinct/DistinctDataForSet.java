package algorism.distinct;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class DistinctDataForSet {

	public static void main(String[] args) {
		int[] randomInt = {1,3,5,24,7,3,3,10,78,34,39,95,54,12,32,8,94,61,67,87,77,39,12,11,73,74,27,30};
		
		SortedSet<Integer> set = new TreeSet<Integer>(init(randomInt));
		
		System.out.println(set);
	}
	
	public static List<Integer> init(int[]intArray) {
		List<Integer> list = new ArrayList<Integer>();
		for(int temp : intArray) {
			list.add(temp);
		}
		return list;
	}

}
