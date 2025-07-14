package problem.string;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Logger {
	
	
	public List<String> processLogs(String [] logs){
		
		List<String> result=new ArrayList<>();
		List<LogEntry> loglist=new ArrayList<>();
		//yyyy-MM-dd hh:mm:ss 
		Pattern pattern = Pattern.compile("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
		
		for(int i=0;i<logs.length;i++) {
			
			Matcher matcher = pattern.matcher(logs[i]);
			if(matcher.find()) {
			String timestamp=matcher.group();	
			String msg=logs[i].trim();			
			loglist.add(new LogEntry(LocalDateTime.parse(timestamp,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), msg));
			
			}
		}
		
		
		loglist.sort(Comparator.comparing(LogEntry::getDateTime));
		
		for(LogEntry entry : loglist) {
			result.add(entry.message);
		}
		
		return result;
	}
	
	static class LogEntry{
		LocalDateTime dateTime;
		String message;
		
		public LogEntry() {}
		
		public LogEntry(LocalDateTime dateTime, String message) {
			super();
			this.dateTime = dateTime;
			this.message = message;
		}

		public LocalDateTime getDateTime() {
			return dateTime;
		}

		public String getMessage() {
			return message;
		}

		
		
	}
	
	
	public static void main(String[] args) {
		
		
		String [] logs = new String [] {				
				
				"2025-07-05 10:30:45 INFO: Server started",
	            "2025-07-05 09:15:30 WARN: Disk space low",
	            "2025-07-04 23:59:59 ERROR: Shutdown failure",
				"2025-07-02 10:30:45 INFO: Server started",
	            "2025-07-01 09:15:30 WARN: Disk space low",
	            "2025-07-15 23:59:59 ERROR: Shutdown failure"						
		};
		
		
		Logger logger=new Logger();
		
		System.out.println(logger.processLogs(logs));
		
		
	}

}
