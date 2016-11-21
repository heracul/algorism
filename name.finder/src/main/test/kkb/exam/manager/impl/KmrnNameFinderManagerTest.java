package kkb.exam.manager.impl;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class KmrnNameFinderManagerTest {

	public KmrnNameFinderManager kmrnManager;
	public String strLine;
	
	@Before
	public void setUp() throws Exception {
		kmrnManager = new KmrnNameFinderManager("C:\\Users\\08158\\git\\algorism\\name.finder\\src\\resources\\models", "user.dic.txt");
		strLine = "\"서울 구로구 개봉중학교 서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교"
				+ "서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교"
				+ "서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교"
				+ "서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교"
				+ "서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교"
				+ "서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교"
				+ "서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교"
				+ "서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교"
				+ "서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교서울구로구개봉중학교????????????????????\"";
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		boolean doDistinct = true;
		Map<String, Integer> nameMap = new HashMap<String, Integer>(); 
		kmrnManager.findWord(strLine, nameMap, doDistinct);
		System.out.println(nameMap.get("개봉중학교"));
		if(doDistinct) {
			assertEquals(1, nameMap.get("개봉중학교").intValue());
		} else {
			assertEquals(51, nameMap.get("개봉중학교").intValue());
		}
		
	}

}
