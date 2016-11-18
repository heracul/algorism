package kkb.exam.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import kkb.exam.constants.CommonSpec;
import kkb.exam.constants.ResourceSpec;
import kkb.exam.manager.IFinderManager;
import kkb.exam.manager.impl.NameFinderManager;
import kkb.exam.utils.FinderUtils;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
		BufferedReader br = null;
				
		Map<String, Integer> nameMap = new HashMap<String, Integer>();
		TreeMap<String, Integer> keySortedNameMap = null;
		TreeMap<String, Integer> valSortedNameMap = null;
		ValueComparator vb = new ValueComparator(nameMap);
		try {
			long startTime = System.currentTimeMillis();
			String s = null;
			int lineCnt = 0;
			br = new BufferedReader(new FileReader(csvFile));
			while((s=br.readLine()) != null) {//라인별 read
				fm.findWord(s, nameMap);
				lineCnt++;
			}
			keySortedNameMap = new TreeMap<String, Integer>(nameMap);
			valSortedNameMap = new TreeMap<String, Integer>(vb);
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
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {}
			}
		}
	}
}
class ValueComparator implements Comparator<String> {
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
