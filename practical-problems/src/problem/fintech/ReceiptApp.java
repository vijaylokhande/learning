package problem.fintech;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ReceiptApp {
	
	public static void main(String[] args) {
		
		Receipt receipt = new Receipt();
		receipt.id=UUID.randomUUID();
		
		receipt.receiptItems= new ArrayList<>();
		
		receipt.receiptItems.add(new ReceiptItems(UUID.randomUUID(), "A", 100.0d, 0.05d, 0.0, 1));
		receipt.receiptItems.add(new ReceiptItems(UUID.randomUUID(), "B", 110.0d, 0.15d, 0.0, 10));
		receipt.receiptItems.add(new ReceiptItems(UUID.randomUUID(), "C", 120.8d, 0.065d, 0.0, 16));
		receipt.receiptItems.add(new ReceiptItems(UUID.randomUUID(), "D", 140.0d, 0.05d, 0.0, 18));
		receipt.receiptItems.add(new ReceiptItems(UUID.randomUUID(), "E", 300.5d, 0.07d, 0.0, 1));
		receipt.receiptItems.add(new ReceiptItems(UUID.randomUUID(), "F", 600.0d, 0.12d, 0.0, 8));
		receipt.receiptItems.add(new ReceiptItems(UUID.randomUUID(), "G", 60.0d, 0.035d, 0.0, 9));
		receipt.receiptItems.add(new ReceiptItems(UUID.randomUUID(), "H", 10.0d, 0.045d, 0.0, 5));
		receipt.receiptItems.add(new ReceiptItems(UUID.randomUUID(), "I", 17.0d, 0.025d, 0.0, 2));
		receipt.receiptItems.add(new ReceiptItems(UUID.randomUUID(), "J", 17.5d, 0.01d, 0.0, 1));
		
		
		System.out.println(receipt.calculateTotal());
		
	}
	
	
	interface ReceptBuilder{
		double calculateTotal();
	}
	
	static class Receipt implements ReceptBuilder{		
		UUID id;		
		List<ReceiptItems> receiptItems;
		
		@Override
		public double calculateTotal() {
			return receiptItems.stream().mapToDouble(item->{
				return item.calculateTotal();
			}).sum();
		}
		
	}
	
	interface ReceptItemBuilder{
		
		double calculateTotal();
		
		
	}
	
	static class ReceiptItems implements ReceptItemBuilder{
		
		UUID id;
		String item;
		double price;
		double tax;
		double discount;
		int qty;
		
		public ReceiptItems(UUID id, String item, double price, double tax, double discount, int qty) {
			super();
			this.id = id;
			this.item = item;
			this.price = price;
			this.tax = tax;
			this.discount = discount;
			this.qty = qty;
		}

		public ReceiptItems() {
			// TODO Auto-generated constructor stub
		}
		
		
		@Override
		public double calculateTotal() {	
			double totalprice = (price * qty);
			double totaldiscount= totalprice * discount;
			double totaltax = totalprice * tax;		
			return (totalprice - totaldiscount ) + totaltax;
		}
		
	}

}
