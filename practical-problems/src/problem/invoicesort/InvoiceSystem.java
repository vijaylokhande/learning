package problem.invoicesort;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.TreeMap;

public class InvoiceSystem {
	
	
	TreeMap<Integer, String> emailSchedule = new TreeMap<>();	
	TreeMap<String,String> invoiceSchedule= new TreeMap<>();
	
	
	
	public InvoiceSystem() {		
		emailSchedule.put(-10, "Reminde : Invoice comming soon");
		emailSchedule.put(0, "Invoice available");
		emailSchedule.put(20, "Followup : Invoice unpaid");
		emailSchedule.put(30, "Final Notice : Invoice due today");
	}
	
	
	public void invoiceScheduler(TreeMap<String, String> invoiceSchedule) {
		String today =  getDateFromDays(0l);
		String before10days = getDateFromDays(10l);
		String after20days  = getDateFromDays(-20l);
		String after30days  = getDateFromDays(-30l);
		
		System.out.println(today);
		System.out.println(before10days);
		System.out.println(after20days);
		System.out.println(after30days);
			
		
		invoiceSchedule.entrySet().stream().filter(entry -> entry.getValue().equals(today)).forEach(item ->{
			System.out.println(item.getKey()+":"+item.getValue()+" | "+emailSchedule.get(0));
		});
		
		invoiceSchedule.entrySet().stream().filter(entry -> entry.getValue().equals(before10days)).forEach(item ->{
			System.out.println(item.getKey()+":"+item.getValue()+" | "+emailSchedule.get(-10));
		});
		
		invoiceSchedule.entrySet().stream().filter(entry -> entry.getValue().equals(after20days)).forEach(item ->{
			System.out.println(item.getKey()+":"+item.getValue()+" | "+emailSchedule.get(20));
		});
		
		invoiceSchedule.entrySet().stream().filter(entry -> entry.getValue().equals(after30days)).forEach(item ->{
			System.out.println(item.getKey()+":"+item.getValue()+" | "+emailSchedule.get(30));
		});	
		
		
	}
	
	
	public String getDateFromDays(long days) {
		
		LocalDate date=LocalDate.now();		
		DateTimeFormatter dateTimeFormatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		if(days < 0) {
			date= date.minusDays(days*-1);
		}
		else if(days > 0) {
			date =date.plusDays(days);
		}		
		return date.format(dateTimeFormatter);		
	}
	
	
	public static void main(String[] args) {
		
		TreeMap<String, String> invoiceSchedule =new TreeMap<>();
		
		invoiceSchedule.put("invoice1", "28-06-2025");
		invoiceSchedule.put("invoice2", "28-05-2025");
		invoiceSchedule.put("invoice3", "18-06-2025");
		invoiceSchedule.put("invoice4", "08-06-2025");
		invoiceSchedule.put("invoice5", "08-07-2025");
		invoiceSchedule.put("invoice6", "28-06-2025");
		invoiceSchedule.put("invoice7", "29-05-2025");
		invoiceSchedule.put("invoice8", "18-06-2025");
		invoiceSchedule.put("invoice9", "28-05-2025");
		invoiceSchedule.put("invoice10", "08-06-2025");
		invoiceSchedule.put("invoice11", "28-05-2025");
		invoiceSchedule.put("invoice12", "08-07-2025");
		invoiceSchedule.put("invoice13", "29-05-2025");
		
		InvoiceSystem invoiceSystem=new InvoiceSystem();
		
		
		invoiceSystem.invoiceScheduler(invoiceSchedule);
	}
	

}
