package tech;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Loadbalancer {
	
	Map<String,Integer> servers = new ConcurrentHashMap<>();
	List<RequestLog> log = new ArrayList<>();
	
	
	final int MAX_CAPASITY=100;
	int counter=0;
	
		
	public void registerServerInstance(int num) {		
		for(int i=0;i<num;i++)
			servers.put("instance"+i, 0);
	}
	
	public void serveRequest(String serverid,int requestid) {		
		servers.computeIfPresent(serverid, (k,v) -> v + 1 );		
	}
	
	public void completeRequest(String serverid,int requestid) {		
		servers.computeIfPresent(serverid, (k,v) -> v - 1 );				
	}
	
	
	public String getFreeInstance() {
		
		return servers.entrySet().stream().min(Comparator.comparingInt(Map.Entry::getValue))
		.get().getKey();
		
	}
	
	public void assignRequest(int requestid) {
		
		try {
			String instanceid = getFreeInstance();
			serveRequest(instanceid, requestid);
			RequestLog in = new RequestLog(instanceid, requestid, "SERVED", LocalDateTime.now());
			log.add(in);
			System.out.println(in.toString());
			Thread.sleep(100);
			completeRequest(instanceid, requestid);
			RequestLog out = new RequestLog(instanceid, requestid, "COMPLETED", LocalDateTime.now());
			log.add(out);
			System.out.println(out.toString());
			//printServerInstances();
			
		} catch (InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	
	public void printLog() {
		
		for(RequestLog requestLog : log) {
			System.out.println(requestLog.toString());
		}
		
	}
	
	public void printServerInstances() {
		for(Map.Entry<String, Integer> instances : servers.entrySet()) {
			System.out.println(instances.getKey()+" "+instances.getValue());
		}
	}
	
	class RequestLog{
		
		String instanceid;
		Integer requestId;
		LocalDateTime timestamp;
		String status;
		
		public RequestLog(String instanceid, Integer requestId,String status, LocalDateTime timestamp) {
			super();
			this.instanceid = instanceid;
			this.requestId = requestId;
			this.status = status;
			this.timestamp = timestamp;
		}

		@Override
		public String toString() {
			return "RequestLog [instanceid=" + instanceid + ", requestId=" + requestId + ", status="+status+", timestamp=" + timestamp
					+ "]";
		}
		
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Loadbalancer loadbalancer =new Loadbalancer();		
		loadbalancer.registerServerInstance(10);	
		
		
		ExecutorService executor = Executors.newFixedThreadPool(10);
		for (int i = 0; i < 1000; i++) {
		    final int reqId = i;
		    executor.submit(() -> loadbalancer.assignRequest(reqId));
		}
		executor.shutdown();
		
		
		
		
	}

}
