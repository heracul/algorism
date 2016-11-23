package kkb.exam.processor.impl;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import kkb.exam.constants.CommonSpec;
import kkb.exam.processor.IFindProcessor;
import kkb.exam.utils.FinderUtils;

/**
 * String에서 학교명을 찾아 카운트 하는 클래스
 * @author 08158
 *
 */
public class NameFindProcessor implements IFindProcessor {
	
	
	private static Logger log;
	
		
	/**
	 * 생성자
	 */
	public NameFindProcessor() {
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
	public void findWord(String readLine, Map<String, Integer>nameMap, boolean doDistinct) {
		if(StringUtils.isBlank(readLine))return;
		for(String removeWord : CommonSpec.REMOVE_WORD_ARRAY.getAttribute()) {
			readLine = validateLetter(readLine).replaceAll(removeWord, " ");//완성된 한글만 취득 후, 불필요한 문자열 치환 
		}
		
		String[]tokenArr = StringUtils.split(readLine, (char)0x20);//공백을 기준으로 split 수행 
		Integer cnt = null;
		String newToken = null;
		saveToken:for(String token : tokenArr) {
			if(StringUtils.isNotBlank(newToken = FinderUtils.getMatchedLetter(CommonSpec.FIND_NAME_ARRAY.getAttribute(), token, true))) {
				for(String specificWord : CommonSpec.REMOVE_SEPECIFIC_WORD_ARRAY.getAttribute()) {//특수 언어들과 완전히 일치한다면 skip하도록 처리.
					if(specificWord.equals(newToken.trim())) {
						continue saveToken;
					}
				}
				cnt = nameMap.get(newToken);
				if(null != cnt) {
					nameMap.put(newToken, cnt+1);
				} else {
					nameMap.put(newToken, 1);
				}
				if(doDistinct) break;
			}
		}
	}
	
	/**
	 * 제대로 작성된 한글만 재 취합 후 return함. 
	 * @param str
	 * @return
	 */
	public String validateLetter(String str) {
		char[]charArr = str.toCharArray();
		StringBuffer sb = new StringBuffer();
		for(char c : charArr) {
			if(FinderUtils.isCompleteyKoreanLetter(c)) {
				sb.append(c);
			} else {
				sb.append(" ");//완성형 한글 캐릭터가 아닐 경우에는 공백추가.
			}
		}
		return sb.toString();
	}
}
