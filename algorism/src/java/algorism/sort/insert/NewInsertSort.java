package algorism.sort.insert;

import java.util.LinkedList;

import algorism.utils.BaseUtils;

public class NewInsertSort {

	public static LinkedList<Integer> doInsertSort(Integer[]arrInt) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		originalList : for(Integer intVal : arrInt) {
			for(int i=0; i<list.size(); i++) {
				if(list.get(i) > intVal) {
					list.add(i, intVal);
					continue originalList;
				}
			}
			list.add(list.size(), intVal);
		}
		return list;
	}
	
	public static void main(String[] args) {
		NewInsertSort nis = new NewInsertSort();
		Integer[]arrInt = BaseUtils.getRandomIntegerArrayNoDup(20, 20);
		System.out.println("Before : ");
		BaseUtils.printLine(arrInt);
		long startTime = System.currentTimeMillis();
		LinkedList<Integer> sortedList = nis.doInsertSort(arrInt);
		long endTime = System.currentTimeMillis();
		BaseUtils.printElapseTime(startTime, endTime);
		BaseUtils.printLine(sortedList.toArray());
		
	}
}
