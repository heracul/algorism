package kkb.exam.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.Character.UnicodeBlock;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.lang.StringUtils;

public class FinderUtils {

	/**
	 * 제대로 된 한글 문자인지 여부를 판단한다.
	 * @param ch
	 * @return
	 */
	public static boolean isCompleteyKoreanLetter(char ch) {
		Character.UnicodeBlock unicodeBlock =  Character.UnicodeBlock.of(ch);
		if(UnicodeBlock.HANGUL_SYLLABLES.equals(unicodeBlock)) {//한글단어일 경우
			return true;
		} else  if(UnicodeBlock.HANGUL_COMPATIBILITY_JAMO.equals(unicodeBlock)) {//자음만 있는 경우 ex) ㅎ
			return false;
		} else if(UnicodeBlock.HANGUL_JAMO.equals(unicodeBlock)) {//모음만 있는 경우 ex)ㅜ
			return false;
		} else { //기타 이모티콘 문자 
			return false;
		}
	}
	
	
	/**
	 * 찾고자하는 문자와 일치하는 문자열이 있을 경우에는 해당 문자열을 return한다. 
	 * @param findNameArray
	 * @param token
	 * @param ignoreEquasl 찾고자 하는 단어와 찾은 단어가 완벽하게 일치한 경우에는 학교명이 없다고 판단하고 return하지 않음.
	 * @return
	 */
	public static String getMatchedLetter(String[]findNameArray, String token, boolean ignoreEqual) {
		if(StringUtils.isBlank(token)) return null;
		String newToken = null;
		int index = 0;
		for(int i=0; i<findNameArray.length;i++) {
			if((index=token.indexOf(findNameArray[i])) != -1) {
				newToken = token.substring(0,index+findNameArray[i].length() );
				if(ignoreEqual && findNameArray[i].equals(newToken.trim())) {
					//일치한다는 건 학교명이 안들어가 있다는 뜻임.
					break;
				}
				
				return newToken;
			}
			
		}
		return null;
	}
	
	/**
	 * Map의 값을 File에 Write한다.
	 * @param nameMap
	 * @param file
	 * @throws IOException
	 */
	public static void writeDataFile(Map<String, Integer>nameMap, File file) throws IOException {
		writeDataFile(nameMap.entrySet(), nameMap, file);
	}
	
	/**
	 *  Map의 값을 File에 Write한다. 
	 *  writeDataFile(Map<String, Integer>nameMap, File file)에 대한 오버로딩
	 * @param entrySet
	 * @param nameMap
	 * @param file
	 * @throws IOException
	 */
	public static void writeDataFile(Set<Map.Entry<String, Integer>> entrySet, Map<String, Integer>nameMap, File file) throws IOException {
		if(file == null || nameMap == null)return;
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(file);
			StringBuilder sb = null;
			for(Map.Entry<String, Integer>entry : entrySet) {
				sb = new StringBuilder();
				sb.append("[").append(entry.getKey()).append("]");
				sb.append(" : ").append(nameMap.get(entry.getKey())).append("\n");
				os.write(sb.toString().getBytes());
			}
			os.flush();
		}finally {
			if(os != null) {
				try {
					os.close();
				} catch (IOException e) {
				}
			}
		}
		
	}
}
