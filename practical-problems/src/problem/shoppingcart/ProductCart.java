package problem.shoppingcart;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class ProductCart {
	
	
	TreeMap<Integer,TreeMap<Integer,Double>> discount = new TreeMap<>();
	TreeMap<Integer,TreeMap<Integer,Double>> tiereddiscount = new TreeMap<>();
	
	public void init() {
		
		discount.put(1, new TreeMap<>());

		discount.get(1).put(1, 0.0);
		discount.get(1).put(11, 0.10);
		discount.get(1).put(21, 0.20);
		discount.get(1).put(31, 0.30);
		
		
		discount.put(2, new TreeMap<>());
		discount.get(2).put(1, 0.0);
		discount.get(2).put(21, 0.10);
		discount.get(2).put(41, 0.20);
		discount.get(2).put(61, 0.30);
		
		
		discount.put(3, new TreeMap<>());
		discount.get(3).put(1, 0.0);
		discount.get(3).put(21, 0.10);
		discount.get(3).put(41, 0.20);
		discount.get(3).put(61, 0.30);
		
		
		tiereddiscount.put(1, new TreeMap<>());

		tiereddiscount.get(1).put(1, 100.0);
		tiereddiscount.get(1).put(11, 90.0);
		tiereddiscount.get(1).put(21, 85.0);
		tiereddiscount.get(1).put(31, 80.0);
		
		
		tiereddiscount.put(2, new TreeMap<>());
		tiereddiscount.get(2).put(1, 110.0);
		tiereddiscount.get(2).put(21, 100.10);
		tiereddiscount.get(2).put(41, 90.20);
		tiereddiscount.get(2).put(61, 80.30);
		
		
		tiereddiscount.put(3, new TreeMap<>());
		tiereddiscount.get(3).put(1, 150.0);
		tiereddiscount.get(3).put(21, 140.10);
		tiereddiscount.get(3).put(41, 130.20);
		tiereddiscount.get(3).put(61, 120.30);
		
	}
	
	
	public double totalCost(List<Product> products) {
		return products.stream().mapToDouble(p->  p.price * p.qty).sum();			
	}
	
	public double totalCostWithdiscount(List<Product> products) {
		
		return products.stream().mapToDouble((p) -> {
			
			double discountPer=0.0;
			if(discount.containsKey(p.id)) 				
				discountPer = discount.get(p.id).floorEntry(p.qty).getValue();
				
			return p.qty*(p.price - (p.price*discountPer));	
						
		}).sum();
	}
	
	
	public double totalCostWithTiereddiscount(List<Product> products) {
		
		return products.stream().mapToDouble((p) -> {
			
			double newprice=0.0;
			if(tiereddiscount.containsKey(p.id)) { 				
				newprice = tiereddiscount.get(p.id).floorEntry(p.qty).getValue();
				return p.qty * newprice;
			}
				
			return p.qty*p.price;	
						
		}).sum();
	}
	
	
	static class Product{
		Integer id;
		Double price;
		Integer qty;
		
		public Product(Integer id, Double price,Integer qty) {
			super();
			this.id = id;
			this.price = price;
			this.qty =qty;
			
		}		
	}
	
	
	
	public static void main(String[] args) {
		
		List<Product> products = new ArrayList<>();
		products.add(new Product(1, 100.0d,50));
		products.add(new Product(2, 110.0d,10));
		products.add(new Product(3, 150.0d,15));
		products.add(new Product(4, 200.0d,4));
		products.add(new Product(5, 600.0d,5));
		products.add(new Product(6, 550.0d,2));
		
		ProductCart productCart = new ProductCart();
		productCart.init();
		System.out.println(productCart.totalCost(products));
		System.out.println(productCart.totalCostWithdiscount(products));
		System.out.println(productCart.totalCostWithTiereddiscount(products));
		
	}

}
