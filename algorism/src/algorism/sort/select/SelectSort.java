package algorism.sort.select;

public class SelectSort {

	public static void main(String[] args) {
		int[]arr = {2,3,10,9,23,5,7,13,49,32,18,22};
		SelectSort ss = new SelectSort(); 
		ss.selectSort(arr);
	}
	
	public void selectSort(int[]arr) {
		int temp = 0;
		
		for(int i=0; i<arr.length-1; i++) {
			printLine(arr);
			for(int j=i+1; j<arr.length; j++ ) {
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
					printLine(arr);
				}
			}
		}
		printLine(arr);
	}
	private void printLine(int[]arr) {
		for(int i : arr) {
			System.out.print(i+" ");
		}
		System.out.println("");
	}

}
