package kkb.exam.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import kkb.exam.comparator.ValueComparator;
import kkb.exam.constants.CommonSpec;
import kkb.exam.constants.ResourceSpec;
import kkb.exam.manager.IFinderManager;
import kkb.exam.manager.impl.NameFinderManager;
import kkb.exam.utils.FinderUtils;

/**
 * Main클래스 
 * @author seilpark
 */
public class Apps {
	private static Logger log = LogManager.getLogger(Apps.class);
	
	public static void main(String[] args) {
		IFinderManager fm = new NameFinderManager();
//		IFinderManager fm = new KmrnNameFinderManager();
		String csvFilePath = ResourceSpec.BIN_PATH.getPath();
		File csvFile = new File(csvFilePath+CommonSpec.CSV_FILE_NAME.getName());//CSV파일취득 
				
		Map<String, Integer> nameMap = new HashMap<String, Integer>();
		TreeMap<String, Integer> keySortedNameMap = null;
		TreeMap<String, Integer> valSortedNameMap = null;
		ValueComparator vb = new ValueComparator(nameMap);
		FileReader fr = null;
		try {
			long startTime = System.currentTimeMillis();
			fr = new FileReader(csvFile);//csv파일의 처리를 위해 BufferedReader나 FileInputStream을 사용하지 않음. 
			int c = 0;
			StringBuilder sb = new StringBuilder();//동기화가 필요없기 때문에 StringBuffer대신 StringBuilder를 이용함. 
			int quatCnt = 0;
			while((c=fr.read()) != -1) {
				if(c == 34) {
					quatCnt++;
					if(quatCnt == 2) {
						fm.findWord(sb.toString(), nameMap, false);//구간에서 학교명에 대한 카운트를 한번만 수행할지 여부를 true, false로 정의한다. 
						sb = new StringBuilder();
						quatCnt = 0;
					} 
				} else {
					sb.append((char)c);
				}
			}
			
			keySortedNameMap = new TreeMap<String, Integer>(Collections.reverseOrder());//키값에 대한 내림차순 정렬을 위해 
			valSortedNameMap = new TreeMap<String, Integer>(vb);//value에 대한 커스텀 정렬 처리를 위해 
			keySortedNameMap.putAll(nameMap);
			valSortedNameMap.putAll(nameMap);
			
			File keySortedFile = new File("log/keySortedReport.log");
			File valSortedFile = new File("log/valSortedReport.log");
			FinderUtils.writeDataFile(keySortedNameMap, keySortedFile);//key기준으로 sort
			FinderUtils.writeDataFile(valSortedNameMap.entrySet(), nameMap, valSortedFile);//value기준으로 sort
			
			log.debug(nameMap);
			log.debug("총 건수 : "+nameMap.entrySet().size());
			long endTime = System.currentTimeMillis();
			log.debug("Elapse time  : "+(endTime-startTime)+"ms");
			
		} catch (FileNotFoundException e) {
			log.error("Don't have a file");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("Happened IOException!");
			e.printStackTrace();
		} finally {
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {}
			}
		}
	}
}

