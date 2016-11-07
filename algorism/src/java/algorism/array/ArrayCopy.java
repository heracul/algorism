package algorism.array;

import java.util.ArrayList;
import java.util.LinkedList;

import algorism.utils.BaseUtils;

public class ArrayCopy {

	public static void main(String[] args) {
		Integer[]arrayInt = BaseUtils.getRandomIntegerArrayNoDup(20, 20);
		System.out.println("Origin :");BaseUtils.printLine(arrayInt);
		Integer[]copyArray = new Integer[10];
		
		System.arraycopy(arrayInt, 0, copyArray, 0, 10);
		System.out.println("Copy :");BaseUtils.printLine(copyArray);
		
		ArrayList arrayList = new ArrayList();
		LinkedList linkedList = new LinkedList();
	}

}
