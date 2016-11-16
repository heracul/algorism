package kkb.exam.manager.impl;

import java.util.HashMap;
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
	
	public KmrnNameFinderManager() {
		init();
	}
	public void init() {
		log  = LogManager.getLogger(this.getClass());
		komoran = new Komoran(ResourceSpec.BIN_PATH.getPath()+"/models");
	}

	public void findWord(String readLine, Map<String, Integer> nameMap) {
		List<List<Pair<String, String>>> result = komoran.analyzeWithoutSpace(readLine);
		Integer cnt = null;
		for (List<Pair<String, String>> eojeolResult : result) {
			for (Pair<String, String> wordMorph : eojeolResult) {
				if("NNG".equals( wordMorph.getSecond())) {
//					String matchedLetter = FinderUtils.getMatchedLetter(CommonSpec.FIND_NAME_ARRAY.getAttribute(), wordMorph.getFirst());
//					if(StringUtils.isNotBlank(matchedLetter)) {
//						cnt = nameMap.get(matchedLetter);
//						if(null != cnt) {
//							nameMap.put(matchedLetter, cnt+1);
//						} else {
//							nameMap.put(matchedLetter, 1);
//						}
//					}
					System.out.println(wordMorph);

				}
			}
		}
	}
	public static void main(String[] args) {
		KmrnNameFinderManager knf = new KmrnNameFinderManager();
		String str1 = "여기는 명지대학교, 청담고등학교 출신들이 모이는 자리입니다. ";
		knf.findWord(str1, new HashMap<String, Integer>());
	}
}
