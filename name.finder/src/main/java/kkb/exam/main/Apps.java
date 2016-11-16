package kkb.exam.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import kkb.exam.constants.CommonSpec;
import kkb.exam.constants.ResourceSpec;
import kkb.exam.manager.IFinderManager;
import kkb.exam.manager.impl.NameFinderManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class Apps {
	private static Logger log = LogManager.getLogger(Apps.class);
	
	public static void main(String[] args) {
		IFinderManager fm = new NameFinderManager();
		
		String csvFilePath = ResourceSpec.BIN_PATH.getPath();
		File csvFile = new File(csvFilePath+CommonSpec.CSV_FILE_NAME.getName());
		BufferedReader br = null;
				
		Map<String, Integer> nameMap = new HashMap<String, Integer>();
		try {
			String s = null;
			br = new BufferedReader(new FileReader(csvFile));
			while((s=br.readLine()) != null) {
				fm.findWord(s, nameMap);
			}

			Set<String> keySet = nameMap.keySet();
			Iterator<String> keyIter = keySet.iterator();
			String key = null;
			while(keyIter.hasNext()) {
				key = keyIter.next();
				log.debug(key+"\t : \t"+nameMap.get(key));
			}
			
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
				} catch (IOException e) {
				}
			}
		}
	}

}
