package problem.fintech;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CurrencyConvertor {	
	
	Map<String , List<CurrencyNode>> graph = new LinkedHashMap<>(); 
	
	public void createCurrencyGraph(String [][] currencyexchange,double [] currencyexchangerate) {		
		int r=currencyexchange.length;		
		for(int i=0;i<r;i++) {						
			graph.computeIfAbsent(currencyexchange[i][0], k -> new ArrayList<CurrencyNode>()).add(new CurrencyNode(currencyexchange[i][1], currencyexchangerate[i]));
		}
	}
	
	
	public double currencyExchange(String currency1,String currency2) {
		
		double exchange=1.0;
		Queue<CurrencyNode> queue = new LinkedList<>();
		queue.add(new CurrencyNode(currency1, 1.0));
		Set<String>visit=new HashSet<>();
		
		
		while(!queue.isEmpty()) {
			
			CurrencyNode current = queue.poll();
			visit.add(current.currency);
			System.out.println(currency1+" "+current.currency+" = "+current.rate);
			
			
			
			if(current.currency.equals(currency2)) {
				return current.rate;
			}
			
			for(CurrencyNode currencyNode : graph.getOrDefault(current.currency, new ArrayList<>())) {				
				if(!visit.contains(currencyNode.currency)) {
					
					CurrencyNode node = new CurrencyNode(currencyNode.currency, currencyNode.rate * current.rate);
					
					queue.add(node);
				}
			}
			
			
		}
		
		
		return exchange;
	}
	
	
	static class CurrencyNode{
		String currency;
		double rate;
		public CurrencyNode(String currency, double rate) {
			super();
			this.currency = currency;
			this.rate = rate;
		}
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		String [][] currencyexchange = new String[][] 
				{{"USD","INR"},{"INR","EUR"},{"EUR","JPY"}};		
		double [] currencyexchangerate = new double[] { 85.50 , 0.0099 , 169.23 };
		
		CurrencyConvertor currencyConvertor = new CurrencyConvertor();
		currencyConvertor.createCurrencyGraph(currencyexchange, currencyexchangerate);
		
		System.out.println(currencyConvertor.currencyExchange("EUR", "INR"));
		
	}

}
