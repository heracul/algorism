package algorism.binary.search;

import java.util.Calendar;

import algorism.sort.bubble.BubbleSort;
import algorism.utils.BaseUtils;

public class BinarySearch {

	public static void main(String[] args) {
		BinarySearch binarySearch = new BinarySearch();
		long startTime = System.currentTimeMillis();
		Integer[] intArray = BaseUtils.getRandomIntegerArrayNoDup(100, 100);
		BubbleSort bs = new BubbleSort();
		intArray = bs.bubbleSort(intArray);
		int findInt = binarySearch.binarySearch(intArray, 57);
		long endTime = System.currentTimeMillis();
		System.out.println("찾고자 하는 변수 "+findInt+"를 찾는데"+ (endTime-startTime) +"(ms) 소요되었습니다.");
	}
	
	public int binarySearch(Integer [] arrInt, int findInt) {
		int high = arrInt.length-1;
		int low = 0;
		int mid = 0;
		
		while(high >= low) {
			mid = (high + mid) / 2;
			if(arrInt[mid]== null)continue;
			if(arrInt[mid] > findInt) {
				high = mid-1;
			} else if(arrInt[mid] < findInt) {
				low = mid+1;
			} else {
				return arrInt[mid];
			}
		}
		return -1;
	}

}
