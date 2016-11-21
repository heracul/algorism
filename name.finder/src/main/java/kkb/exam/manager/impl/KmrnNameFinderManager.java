package kkb.exam.manager.impl;

import java.util.List;
import java.util.Map;

import kkb.exam.constants.CommonSpec;
import kkb.exam.constants.ResourceSpec;
import kkb.exam.manager.IFinderManager;
import kkb.exam.utils.FinderUtils;
import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class KmrnNameFinderManager implements IFinderManager {

	private static Logger log;
	private Komoran komoran;
	private String dictionaryFolderPath = ResourceSpec.BIN_PATH.getPath()+"/models";
	private String dictionaryFileName = "user.dic.txt";
	
	
	public KmrnNameFinderManager(String dictionaryFolderPath, String dictionaryFileName) {//생성자
		if(StringUtils.isNotBlank(dictionaryFolderPath))this.dictionaryFolderPath = dictionaryFolderPath;
		if(StringUtils.isNotBlank(dictionaryFileName))  this.dictionaryFileName = dictionaryFileName;
		init();
	}
	public void init() {//인스턴스 초기화
		log  = LogManager.getLogger(this.getClass());
		komoran = new Komoran(dictionaryFolderPath);
		komoran.setUserDic(dictionaryFolderPath+"/"+dictionaryFileName);
	}

	public void findWord(String readLine, Map<String, Integer> nameMap, boolean doDistinct) {
		if(StringUtils.isBlank(readLine))return;
		for(String removeWord : CommonSpec.REMOVE_WORD_ARRAY.getAttribute()) {//komoran이 특수문자를 제대로 걸러내지 못하는 현상이 있음. 
			readLine = validateLetter(readLine).replaceAll(removeWord, " ");//완성된 한글만 취득 후, 불필요한 문자열 치환 
		}
		
		List<List<Pair<String, String>>> result = komoran.analyzeWithoutSpace(readLine);
		Integer cnt = null;
		String matchedLetter = null;
		saveToken:for (List<Pair<String, String>> eojeolResult : result) {
			for (Pair<String, String> wordMorph : eojeolResult) {
				if("NNG".equals( wordMorph.getSecond()) ||
				   "NNP".equals( wordMorph.getSecond()) ||
				   "NA".equals( wordMorph.getSecond()) 
				) {
					matchedLetter = FinderUtils.getMatchedLetter(CommonSpec.FIND_NAME_ARRAY.getAttribute(), wordMorph.getFirst(), true);
					if(StringUtils.isNotBlank(matchedLetter)) {
						for(String specificWord : CommonSpec.REMOVE_SEPECIFIC_WORD_ARRAY.getAttribute()) {//특수 언어들과 완전히 일치한다면 skip하도록 처리.
							if(specificWord.equals(matchedLetter.trim())) {
								continue saveToken;
							}
						}
						cnt = nameMap.get(matchedLetter);
						if(null != cnt) {
							nameMap.put(matchedLetter, cnt+1);
						} else {
							nameMap.put(matchedLetter, 1);
						}
						if(doDistinct) break saveToken;
					}
				}
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
