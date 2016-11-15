package kkb.exam.manager.impl;

import java.util.Map;

import kkb.exam.constants.CommonSpec;
import kkb.exam.manager.IFinderManager;
import kkb.exam.utils.FinderUtils;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class NameFinderManager implements IFinderManager {
	
	
	private static Logger log;
	
		
	public NameFinderManager() {
		init();
	}
	
	public void init() {
		log  = LogManager.getLogger(this.getClass());
	}
	
	public void findWord(String readLine, Map<String, Integer>nameMap) {
		for(String removeWord : CommonSpec.REMOVE_WORD_ARRAY.getAttribute()) {
			readLine = readLine.replaceAll(removeWord, " ");
		}
		
		String[]tokenArr = StringUtils.split(readLine, (char)0x20);
		Integer cnt = null;
		String newToken;
		for(String token : tokenArr) {
			newToken = validateLetter(token);
			if(StringUtils.isNotBlank(newToken = FinderUtils.getMatchedLetter(CommonSpec.FIND_NAME_ARRAY.getAttribute(), newToken))) {
				
				cnt = nameMap.get(newToken);
				if(null != cnt) {
					nameMap.put(newToken, cnt+1);
				} else {
					nameMap.put(newToken, 1);
				}
			}
		}
	}
	
	public static String validateLetter(String str) {
		char[]charArr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(char c : charArr) {
			if(FinderUtils.isCompleteyKoreanLetter(c)) {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
