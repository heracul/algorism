package kkb.exam.comparator;

import java.util.Comparator;
import java.util.Map;

/**
 * Map에 Value에 대한 정렬을 수행하기 위한 Comparator클래스
 * @author 08158
 *
 */
public class ValueComparator implements Comparator<Object> {
	Map<String, Integer> nameMap = null;

	public ValueComparator(Map<String, Integer> nameMap) {
		this.nameMap = nameMap;
	}

	public int compare(Object key1, Object key2) {
		if (key1 instanceof String && key2 instanceof String) {
			if (nameMap.get(key1) <= nameMap.get(key2)) {
				return 1;
			} else {
				return -1;
			}
		}
		return -1;
	}
}
