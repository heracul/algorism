package algorism.sort.bubble;

import algorism.utils.BaseUtils;

public class BubbleSort {

	public static void main(String[] args) {
		Integer[]arr = BaseUtils.getRandomIntegerArrayNoDup(50, 100);
		BubbleSort bs = new BubbleSort();
		System.out.print("before : ");
		BaseUtils.printLine(arr);
		bs.bubbleSort(arr);
	}

	public Integer[] bubbleSort(Integer[]arr) {
		int temp = 0;
		for(int i=arr.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(arr[j] ==null || arr[j+1] == null) continue;
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
		System.out.print("after : ");
		BaseUtils.printLine(arr);
		return arr;
	}
}
