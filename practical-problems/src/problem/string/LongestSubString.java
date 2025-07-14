package problem.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubString {

	public int maxSubString(String str) {

		int len = str.length();
		int maxlen = 0;

		if (str != null && str.length() > 0) {

			int l = 0, r = 0;
			Set<Character> substr = new HashSet<>();

			while (r < len) {

				char ch = str.charAt(r);

				if (!substr.contains(ch)) {
					substr.add(ch);					
					maxlen = Math.max(maxlen, r - l + 1);
					r++;
				} else {
					substr.remove(str.charAt(l));
					l++;
				}
			}
			
			System.out.println(str.substring(l,r));

		}
		

		return maxlen;
	}
	
	
	public String maxSubStringV1(String str) {
		
		int l=0,r=0;
		int len=str.length();
		Set<Character> substring = new HashSet<>();
		
		while(r<len) {
			
			char ch = str.charAt(r);
			if(!substring.contains(ch)) {
				substring.add(ch);
				r++;
			}
			else {
				substring.remove(str.charAt(l));
				l++;
			}
			
		}
		
		
		return str.substring(l,r);
	}
	

	public static void main(String[] args) {
		
		LongestSubString longestSubString=new LongestSubString();
		System.out.println(longestSubString.maxSubStringV1("vijaylokhande"));

	}

}
