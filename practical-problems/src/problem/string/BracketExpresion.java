package problem.string;

import java.util.Stack;

public class BracketExpresion {
	
	
	public String decoding(String encodedText) {
		
		StringBuilder tokens = new StringBuilder();
		StringBuilder counter = new StringBuilder();
		
		Stack<Integer> nStack = new Stack<>();
		Stack<StringBuilder> tStack = new Stack<>();
		
		
		for(char ch : encodedText.toCharArray()) {
		
			// 3[a]2[bc]
			
			if(Character.isDigit(ch)) {				
				counter.append(ch);				
			}
			else if(ch=='[') {				
			 nStack.push(Integer.parseInt(counter.toString()));
			 counter = new StringBuilder();
			 tStack.push(tokens);
			 tokens=new StringBuilder();	
			}
			else if(ch==']') {
				
				int n= nStack.pop();
				StringBuilder decoded = tStack.pop();
				
				while(n>0) {
					decoded.append(tokens);
					n--;
				}
				
				tokens = decoded;
			}
			else {
				tokens.append(ch);
			}
		}	
		
				
		return tokens.toString();
	}
	
	
	
	public static void main(String[] args) {
		
		BracketExpresion decoding=new BracketExpresion();
		System.out.println(decoding.decoding("3[a]2[bc]"));		
		System.out.println(decoding.decoding("3[a2[c]]"));
		
	}

}
