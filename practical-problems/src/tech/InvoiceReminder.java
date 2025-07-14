package tech;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
 * before 10 days of invoice -  invoice will be available after 10 days
 * on the days of invoice -  invoice available 
 * after 20 days of invoice -  reminder for payment
 * after 30 days of invoice - notice for payment
 */
public class InvoiceReminder {
	
	TreeMap<Long,String> reminderMap;
	
	public InvoiceReminder() {
		reminderMap = new TreeMap<>();
		reminderMap.put(-10l,"Invoice will be available after 10 days");
		reminderMap.put(0l,"Invoice available");
		reminderMap.put(20l,"Reminder for payment");
		reminderMap.put(30l,"Notice for payment");
	}
	
	
	public String getSubjectLine(String date) {		
		LocalDate currentdate = LocalDate.now();
		LocalDate invoicedate = LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		long days=ChronoUnit.DAYS.between(invoicedate,currentdate);
		
		
		return reminderMap.get(reminderMap.floorKey(days));
	}
	
	
	public static void main(String[] args) {
		
		 
		InvoiceReminder invoiceReminder = new InvoiceReminder();
		
		System.out.println(invoiceReminder.getSubjectLine("05-07-2025"));
		System.out.println(invoiceReminder.getSubjectLine("15-06-2025"));
		System.out.println(invoiceReminder.getSubjectLine("15-07-2025"));
		System.out.println(invoiceReminder.getSubjectLine("05-06-2025"));
		
	}
	
	

}
