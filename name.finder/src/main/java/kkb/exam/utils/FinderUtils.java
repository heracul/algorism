package kkb.exam.utils;

import java.lang.Character.UnicodeBlock;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;

public class FinderUtils {

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
	
	
	public static String getMatchedLetter(String[]findNameArray, String token) {
		if(StringUtils.isBlank(token)) return null;
		String newToken = null;
		int index = 0;
		for(int i=0; i<findNameArray.length;i++) {
			if((index=token.indexOf(findNameArray[i])) != -1) {
				newToken = token.substring(0,index+findNameArray[i].length() );
				return newToken;
			}
		}
		return null;
	}
}
