package algorism.sort.insert;

public class InsertSort2 {

	public static void main(String[] args) {
		int[]arr = {2,3,10,9,23,5,7,13,49,32,18,22};
		InsertSort2 is = new InsertSort2();
		System.out.print("before : ");
		printLine(arr);
		is.insertSort(arr);
	}
	
	public void insertSort(int[]arr) {
		int base = 0;
		int index = 0;
		for(int i=1; i<arr.length; i++) {
			index = i;
			base = arr[i];
			while(index > 0 && base < arr[index-1]) {
				arr[index] = arr[index-1];
				index--;
				printLine(arr);
			}
			arr[index] = base;
			printLine(arr);
		}
		System.out.print("after : ");
		printLine(arr);
	}
	
	private static void printLine(int[]arr) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println("");
	}

}
