package problem.shoppingcart;

import java.util.TreeMap;

public class Test {

	
	public static void main(String[] args) {
		
		TreeMap<Integer, Double> discount = new TreeMap<>();
		
		discount.put(0, 0.0);
		discount.put(5, 0.02);
		discount.put(10,0.05);
		discount.put(20,0.1);
		discount.put(50,0.4);
		
		
		System.out.println(100.0 -discount.floorEntry(3).getValue()*100.0);
		System.out.println(100.0 -discount.floorEntry(6).getValue()*100.0);
		System.out.println(100.0 -discount.floorEntry(15).getValue()*100.0);
		System.out.println(100.0 -discount.floorEntry(23).getValue()*100.0);
		System.out.println(100.0 -discount.floorEntry(56).getValue()*100.0);
		
	}
}
