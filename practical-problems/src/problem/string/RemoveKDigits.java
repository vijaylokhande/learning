package problem.string;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Input: num = "1432219", k = 3
   Output: "1219"
 */

public class RemoveKDigits {
	
	
	public String removeKdigits(String str,int k) {
		
		Deque<Character> deque = new ArrayDeque<>();
		
		for(char c : str.toCharArray()) {
			if(!deque.isEmpty() && k>0 && deque.peekLast() > c) {
				deque.removeLast();
				k--;
			}
			deque.addLast(c);			
		}
		
		while(k > 0 && !deque.isEmpty()) {
			deque.removeLast();
			k--;
		}
		
		
		StringBuilder digits=new StringBuilder();
		
		while(!deque.isEmpty()) {			
			digits.append(deque.remove());			
		}
		
		
		while(digits.length() > 0 && digits.charAt(0)=='0') {
			digits.deleteCharAt(0);
		}
		
		return digits.length() ==0  ? "0" : digits.toString();
		
	}
	
	
	
	public String removeKdigitsV1(String str,int k) {
		
		
		Deque<Character> dq= new ArrayDeque<>();
		
		
		for(char ch : str.toCharArray()) {
			
			
			if(!dq.isEmpty() && k>0 && dq.peekLast() > ch ) {
				
				dq.removeLast();
				k--;				
			}			
			dq.addLast(ch);
		}
		
		while(k>0 && !dq.isEmpty()) {
			dq.removeLast();
			k--;
		}
		
		StringBuffer buffer=new StringBuffer();
		
		while(!dq.isEmpty()) {
			buffer.append(dq.remove());
		}
		
		
		while(buffer.length()>0 && buffer.charAt(0)==0) {
			
			buffer.deleteCharAt(0);
			
		}
		
		
		return buffer.toString();
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		RemoveKDigits removeKDigits = new RemoveKDigits();
		
		System.out.println(removeKDigits.removeKdigitsV1("1432219", 3));
		System.out.println(removeKDigits.removeKdigits("1111112", 3));
		System.out.println(removeKDigits.removeKdigits("1000000", 3));
		System.out.println(removeKDigits.removeKdigits("0101010", 3));
		
	}

}
