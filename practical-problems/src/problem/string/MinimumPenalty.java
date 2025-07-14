package problem.string;

public class MinimumPenalty {
	
	
	public int minPenalty(String customerLog, String shopLog) {
		
		int min=Integer.MAX_VALUE;
		int besttime=-1;
		
		
		int n = customerLog.length();
			
		
		for(int i=0;i<n;i++) {
			
			int penalty=0;
			
			for(int j=0;j<i;j++) {
								
				if(customerLog.charAt(j) =='N' && shopLog.charAt(j)=='1')
					penalty++;
			}
			
			for(int j=i;j<n;j++) {
				
				if(customerLog.charAt(j) =='Y' && shopLog.charAt(j)=='0')
					penalty++;
			}
			
			System.out.println(penalty);
			
			if(min > penalty) {
				min = penalty;
				besttime=i;
			}
			
			
		}
		
		
		return besttime;
	}

	
	public int totalPenalty(String customerLog,String shopLog) {
		
		
		int penalty=0;
		
		int n = customerLog.length();
		
		for(int i=0;i<n;i++) {
			
			if((customerLog.charAt(i)=='Y' && shopLog.charAt(i)=='0') || (customerLog.charAt(i)=='N' && shopLog.charAt(i)=='1') ) {
				penalty++;
			}
					
		}
		
		
		return penalty;
	}
	
	
	public static void main(String[] args) {
		
		MinimumPenalty minimumPenalty=new MinimumPenalty();
		
		System.out.println(minimumPenalty.minPenalty("YNNY","1100"));
		System.out.println(minimumPenalty.totalPenalty("YNNY", "1100"));
		
	}

}
