package problem.string;

public class ReverseWord {
	
	public String revereseWords(String sentence) {
		
		StringBuffer reverese= new StringBuffer();
		
		String [] tokens = sentence.split(" ");
		
		for(int i=tokens.length-1; i>=0;i--) {
			reverese.append(tokens[i]);reverese.append(" ");
		}
		
		return reverese.toString();
	}
	
	public static void main(String[] args) {
		
		ReverseWord reverseWord =new ReverseWord();
		System.out.println(reverseWord.revereseWords("Hello world"));
		
	}

}
