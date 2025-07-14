package problem.string;

import java.util.LinkedHashMap;
import java.util.Map;

public class ATM {
	
	
	public void calculateNotes(int [][] notes, int amont){
		
		Map<Integer,Integer> notelist = new LinkedHashMap<>();
		
		for(int i=0;i<notes.length;i++) {
			
			if(notes[i][1]>0) {
				int count = amont/notes[i][0];
				
				if(count > 0) {			
					int n=Math.min(notes[i][1], count);	
					notelist.put(notes[i][0], n);
					amont-=(notes[i][0]*n);
					notes[i][1]-=n;
				}			
			}
			
		}
		
		if(amont>0) {
			System.out.println("amonth not available");
			return;
		}
		
		
		for(Map.Entry<Integer,Integer> entry : notelist.entrySet()) {
			
			System.out.println("Note : "+entry.getKey()+ " count : "+entry.getValue());
			
		}
		
	}
	
	
	public void atmOperation(int [][] notes , int amount) {
		
		LinkedHashMap<Integer, Integer> notelist=new LinkedHashMap<>();
		
		for(int i=0;i<notes.length;i++) {
			
			if(notes[i][1] > 0) {
				
				int count= (amount/notes[i][0]);
				
				if(count > 0) {
					
					int n = Math.min(notes[i][1],count);
					
					notelist.put(notes[i][0],n);
					amount-=(notes[i][0]*n);
					notes[i][1]-=n;
					
					
				}
			}
			
			
			
			
			
		}
		

		for(Map.Entry<Integer, Integer>entry : notelist.entrySet()) {
			
			System.out.println(entry.getKey()+" "+entry.getValue());
		}
		
		
		
		
	}
	
	public static void main(String[] args) {
		ATM atm = new ATM();
		int [][] notes= new int[][] {{2000,2},{1000,4},{500,0},{200,10},{100,5}};
		atm.atmOperation(notes, 1500);
	}

}
