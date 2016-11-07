package algorism.sort.quick;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import algorism.utils.BaseUtils;

public class NewQuickSort {

	public static List<Integer> doQuickSort(List<Integer>numberList) {
		if(numberList.size() < 2) return numberList;
		
		final int pivot = numberList.get(0);
		final List<Integer>lowerList = new ArrayList<Integer>();
		final List<Integer>higherList = new ArrayList<Integer>();
		
		for(int i=1; i<numberList.size(); i++) {
			if(numberList.get(i) < pivot) {
				lowerList.add(numberList.get(i));
			} else {
				higherList.add(numberList.get(i));
			}
		}
		
		final List<Integer>sortedList = doQuickSort(lowerList);
		sortedList.add(pivot);
		sortedList.addAll(doQuickSort(higherList));
		return sortedList;
	}
	
	public static void main(String[] args) {
		NewQuickSort nqc = new NewQuickSort();
		Integer[]intArray = BaseUtils.getRandomIntegerArrayNoDup(50, 50);
		List<Integer> intList = Arrays.asList(intArray);
		System.out.print("Before :");
		BaseUtils.printLine(intArray);
		long startTime = System.currentTimeMillis();
		List<Integer>sortedList = nqc.doQuickSort(intList);
		long endTime = System.currentTimeMillis();
		BaseUtils.printElapseTime(startTime, endTime);
		System.out.print("After : ");
		BaseUtils.printLine(sortedList.toArray());
	}
}
