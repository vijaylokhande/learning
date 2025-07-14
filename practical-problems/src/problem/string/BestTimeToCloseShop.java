package problem.string;

public class BestTimeToCloseShop {
	
	public int bestClosingTime(String customers) {
	
		int besttimetoclose=0;
		int len = customers.length();				
		long penalty=customers.chars().filter(c -> c=='Y').count();		
		long min =penalty;
		
		for(int i=0;i<len;i++) {
			
			if(customers.charAt(i)=='Y') {
				penalty--;
			}
			else {
				penalty++;
			}
			
			if(min > penalty) {
				min=penalty;
				besttimetoclose=i+1;
			}
		}
		
		return besttimetoclose;
	}
	
	public int bestTime(String text) {
		
		int bt=0;
		
		long totalPenalty=text.chars().filter(ch -> ch=='Y').count();
		long min = totalPenalty;
		
		for(int i=0;i<text.length();i++) {
			
			if(text.charAt(i)=='Y') {
				totalPenalty--;
			}
			else {
				totalPenalty++;
			}
			
			
			if(min > totalPenalty) {
				min =totalPenalty;
				bt=i+1;
			}
			
		}
		
		
		
		
		return bt;
	}
	
	
	public static void main(String[] args) {
		
		
		System.out.println(new BestTimeToCloseShop().bestTime("YYNY"));
		System.out.println(new BestTimeToCloseShop().bestTime("NYYYY"));
		System.out.println(new BestTimeToCloseShop().bestTime("YN"));
		System.out.println(new BestTimeToCloseShop().bestClosingTime("YYNY"));
		System.out.println(new BestTimeToCloseShop().bestClosingTime("NYYYY"));
		System.out.println(new BestTimeToCloseShop().bestClosingTime("YN"));
	}

}
