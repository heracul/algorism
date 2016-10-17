package algorism.sort.bubble;

public class BubbleSort {

	public static void main(String[] args) {
		int[]arr = {2,3,10,9,23,5,7,13,49,32,18,22};
		BubbleSort bs = new BubbleSort();
		System.out.print("before : ");
		printLine(arr);
		bs.bubbleSort(arr);
	}

	public void bubbleSort(int[]arr) {
		int temp = 0;
		for(int i=arr.length-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if(arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
				System.out.print("Jfor :");
				printLine(arr);
			}
			System.out.print("Ifor :");
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
