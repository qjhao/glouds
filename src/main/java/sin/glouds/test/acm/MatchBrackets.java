package sin.glouds.test.acm;

import java.util.Scanner;
import java.util.Stack;

public class MatchBrackets {

	public static void main(String[] args) {
		Scanner cin=new Scanner(System.in);
		int a = Integer.parseInt(cin.nextLine());
		String[] strs = new String[a];
		for(int i = 0;i<a;i++) {
			strs[i] = cin.nextLine();
		}
		cin.close();
		for(int i = 0;i<a;i++) {
			if(isMatched(strs[i]))
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
	
	public static boolean isMatched(String string) {
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0;i<string.length();i++) {
			Character character = string.charAt(i);
			if(i == 0) {
				if(character == ']' || character == ')')
					return false;
				stack.push(character);
			}else{
				if(character == '(' || character == '[')
					stack.push(character);
				else {
					if(stack.size() == 0)
						return false;
					if((stack.peek() == '[' && character == ']') || stack.peek() == '(' && character == ')')
						stack.pop();
					else
						return false;
				}
			}
		}
		if(stack.size() == 0)
			return true;
		return false;
	}
}
