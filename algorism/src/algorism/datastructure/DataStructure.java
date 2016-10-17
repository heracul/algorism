package algorism.datastructure;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.Stack;
import java.util.TreeSet;

public class DataStructure {

	public static void main(String[] args) {
		int[] tempInt = {2,3,10,9,23,5,7,13,49,32,18,22};
		List<Integer> list1 = new LinkedList<Integer>();
		Stack<Integer> list2 = new Stack<Integer>();
		SortedSet<Integer>set1 = new TreeSet<Integer>();
		HashSet<Integer>set2 = new HashSet<Integer>();
		
		for(int i : tempInt) {
			list2.push(i);
			set1.add(i);
			set2.add(i);
		}
		
//		for(int i=0; i<list2.size(); i++) {
//			System.out.print(list2.peek()+" ");
//			list2.pop();
//		
//		}
		System.out.println(set1);
		System.out.println(set2);
//		Iterator<Integer> iter = set1.iterator();
//		while(iter.hasNext()) {
//			System.out.print(iter.next()+" ");
//			
//		}
		
		
	}

}
