package problem.algo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RateLimit {
	
	
	static class LeakyBucket{		
		final int BUCKET_CAPACITY;
		final int REQUEST_PER_SECOND;		
		int current_level=0;  // process request increase, leak request decrease
		long last_time= System.currentTimeMillis();	
		
		public LeakyBucket(int capcity,int request_pre_second) {			
			this.BUCKET_CAPACITY = capcity;
			this.REQUEST_PER_SECOND = request_pre_second;
		}
		
		public void leak(){
			
			long current_time = System.currentTimeMillis();
			long elaps_time = current_time - last_time;
			int leak = (int) (elaps_time / (1000/REQUEST_PER_SECOND ));		
			if(leak > 0) {
				current_level = Math.max(0, current_level - leak);			
				last_time = current_time;
			}	
			
		}
		
		
		public synchronized boolean isAllow() {		
			
			leak();
			
			if(BUCKET_CAPACITY > current_level) {				
				current_level++;
				return true;
			}
			return false;			
		}
		
	}
	
	
	Map<String, LeakyBucket> userBucket = new ConcurrentHashMap();
	public synchronized boolean isRequestAllow(String user) {	
		System.out.println(user);
		userBucket.putIfAbsent(user, new LeakyBucket(5, 1));		
		return userBucket.get(user).isAllow();
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
		RateLimit rateLimit =new RateLimit();
		
		ExecutorService executorService = Executors.newFixedThreadPool(10); 
		
		for(int i=0;i<100;i++) {			
		 if(i%2==0)	
			 executorService.submit(()->{
				 System.out.println(rateLimit.isRequestAllow("user1")); 
			 });
		 else
			 executorService.submit(()->System.out.println(rateLimit.isRequestAllow("user2")));
		 Thread.sleep(100);	
		}
		

		 executorService.shutdown();
		
	}

}
