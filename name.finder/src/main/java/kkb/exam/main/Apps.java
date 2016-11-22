package kkb.exam.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
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
	private static String keySortedRptName;
	private static String valSortedRptName;
	private static IFinderManager fm;
	private static final String CSV_FILE_PATH = ResourceSpec.BIN_PATH.getPath();
	
	/**
	 * 초기화처리를 위한 메소드
	 * @param useKomoran
	 */
	private static void init(boolean useKomoran) {
		if(useKomoran) {
			fm = new KmrnNameFinderManager("", "");
			keySortedRptName = "log/keySortedReport_komoran.log";
			valSortedRptName = "log/valSortedReport_komoran.log";
		} else {
			fm = new NameFinderManager();
			keySortedRptName = "log/keySortedReport.log";
			valSortedRptName = "log/valSortedReport.log";
		}
	}
	/**
	 * Comparator에 맞게 sort한다. 
	 * @param nameMap
	 * @param comparator
	 * @return
	 * @throws IOException
	 */
	private static TreeMap<String, Integer> doSort(Map<String, Integer> nameMap, Comparator<Object> comparator) throws IOException {
		TreeMap<String, Integer> sortedNameMap = new TreeMap<String, Integer>(comparator);
		sortedNameMap.putAll(nameMap);
		return sortedNameMap;
	}
	
	/**
	 * Map을 File로 write한다. 
	 * @param keys
	 * @param nameMap
	 * @param fileName
	 * @throws IOException
	 */
	private static void printMap(Set<Entry<String, Integer>> keys, Map<String, Integer> nameMap, String fileName) throws IOException {
		File sortedFile = new File(fileName);
		FinderUtils.writeDataFile(keys, nameMap, sortedFile);//key기준으로 sort
	}
	
	/**
	 * CSV파일을 읽어 학교명과 일치하는 경우에는 Map에 담는다.  
	 * @param fileFullPath
	 * @param nameMap
	 * @param doDistinct
	 * @throws IOException
	 */
	private static void readFile(String fileFullPath, Map<String, Integer> nameMap, boolean doDistinct) throws IOException {
		File csvFile = new File(fileFullPath);//CSV파일취득 
		FileReader fr = null;
		try {
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
		} finally {
			if(fr != null) {
				try {
					fr.close();
				} catch (IOException e) {}
			}
		}
	}
	
	/**
	 * Main메소드
	 * @param args
	 */
	public static void main(String[] args) {
		boolean useKomoran = true;//Komora 형태소분석 lib기반의 Manager사용여부
		boolean doDistinct = false;//한 구문당 학교명 중복작성시 distinct처리를 할지 여부
		String fileFullPath = CSV_FILE_PATH+CommonSpec.CSV_FILE_NAME.getName();
		try {
			log.debug(">>>>Start File finder");
			long startTime = System.currentTimeMillis();
			init(useKomoran);//초기화
			Map<String, Integer> nameMap = new HashMap<String, Integer>();
			Comparator<Object> comparator = new ValueComparator(nameMap);//value에 대한 내림차순정렬을 위한 custom Comparator
			readFile(fileFullPath, nameMap, doDistinct);//CSV 파일 Read 및 학교명 카운트
			
			TreeMap<String, Integer> keySortedNameMap = doSort(nameMap, Collections.reverseOrder());//Key를 기준으로 정렬
			TreeMap<String, Integer> valSortedNameMap = doSort(nameMap, comparator);//Value를 기준으로 정렬
			printMap(keySortedNameMap.entrySet(), nameMap, keySortedRptName);//정렬된 Key를 가지고 파일 출력
			printMap(valSortedNameMap.entrySet(), nameMap, valSortedRptName);//정렬된 Value를 가지고 파일 출력
			
			log.debug(nameMap);
			log.debug("총 건수 : "+nameMap.entrySet().size());
			long endTime = System.currentTimeMillis();
			log.debug("Elapse time  : "+(endTime-startTime)+"ms");
			log.debug(">>>>End File finder");
		} catch (IOException e) {
			log.error("Happened IOException!");
			e.printStackTrace();
		} catch (Exception e) {
			log.error("Unexpected Error happend");
			e.printStackTrace();
		}
	}
}

