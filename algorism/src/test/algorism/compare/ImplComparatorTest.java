package algorism.compare;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import org.junit.BeforeClass;
import org.junit.Test;

import algorism.utils.BaseUtils;

public class ImplComparatorTest {
	private static ImplComparator ic;
	
	
	@BeforeClass
	public static void setup() {
		if(ic==null) {
			ic = new ImplComparator();
		}
	}

	@Test
	public void testCompare() {
		Integer[] arrInt1 = BaseUtils.getRandomIntegerArrayNoDup(10, 20);
		Integer[] expectedArr = null;
		System.out.print("before : ");
		BaseUtils.printLine(arrInt1);
		Collections.sort(Arrays.asList(arrInt1), ic);
		
		System.out.print("after : ");
		BaseUtils.printLine(arrInt1);
	}

}
