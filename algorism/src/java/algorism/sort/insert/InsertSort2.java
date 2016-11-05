package algorism.sort.insert;

import algorism.utils.BaseUtils;

public class InsertSort2 {

	public static void main(String[] args) {
		
		Integer[]arr = BaseUtils.getRandomIntegerArrayNoDup(1000, 1000);
		System.out.println("========= 난수발생 시작 ===========");
		BaseUtils.printLine(arr);
		System.out.println("========= 난수발생 끝   ===========");
		long startTime = System.currentTimeMillis();
		InsertSort2 is = new InsertSort2();
		is.insertSort(arr);
		long endTime = System.currentTimeMillis();
		BaseUtils.printElapseTime(startTime, endTime);
		System.out.println("========= 정렬완료 ===========");
		BaseUtils.printLine(arr);
		
	}
	
	public void insertSort(Integer[]arr) {
		int base = 0;
		int index = 0;
		for(int i=1; i<arr.length; i++) {
			index = i;
			if(arr[i] == null)continue;
			base = arr[i];
			
			while(index > 0 && base < arr[index-1]) {
				arr[index] = arr[index-1];
				index--;
			}
			arr[index] = base;
		}
	}
}
