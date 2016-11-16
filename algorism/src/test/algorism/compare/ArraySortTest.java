package algorism.compare;

import java.util.ArrayList;
import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
public class ArraySortTest {
	
	
	@BeforeClass
	public static void setUp() {
	}
	
	@Test
	public void sortIntTest() {
		People people1 = new People();
		People people2 = new People();
		People people3 = new People();
		
		ArrayList list = new ArrayList();
		list.add(people1);
		list.add(people2);
		list.add(people3);
		
		System.out.println(list.size());
		System.out.println("애드피플전 : "+list.hashCode());
		addPeople(list);
		System.out.println(list.size());
				
	}
	
	public void addPeople(List list) {
		list = new ArrayList();
//		list = createList(list);
		System.out.println("애들피플 중 : "+list.hashCode());
		System.out.println(list.size());
	}
	
	public List createList(List list) {
		ArrayList list1 = new ArrayList(list);
		People people1 = new People();
		list1.add(people1);
		return list1;
	}
	@AfterClass
	public static void tearDown() {
		
	}

	class People {
		String lastName;
		String firstName;
		int age;
	}
}
