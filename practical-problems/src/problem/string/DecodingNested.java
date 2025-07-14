package problem.string;

import java.util.Stack;

/*
 * Input: s = "3[a]2[bc]"
   Output: "aaabcbc"
 */
public class DecodingNested {
	
	public String decoding(String str) {
		Stack<Integer> countstack= new Stack<>();
		Stack<String> decodestack = new Stack<>();
		StringBuilder current = new StringBuilder();
		int count=0;
		for(char c : str.toCharArray()) {
			
			if(Character.isDigit(c)) {				
				count= count*10 + (c-'0');				
			}
			else if(c=='[') {		
				countstack.push(count);
				decodestack.push(current.toString());
				current = new StringBuilder();
				count=0;				
			}
			else if(c==']') {
				
				int n= countstack.pop();
				StringBuilder decode = new StringBuilder(decodestack.pop());				
				while(n> 0) {
					decode.append(current);
					n--;
				}				
				current=decode;
				
			}
			else {
				current.append(c);
			}		
			
		}
		
		return current.toString();
	}
	
	
	public static void main(String[] args) {
		
		DecodingNested decoding=new DecodingNested();
		System.out.println(decoding.decoding("3[a]2[bc]"));		
		System.out.println(decoding.decoding("3[a2[c]]"));
		
	}

}
