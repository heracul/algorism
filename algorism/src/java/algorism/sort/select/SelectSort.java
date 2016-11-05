package algorism.sort.select;

import algorism.utils.BaseUtils;

public class SelectSort {

	public static void main(String[] args) {
		Integer[]arr = BaseUtils.getRandomIntegerArrayNoDup(50, 100);
		SelectSort ss = new SelectSort(); 
		System.out.print("before : ");
		BaseUtils.printLine(arr);
		ss.selectSort(arr);
	}
	
	public void selectSort(Integer[]arr) {
		int temp = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i] ==null ) continue;
			for(int j=i+1; j<arr.length; j++ ) {
				if(arr[j] ==null ) continue;
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		System.out.print("after : ");
		BaseUtils.printLine(arr);
	}
	
	private static void printLine(int[]arr) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println("");
	}

}
