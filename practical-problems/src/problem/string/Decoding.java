package problem.string;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/*
 * Input: s = "3[a]2[bc]"
   Output: "aaabcbc"
 */
public class Decoding {
	
	public String decoding(String str) {
		
		Stack<Character> stack = new Stack<>();
		StringBuffer out= new StringBuffer();
		
		
		for(char ch : str.toCharArray()) {
			
			if(ch==']') {
				StringBuffer chars = new StringBuffer();				
				while(!stack.isEmpty() && stack.peek()!='[') {
					chars.append(stack.pop());					
				}
				stack.pop(); // [
				StringBuffer num = new StringBuffer();	
				while(!stack.isEmpty()) {
					num.append(stack.pop());					
				}
				
				chars.reverse();
				int n= Integer.parseInt(num.reverse().toString());
				
				while(n>0) {
					out.append(chars);
					n--;
				}				
			}
			else {				
				stack.push(ch);
			}
		}
		
		return out.toString();
	}
	
	
	public static void main(String[] args) {
		
		Decoding decoding=new Decoding();
		System.out.println(decoding.decoding("3[a]2[bc]"));
		
	}

}
