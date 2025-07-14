package problem.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class FlightProblem {
	
	
	Map<String,ArrayList<GraphNode>> graph=new LinkedHashMap<>();
	

	public void printall(String str) {
		
		String [] trips = str.split(",");
		
		for(String trip : trips) {
			
			String [] tripdata = trip.split(":");
			
			System.out.println("Source : "+tripdata[0]);
			System.out.println("Destination : "+tripdata[1]);
			System.out.println("Flight : "+tripdata[2]);
			System.out.println("Cost : "+tripdata[3]);
			System.out.println("----------------------------------------------");
			
		}
		
		
		
	}
	
	public void printgraph() {
		
		for(Map.Entry<String, ArrayList<GraphNode>> entry : graph.entrySet()) {
			
			System.out.print(entry.getKey());
			for(GraphNode graphNode : entry.getValue()) {				
				System.out.print("-->"+graphNode.destinatio);
			}
			
			System.out.println();
		}
		
	}
	
	public void createRoutGraph(String str) {
		
		String [] trips = str.split(",");
		
		for(String trip : trips) {
			
			String [] tripdata = trip.split(":");
			
			
			if(graph.containsKey(tripdata[0])) {				
				graph.get(tripdata[0]).add(new GraphNode(tripdata[1],tripdata[2],Integer.parseInt(tripdata[3])));
			}
			else {
				ArrayList<GraphNode> edge=new ArrayList<>();
			    edge.add(new GraphNode(tripdata[1],tripdata[2],Integer.parseInt(tripdata[3])));
				graph.put(tripdata[0],edge);
			}
					
		}
		
	}
	
	public static void main(String[] args) {
		
		String str= "UK:US:FedEx:4,UK:FR:Jet1:2,US:UK:RyanAir:8,CA:UK:CanadaAir:8";
		
		FlightProblem flightProblem=new FlightProblem();
		flightProblem.printall(str);
		
		flightProblem.createRoutGraph(str);
		flightProblem.printgraph();
		
		flightProblem.findRout("US", "FR");
		
	}
	
	
	public String findRout(String source, String destination) {
		
		Set<String>visited= new HashSet<>();
		Queue<RoutNode> queue = new LinkedList<>();
		RoutNode routNode = new RoutNode(source,new ArrayList<>(List.of(source)), new ArrayList<>(), 0);		
		queue.add(routNode);
		
		while(!queue.isEmpty()) {
			
			RoutNode current = queue.poll();
			
			if(current.airport.equals(destination)) {
				
				System.out.println(current.airport);
				System.out.println(current.path);
				System.out.println(current.method);
				System.out.println(current.totalcost);
			}
			
			
			visited.add(current.airport);
			
			
			for(GraphNode graphNode : graph.getOrDefault(current.airport,new ArrayList<>())) {
				
				if(!visited.contains(graphNode.destinatio)) {
					
					RoutNode path= new RoutNode();
					
					path.airport = graphNode.destinatio;
					
					current.path.add(graphNode.destinatio);
					
					path.path = new ArrayList<>();
					path.path.addAll(current.path);
					
					
					current.method.add(graphNode.flight);
					path.method = new ArrayList<>();
					path.method.addAll(current.method);
					
					current.totalcost += graphNode.cost;
					
					path.totalcost=current.totalcost;
					
					queue.add(path);
					
					
				}
				
			}
			
			
			
			
		}
		
		
		
		
		
		return null;
	}
	
	
	static class GraphNode{		
		String destinatio;
		String flight;
		int cost;
		
		public GraphNode() {}
		
		public GraphNode(String destinatio, String flight, int cost) {
			super();
			this.destinatio = destinatio;
			this.flight = flight;
			this.cost = cost;
		}
	}
	
	
	static class RoutNode{
		String airport;
		List<String> path;
		List<String> method;
		int totalcost;
		
		public RoutNode() {}
		
		public RoutNode(String airport, List<String> path, List<String> method, int totalcost) {
			super();
			this.airport = airport;
			this.path = path;
			this.method = method;
			this.totalcost = totalcost;
		}	
		
		
	}
}
