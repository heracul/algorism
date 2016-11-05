package algorism.sort.quick;

import algorism.utils.BaseUtils;

public class QuickSort {

	public static void main(String[] args) {
		
		Integer[] intArray = BaseUtils.getRandomIntegerArrayNoDup(10000, 15000);
		System.out.println("========= 난수발생 시작 ===========");
		BaseUtils.printLine(intArray);
		System.out.println("========= 난수발생 끝   ===========");
		long startTime = System.currentTimeMillis();
		
		QuickSort qs = new QuickSort();
		qs.quickSort(intArray, 0, intArray.length - 1);
		long endTime = System.currentTimeMillis();
		
		BaseUtils.printElapseTime(startTime, endTime);

		System.out.println("========= 정렬완료 ===========");
		BaseUtils.printLine(intArray);

	}

	private void quickSort(Integer[]intArray, int l, int r) {
		int left = l;
		int right = r;
		int pivot = intArray[(left+right)/2];
		int temp = 0;
		while(left <= right) {
			while(intArray[left] < pivot) {
				left++;
			}
			while(intArray[right] > pivot) {
				right--;
			}
			if(left <= right) {
				temp = intArray[left];
				intArray[left] = intArray[right];
				intArray[right] = temp;
				left++;
				right--;
			}
		}
		if(l < right) quickSort(intArray, l, right);
		if(r > left) quickSort(intArray, left, r);
	}
}
