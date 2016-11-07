package algorism.compare;

import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class ImplComparableTest {
	private static ImplComparable ic;
	
	private static ImplComparable getIc() {
		if(ic == null) {
			ic = new ImplComparable();
		}
		return ic;
	}

	@BeforeClass
	public static void setUp() {
		getIc();
	}

	@Test
	public void testDoSort() {
		String str1 = "Never give up";
		String str2 = "Nevada triangle area";
		ic.doSort(str1, str2);
		
	}

}
