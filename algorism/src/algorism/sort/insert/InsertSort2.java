package algorism.sort.insert;

import algorism.utils.BaseUtils;

public class InsertSort2 {

	public static void main(String[] args) {
		Integer[]arr = BaseUtils.getRandomIntegerArrayNoDup(50, 100);
		InsertSort2 is = new InsertSort2();
		System.out.print("before : ");
		BaseUtils.printLine(arr);
		is.insertSort(arr);
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
		System.out.print("after : ");
		BaseUtils.printLine(arr);
	}
}
