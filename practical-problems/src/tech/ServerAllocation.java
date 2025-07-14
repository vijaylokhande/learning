package tech;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ServerAllocation {
	
	
	Set<Integer> allocatedServers;
	PriorityQueue<Integer> availableServers;
	int count;
	
	
	public ServerAllocation() {
		// TODO Auto-generated constructor stub
	}
	
	public ServerAllocation(int capacity) {
		
		this.allocatedServers = new HashSet<>(capacity);
		this.availableServers = new PriorityQueue<>();
		count=0;
		
	}
	
	
	public int serverAllocate() {
		
		if(!availableServers.isEmpty()) {
			allocatedServers.add(availableServers.poll());
		}
		else {
			count++;
			allocatedServers.add(count);
		}	
		
		System.out.println(allocatedServers.toString());
		System.out.println(availableServers.toString());
		return count;
	}
	
	public void serverRelease(int serverid) {
		
		if(allocatedServers.contains(serverid)) {			
			allocatedServers.remove(serverid);			
			availableServers.offer(serverid);
		}

		System.out.println(allocatedServers.toString());
		System.out.println(availableServers.toString());
		
	}
	
	
	public static void main(String[] args) {
		
		ServerAllocation manager = new ServerAllocation(10);
		
		manager.serverAllocate();
		manager.serverAllocate();
		manager.serverAllocate();
		manager.serverAllocate();
		manager.serverAllocate();
		manager.serverAllocate();
		
		manager.serverRelease(1);
		manager.serverRelease(2);
		manager.serverRelease(3);
		

		manager.serverAllocate();
		manager.serverAllocate();
		manager.serverAllocate();
		

		manager.serverRelease(4);
		manager.serverRelease(5);
		manager.serverRelease(6);
		
		
		
		
		
	}

}
