package kkb.exam.comparator;

import java.util.Comparator;
import java.util.Map;

public class ValueComparator implements Comparator<String> {
	Map<String, Integer>nameMap = null;
	public ValueComparator(Map<String, Integer> nameMap) {
	        this.nameMap = nameMap;
	    }
	public int compare(String key1, String key2) {
		if(nameMap.get(key1) <= nameMap.get(key2)) {
			return 1;
		} else {
			return -1;
		}
	}
}
