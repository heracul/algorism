package algorism.compare;

import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import algorism.utils.BaseUtils;
public class ArraySortTest {
	
	
	@BeforeClass
	public static void setUp() {
	}
	
	@Test
	public void sortIntTest() {
		HashMap map = new HashMap();
		ArraySort ic = new ArraySort();
		Integer[] randomInt = BaseUtils.getRandomIntegerArrayNoDup(10, 10);
		Integer[] sortedInt = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		System.out.print("before:");
		BaseUtils.printLine(randomInt);
		ic.sortInts(randomInt);
		System.out.print("after:");
		BaseUtils.printLine(randomInt);
		
		assertArrayEquals(sortedInt, randomInt);
	}
	
	@AfterClass
	public static void tearDown() {
		
	}

}
