package algorism.compare;

import java.util.Comparator;

public class ImplComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		
		return o1-o2;//오름차순
	}
	
}
