package kkb.exam.manager.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import kkb.exam.constants.ResourceSpec;
import kkb.exam.main.LetterVO;
import kkb.exam.manager.IFinderManager;
import kr.co.shineware.nlp.komoran.core.analyzer.Komoran;
import kr.co.shineware.util.common.model.Pair;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class KmrnNameFinderManager implements IFinderManager {

	private static Logger log;
	private Komoran komoran;	
	
	public KmrnNameFinderManager() {
		init();
	}
	public void init() {
		log  = LogManager.getLogger(this.getClass());
		komoran = new Komoran(ResourceSpec.BIN_PATH.getPath()+"/models");
		komoran.setUserDic(ResourceSpec.BIN_PATH.getPath()+"/models/user.dic.txt");
	}

	public void findWord(String readLine, Map<String, Integer> nameMap) {
		List<List<Pair<String, String>>> result = komoran.analyzeWithoutSpace(readLine);
		Integer cnt = null;
		StringBuilder sb = null;
		String cacheStr = null;
		LinkedList<String> wordList = null;
		for (List<Pair<String, String>> eojeolResult : result) {
			sb = new StringBuilder();
			for (Pair<String, String> wordMorph : eojeolResult) {
//				if("NNG".equals( wordMorph.getSecond())) {
//					String matchedLetter = FinderUtils.getMatchedLetter(CommonSpec.FIND_NAME_ARRAY.getAttribute(), wordMorph.getFirst());
//					if(StringUtils.isNotBlank(matchedLetter)) {
//						cnt = nameMap.get(matchedLetter);
//						if(null != cnt) {
//							nameMap.put(matchedLetter, cnt+1);
//						} else {
//							nameMap.put(matchedLetter, 1);
//						}
//					}
//				}
				System.out.println(wordMorph.getFirst() +"/"+wordMorph.getSecond());
//				if("NNP".equals(wordMorph.getSecond()) || "NNG".equals(wordMorph.getSecond())) {
//					wordList.add(wordMorph.getFirst());
//				} 
			}
		}
		
	}
	public static void main(String[] args) {
		KmrnNameFinderManager knf = new KmrnNameFinderManager();
		String str1 = "여기는 명지대학교, 청담고등학교, 압구정중, 압구정중학교, 청담 초등학교 출신들이 모이는 자리입니다. ";
		knf.findWord(str1, new HashMap<String, Integer>());
		
	}
}
