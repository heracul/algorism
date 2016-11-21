package algorism.bracket;

import java.util.Stack;

public class BracketCheck2 {

	public static void main(String[] args) {
		String str1 = "({[]})";
		String str2 = "[{]}";
		String str3 = "[{()";
		String str4 = ")(){";
		String str5 = "{}[{}](((())))";
		
		System.out.println(BracketCheck2.checkMatch(str1)==true?"YES":"NO");
		System.out.println(BracketCheck2.checkMatch(str2)==true?"YES":"NO");
		System.out.println(BracketCheck2.checkMatch(str3)==true?"YES":"NO");
		System.out.println(BracketCheck2.checkMatch(str4)==true?"YES":"NO");
		System.out.println(BracketCheck2.checkMatch(str5)==true?"YES":"NO");
		
	}
	
	public static boolean checkMatch(String str1) {
		char[]cArr = str1.toCharArray();
		boolean isMatched = false;
		Stack<Character> stack = new Stack<Character>();
		for(char c : cArr) {
			if(isOpen(c)) {
				stack.push(c);
			} else {
				if(stack.isEmpty()) return false;
				if(isMatch(stack.pop(), c)) {
					isMatched = true;
				} else {
					return false;
				}
			}
		}
		if(!stack.isEmpty()) isMatched=false;
		return isMatched;
	}

	private static boolean isMatch(Character pop, char c) {
		if(pop=='[' && c==']') {
			return true;
		} else if(pop=='{' && c=='}') {
			return true;
		} else if(pop=='(' && c==')') {
			return true;
		} else {
			return false;
		}
	}

	private static boolean isOpen(char c) {
		if(c=='[' || c=='{' || c=='(') {
			return true;
		}
		return false;
	}
}
