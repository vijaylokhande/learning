package problem.shoppingcart;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class CartOperation {
	
	LinkedHashMap<String, Double> regiontax=new LinkedHashMap<>();
	
	public CartOperation() {
		// TODO Auto-generated constructor stub
		
		regiontax.put("en_us", 10.00);
		regiontax.put("de_de", 10.00);
		regiontax.put("en_gb", 10.00);
	}
	
	
	
	public Map<String, Double> calculateTotal(CartOperation.Cart cart){
		
		LinkedHashMap<String, Double> summarymap = new LinkedHashMap<>();
		
		List<Cart.Item> items= cart.getItems();
		
	
		
		
		
		return summarymap;
	}
	
	
	public static void main(String[] args) {
		
		
	}
	
	
	
	
	static class Cart {
		
		private UUID cartid;
		private List<Cart.Item> items;	
		private String locale;
		

		static class Item{		

			UUID itemid;
			Double price;
			
			public UUID getItemid() {
				return itemid;
			}
			public void setItemid(UUID itemid) {
				this.itemid = itemid;
			}
			public Double getPrice() {
				return price;
			}
			public void setPrice(Double price) {
				this.price = price;
			}
		}

		public UUID getCartid() {
			return cartid;
		}

		public void setCartid(UUID cartid) {
			this.cartid = cartid;
		}

		public List<Cart.Item> getItems() {
			return items;
		}

		public void setItems(List<Cart.Item> items) {
			this.items = items;
		}
		

		public String getLocale() {
			return locale;
		}

		public void setLocale(String locale) {
			this.locale = locale;
		}
	} 

}
