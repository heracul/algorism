package algorism.sort.bubble;

import algorism.utils.BaseUtils;

public class BubbleSort2 {

	public static void doBubbleSort(Integer[]arrInt) {
		int temp = 0;
		boolean doNext = false;
		do {
			doNext = false;
			for(int i=0; i<arrInt.length-1; i++) {
				if(arrInt[i] > arrInt[i+1]) {
					temp  = arrInt[i];
					arrInt[i] = arrInt[i+1];
					arrInt[i+1] = temp;
					doNext = true;
				}
			}
		} while(doNext);
	}
	
	public static void main(String[] args) {
		Integer[] arrInt = BaseUtils.getRandomIntegerArrayNoDup(20, 20);
		System.out.println("Before : ");
		BaseUtils.printLine(arrInt);
		long startTime = System.currentTimeMillis();
		BubbleSort2.doBubbleSort(arrInt);
		long endTime = System.currentTimeMillis();
		BaseUtils.printElapseTime(startTime, endTime);
		System.out.println("After : ");
		BaseUtils.printLine(arrInt);
	}
}
