package problem.string.csv;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * 
18. Transaction CSV Summarizer
Problem: Given CSV input with columns [transaction_type, currency, date, amount], implement a function to sum amounts grouped by date and transaction_type.
 */

public class CSVSummerizer {
	
	
	void readFile(String filename){
		
		Map<String,Map<String,Double>> transactiondata= new LinkedHashMap<>();
		
		try(BufferedReader bf = new BufferedReader(new FileReader(filename))){
			
			String head= bf.readLine();
			
			if(head==null) {
				throw new IllegalArgumentException("CSV File without header");
			}
			else {
				
				String[] headdata= head.split(",");
				
				String line;
				
				while((line = bf.readLine()) !=null) {
					
					String [] linedata=line.split(",");					
					
					String transaction_type=linedata[0]; 
					String date=linedata[2];
					Double amount=Double.valueOf(linedata[3]);	
					
					transactiondata.computeIfAbsent(date, d-> new LinkedHashMap<String,Double>())
					.merge(transaction_type, amount, Double::sum);
										
				}
				
				System.out.println(transactiondata);
				
				
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		new CSVSummerizer().readFile("C:\\Users\\HP\\vijay_lokhande\\study\\proctical-problems\\src\\problem\\string\\csv\\data-tran.csv");
		
	}

}
