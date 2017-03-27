package algorism.compare;

import java.util.Arrays;
import java.util.Comparator;

import algorism.utils.BaseUtils;

public class ArraySort {

	public void sortInts(Integer[] arrayInt) {
		Arrays.sort(arrayInt);
	}
	
	public Character[] sortByCase(String str) {
		char[] cArr = str.toCharArray();
		Character[]characterArr = new Character[cArr.length];
		for(int i=0; i<cArr.length; i++) {
			characterArr[i] = cArr[i];
		}
		
		Arrays.sort(characterArr, new Comparator<Character>() {
			
			@Override
			public int compare(Character c1, Character c2) {
				char tempC1 = c1.charValue();
				char tempC2 = c2.charValue();
				
				if(tempC1 == tempC2) {
					return 0;
				} else {
					if(Character.toUpperCase(tempC1) > Character.toUpperCase(tempC2)) {
						return 1;
					} else if(Character.toUpperCase(tempC1) < Character.toUpperCase(tempC2)) {
						return -1;
					} else {
						if(Character.isLowerCase(tempC1)) {
							return -1;
						} else {
							return 1;
						}
					}
				}
			}
		});
		return characterArr;
	}
	
	public static void main(String[] args) {
		ArraySort as = new ArraySort();
		BaseUtils.printLine(as.sortByCase("dEacACDe"));
	}
}
