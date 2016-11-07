package algorism.sort.merge;

import algorism.utils.BaseUtils;

public class MergeSort {

	public static void doMergeSort(Integer[]arrayInt) {
		if(arrayInt.length > 1) {
			int halfSize = arrayInt.length/2;
			int anotherHalf = arrayInt.length - halfSize;
			
			Integer[]divideArray1 = new Integer[halfSize];
			Integer[]divideArray2 = new Integer[anotherHalf];
			
			for(int i=0; i<halfSize; i++) {
				divideArray1[i] = arrayInt[i];
			}
			
			for(int i=halfSize; i<arrayInt.length; i++) {
				divideArray2[i-halfSize] = arrayInt[i];
			}
			doMergeSort(divideArray1);
			doMergeSort(divideArray2);
			//여기까지 분할수
			
			//여기서부터는 다시 정렬후병합 
			int i=0,j=0,k = 0;
			
			while(divideArray1.length != j && divideArray2.length !=k) {
				if(divideArray1[j] < divideArray2[k]) {
					arrayInt[i] = divideArray1[j];
					i++;
					j++;
				} else {
					arrayInt[i] = divideArray2[k];
					i++;
					k++;
				}
			}	
			while(divideArray1.length != j) {
				arrayInt[i] = divideArray1[j];
				i++;
				j++;
			}
			
			while(divideArray2.length != k) {
				arrayInt[i] = divideArray2[k];
				i++;
				k++;
			}
		}
	}
	
	public static void main(String[] args) {
		Integer[]arrayInt = BaseUtils.getRandomIntegerArrayNoDup(50000, 100000);
//		System.out.print("Before : " );
//		BaseUtils.printLine(arrayInt);
		long startTime = System.currentTimeMillis();
		MergeSort.doMergeSort(arrayInt);
		long endTime = System.currentTimeMillis();
		BaseUtils.printElapseTime(startTime, endTime);
//		System.out.print("After  : ");
//		BaseUtils.printLine(arrayInt);
	}

}
