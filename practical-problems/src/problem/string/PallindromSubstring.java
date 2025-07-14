package problem.string;

import java.util.HashSet;
import java.util.Set;

public class PallindromSubstring {
	
	
	public Set<String> allPalindromSubString(String str) {
		
		Set<String> sublist = new HashSet<>();
		
		for(int i=0;i<str.length();i++) {
			substrings(str,i,i,sublist);
			substrings(str,i,i+1,sublist);
		}
		
		
		
		return sublist;
	}
	
	
	public void substrings(String str, int left,int right, Set<String> sublist) {
		
		while(left >=0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			
			sublist.add(str.substring(left,right+1));
			left--;
			right++;
		}
		
		
	}
	

	
	public static void main(String[] args) {
		
		PallindromSubstring pallindromSubstring=new PallindromSubstring();
		
		System.out.println(pallindromSubstring.allPalindromSubString("aabbccaaacccc"));
	}
}
