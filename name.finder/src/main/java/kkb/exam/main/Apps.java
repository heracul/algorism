package kkb.exam.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import kkb.exam.comparator.ValueComparator;
import kkb.exam.constants.CommonSpec;
import kkb.exam.constants.ResourceSpec;
import kkb.exam.manager.IFinderManager;
import kkb.exam.manager.impl.KmrnNameFinderManager;
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
		boolean useKomoran = true;
		IFinderManager fm = null;
		String keySortedRptName = "";
		String valSortedRptName = "";
		if(useKomoran) {
			fm = new KmrnNameFinderManager("", "");
			keySortedRptName = "log/keySortedReport_komoran.log";
			valSortedRptName = "log/valSortedReport_komoran.log";
		} else {
			fm = new NameFinderManager();
			keySortedRptName = "log/keySortedReport.log";
			valSortedRptName = "log/valSortedReport.log";
		}
		String csvFilePath = ResourceSpec.BIN_PATH.getPath();
		File csvFile = new File(csvFilePath+CommonSpec.CSV_FILE_NAME.getName());//CSV파일취득 
				
		Map<String, Integer> nameMap = new HashMap<String, Integer>();
		TreeMap<String, Integer> keySortedNameMap = null;
		TreeMap<String, Integer> valSortedNameMap = null;
		ValueComparator vb = new ValueComparator(nameMap);
		FileReader fr = null;
		boolean doDistinct = true;
		try {
			long startTime = System.currentTimeMillis();
			fr = new FileReader(csvFile);//csv파일처리의 편의성을 위해 BufferedReader나 FileInputStream을 사용하지 않고 FileReader를 사용함. 
			int c = 0;
			StringBuilder sb = new StringBuilder();//동기화가 필요없기 때문에 StringBuffer대신 StringBuilder를 이용함. 
			int quatCnt = 0;
			while((c=fr.read()) != -1) {
				if(c == 34) {//쌍따옴표인 경우.
					quatCnt++;
					if(quatCnt == 2) {
						fm.findWord(sb.toString(), nameMap, doDistinct);//구간에서 학교명에 대한 카운트를 한번만 수행할지 여부를 true, false로 정의한다. 
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
			
			File keySortedFile = new File(keySortedRptName);
			File valSortedFile = new File(valSortedRptName);
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

