package problem.shoppingcart;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class ShopingCart {
	
	public List<OrderDTO> parseData(String json){
		List<OrderDTO> input=new ArrayList<>();
		
		json=json
		.replace("[", "")
		.replace("]", "")
		.replace("{", "")
		.replace("}", "");
		
		json= json.trim();
		
		
		String[] dataarray=json.split(",");
		
		String orderId = null;
		String country = null;
		Double shippingCostPerUnit =null;
		Integer quantity = null;
		
		
		for(String line : dataarray) {
			
			line =line.trim();
			
			String kv[]= line.split(":");
			
			kv[0]=kv[0].trim();
			
			if(kv[0].equals("\"orderId\"")) {				
				orderId=kv[1].trim();
			}
			
			if(kv[0].equals("\"country\"")) {
				country=kv[1].trim();
			}
			
			if(kv[0].equals("\"shippingCostPerUnit\"")) {				
				shippingCostPerUnit=Double.valueOf(kv[1].trim());
			}
			
			if(kv[0].equals("\"quantity\"")) {
				quantity=Integer.parseInt(kv[1].trim());				
				
				OrderDTO dto= new OrderDTO(orderId, country, shippingCostPerUnit, quantity);
					
				input.add(dto);
				 
			}
						
			
		}
		
		
		
		System.out.println(input);
		
		return input;
	}
	
	
	public Map<String,Double> getTotalByOrder(List<OrderDTO> orders){
		
		Map<String,Double> checkout = 
		 orders.stream().collect(Collectors.groupingBy(o -> o.orderId, Collectors.summingDouble(o->o.quantity*o.shippingCostPerUnit)));
				
		return checkout;
	}
	
	
	public Map<String,Double> getTotalByCountry(List<OrderDTO> orders){
		
		Map<String,Double> checkout = 
		 orders.stream().collect(Collectors.groupingBy(o -> o.country, Collectors.summingDouble(o->o.quantity*o.shippingCostPerUnit)));
				
		return checkout;
	}
	
	static class OrderDTO {
		
		String orderId;
		String country;
		Double shippingCostPerUnit;
		Integer quantity;
		
		public OrderDTO() {}
		
		public OrderDTO(String orderId, String country, Double shippingCostPerUnit, Integer quantity) {
			super();
			this.orderId = orderId;
			this.country = country;
			this.shippingCostPerUnit = shippingCostPerUnit;
			this.quantity = quantity;
		}
	}

	
	public static void main(String[] args) {
		
		String s="1,\"ccc\"";
		
		String json = """
					[
				          {
		            	    "orderId": "ORD001",
		            	    "country": "US",
		            	    "shippingCostPerUnit": 5.5,
		            	    "quantity": 10
		            	  },
		            	  {
		            	    "orderId": "ORD002",
		            	    "country": "DE",
		            	    "shippingCostPerUnit": 4.0,
		            	    "quantity": 7
		            	  },
		            	  {
		            	    "orderId": "ORD001",
		            	    "country": "US",
		            	    "shippingCostPerUnit": 5.5,
		            	    "quantity": 3
		            	  }
		            ]
		            """;
		
		
			ShopingCart cart=new ShopingCart();
			
			List<OrderDTO> orders = cart.parseData(json);
			
			System.out.println(cart.getTotalByOrder(orders));
			System.out.println(cart.getTotalByCountry(orders));
		
	}
}
