package kkb.exam.manager;

import java.util.Map;

public interface IFinderManager {

	/**
	 * 인스턴스 초기화를 위한 메소드 
	 */
	public abstract void init();
	
	/**
	 * String에서 학교명을 찾기위한 메소드
	 * @param readLine
	 * @param nameMap
	 * @param doDistinct false일 경우에는 readLine내 학교명에 대한 카운트중복을 허용한다. 
	 */
	public abstract void findWord(String readLine, Map<String, Integer>nameMap, boolean doDistinct);
	
	/**
	 * 문자열에 대한 validation을 수행한다. (ex. 정상적인 한글문자여부 확인)
	 * @param str
	 * @return
	 */
	public abstract String validateLetter(String str);
	
}
