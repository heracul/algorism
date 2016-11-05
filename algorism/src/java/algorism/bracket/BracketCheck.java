package algorism.bracket;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class BracketCheck {

	public static void main(String[] args) {
		BracketCheck bc = new BracketCheck();
		Scanner scan = new Scanner(System.in);
		int testCaseCnt = scan.nextInt();
		List<String>inputStrList = new ArrayList<String>();
		try {
			for(int i=0; i<testCaseCnt; i++) {
				inputStrList.add(scan.next());
			}
			for(String inputStr : inputStrList) {
				if(bc.execute(inputStr)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
			}
		} finally {
			if(scan != null) {
				scan.close();
			}
		}
	}
	
	public boolean execute(String inputStr) {
		boolean isMatched = false;
		Stack<Character> stack  = new Stack<Character>();
		for(char c : inputStr.toCharArray()) {
			if(isOpenBracket(c)) {
				stack.push(c);
			} else if(isEndBracket(c)){
				if(stack.isEmpty()) {
					isMatched = false;
					continue;
				}
				if(isMatch(stack.pop(), c)) {
					isMatched = true;
				} else {
					isMatched = false;
					break;
				}
			} else {
				if(stack.isEmpty()) {
					isMatched = false;
					continue;
				}
			}
		}
		if(!stack.isEmpty()) {
			isMatched = false;
		}
		return isMatched;
	}
	
	private boolean isOpenBracket(char inputChar) {
		if('('==inputChar || '{'==inputChar|| '['==inputChar) {
			return true;
		} else {
			return false;
		}
	}
	
	private boolean isEndBracket(char inputChar) {
		if(')'== inputChar || '}'== inputChar || ']'== inputChar) {
			return true;
		} else {
			return false;
		}
		
	}
	
	private boolean isMatch(char pop, char inputChar) {
		if('('== pop) {
			return ')' == inputChar;
		} else if('{'== pop) {
			return '}' == inputChar;
		} else if('['== pop) {
			return ']' == inputChar;
		} else {
			return false;
		}
	}

}
