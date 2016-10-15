package algorism.replace.chracter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpecialChracterReplacer {

	public static void main(String[] args) {
		byte[] bArr = new byte[1024];
		List<String> inputStrList = new ArrayList<String>();
		try {
			if(System.in.read(bArr) > 0) {
				String inputLine = new String(bArr);
				int cnt = Integer.parseInt(inputLine.trim().replaceAll("\n", ""));
				for(int i=0; i<cnt; i++) {
					if(System.in.read(bArr) > 0) {
						inputLine = new String(bArr);
						inputStrList.add(inputLine.trim().replaceAll("\n", ""));
					}
				}
				
				for(String input : inputStrList) {
					for(int i=0; i < input.toCharArray().length; i++) {
						char cArr = input.toCharArray()[i];
						if(cArr == '%') {
							input = input.replaceAll(input.substring(i, i+3), returnCharacter(input.substring(i, i+3)));
						}
					}
					System.out.println(input);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static String returnCharacter(String input) {
		if("%20".equals(input)) {
			return " ";
		} else if("%21".equals(input)) {
			return "!";
		} else if("%24".equals(input)) {
			return "$";
		} else if("%25".equals(input)) {
			return "%";
		} else if("%28".equals(input)) {
			return "(";
		} else if("%29".equals(input)) {
			return ")";
		} else if("%2a".equals(input)) {
			return "*";
		} else {
			return "";
		}
	}

}
