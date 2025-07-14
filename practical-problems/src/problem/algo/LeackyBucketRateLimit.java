package problem.algo;

import java.util.LinkedHashMap;

public class LeackyBucketRateLimit {
	
	static class LeackyBucket {
		
		final int CAPACITY;
		final double REAQUEST_PER_SECONDS;		
		int current_level = 0;
		long last_time= System.currentTimeMillis();
		
		public LeackyBucket(int capacity,double leak_rate_per_second) {			
			this.CAPACITY=capacity;
			this.REAQUEST_PER_SECONDS=leak_rate_per_second;			
		}		
		
		public void leak() {			
			long current_time=System.currentTimeMillis();			
			long elaps_time= current_time - last_time;			
			int leak_requests= (int) ((elaps_time / 1000.0 ) * REAQUEST_PER_SECONDS);			
			if(leak_requests > 0) {			
				current_level = Math.max(0, current_level - leak_requests);
				last_time = current_time;
			}
		}
		
		public synchronized boolean isRequestAllow() {			
			leak();
			
			if(current_level < CAPACITY) {
				current_level++;
				return true;
			}		
			return false;
		}		
	}
	
	
	LinkedHashMap<String, LeackyBucket> userBucket = new LinkedHashMap<>();
	
	public synchronized boolean isAllow(String userid) {
		
		userBucket.putIfAbsent(userid, new LeackyBucket(5,0.5));
		
		return userBucket.get(userid).isRequestAllow();
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		
	
		LeackyBucketRateLimit bucketRateLimit =new LeackyBucketRateLimit();
		
		int t=0;
		for(int i=0;i<30;i++) {
		
			if(bucketRateLimit.isAllow("user1")) {
				t++;
			} 
			Thread.sleep(1000);
		}
		
		
	}

}
