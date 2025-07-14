package problem.string.csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CSVOperation {
	
	
	public List<Map<String,String>> readCSV(String filename){
		
		List<Map<String,String>> data= new ArrayList<>();
		
		try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))){
			
			String header =bufferedReader.readLine();
			
			if(header==null) {
				System.out.println("unable to read csv file");
			}
			else {
				
				String [] head = header.split(",");
				
				String line;
				while((line=bufferedReader.readLine())!=null) {
					
				   String [] linedata =	line.split(",");
				   
				   if(linedata.length > head.length) {
					   linedata= processLine(line, head.length);
				   }
				   
				   Map<String,String> mapdata=new LinkedHashMap<>();
				   
				   for(int i=0;i<head.length;i++) {					
					   mapdata.put(head[i], linedata[i]);					   
				   }
				   data.add(mapdata);
				}
				
			}
			
		}
		catch (Exception e) {
			System.err.println("unable to read data"+ e.getMessage());
		}
		
		return data;
	}
	
	
	public String [] processLine(String line,int headerlength) {
		List<String> out = new ArrayList<>();
	 
		boolean isQ=false;
		int n=line.length();
		StringBuilder sb=new StringBuilder();
		
		
		for(int i=0;i<n;i++) {
			
			char ch=line.charAt(i);
			
			if(ch=='"') {
				
				if(isQ && (i+1) < n && line.charAt(i+1)=='"' ) {					
					sb.append('"');
					i++;
				}
				else {
					isQ=!isQ;
				}				
			}
			else if(ch==',' && !isQ) {
				
				out.add(sb.toString());
				sb=new StringBuilder();
				
			}
			else {
				sb.append(ch);
			}
			
			
		}
	
		
		return (String[]) out.toArray();
	}
	
	public static void main(String[] args) {
		
		System.out.println(new CSVOperation().readCSV("C:\\Users\\HP\\vijay_lokhande\\study\\proctical-problems\\src\\problem\\string\\csv\\data.csv"));
		
	}

}
