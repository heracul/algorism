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
	
	/**
	 * 초기화 처리를 위한 init 메소드 
	 */
	public void init() {
		log  = LogManager.getLogger(this.getClass());
	}
	
	/** 
	 * 학교명을 Key로 하여 건수를 Map에 put할 수 있도록 처리함. 
	 */
	public void findWord(String readLine, Map<String, Integer>nameMap) {
		for(String removeWord : CommonSpec.REMOVE_WORD_ARRAY.getAttribute()) {//불필요한 문자열 공백으로 치환 
			readLine = readLine.replaceAll(removeWord, " ");
		}
		
		String[]tokenArr = StringUtils.split(readLine, (char)0x20);//공백을 기준으로 split 수행 
		Integer cnt = null;
		String newToken;
		saveToken:for(String token : tokenArr) {
			for(String specificWord : CommonSpec.REMOVE_SEPECIFIC_WORD_ARRAY.getAttribute()) {
				if(specificWord.equals(token.trim())) {
					continue saveToken;
				}
			}
			newToken = validateLetter(token);
			if(StringUtils.isNotBlank(newToken = FinderUtils.getMatchedLetter(CommonSpec.FIND_NAME_ARRAY.getAttribute(), newToken, true))) {
				cnt = nameMap.get(newToken);
				if(null != cnt) {
					nameMap.put(newToken, cnt+1);
				} else {
					nameMap.put(newToken, 1);
				}
			}
		}
	}
	
	/**
	 * 문자열에 대한 validate수행 
	 * @param str
	 * @return
	 */
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
