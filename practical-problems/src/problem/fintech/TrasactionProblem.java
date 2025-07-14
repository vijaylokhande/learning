package problem.fintech;

import java.util.ArrayList;
import java.util.List;

public class TrasactionProblem {
		
	
	static class Account{
		double balance;
		List<Trasaction> transactions;		
		
		public Account() {
			// TODO Auto-generated constructor stub
		}
		
		public double calculateBalance() {		
			
			return this.transactions.stream().mapToDouble(txn ->{				
				double fees = (txn.feesPercentage) * txn.amount;				
				if(txn.type.equals("CR")) {
					return (txn.amount - fees);
				}
				else if(txn.type.equals("DR")) {
				    return -(txn.amount + fees);
				}
				throw new IllegalArgumentException("invalid fees");
			}).reduce(this.balance , Double::sum);				
		}
		
	}
	static class Trasaction{
		String type;
		double amount;
		double feesPercentage;
		
		public Trasaction(String type, double amount, double feesPercentage) {
			super();
			this.type = type;
			this.amount = amount;
			this.feesPercentage = feesPercentage;
		}		
		
	}
	
	
	public static void main(String[] args) {
		
		Account account = new Account();
		account.balance=1000.d;
		
		account.transactions = new ArrayList<>();
		account.transactions.add(new Trasaction("CR", 100.0d, 0.025d));
		account.transactions.add(new Trasaction("DR", 200.0d, 0.025d));
		account.transactions.add(new Trasaction("CR", 107.0d, 0.025d));
		account.transactions.add(new Trasaction("DR", 105.0d, 0.025d));
		account.transactions.add(new Trasaction("DR", 5.0d, 0.025d));
		account.transactions.add(new Trasaction("CR", 600.0d, 0.025d));
		account.transactions.add(new Trasaction("DR", 10.8d, 0.025d));
		account.transactions.add(new Trasaction("CR", 9.9d, 0.025d));
		account.transactions.add(new Trasaction("DR", 13.4d, 0.025d));
		account.transactions.add(new Trasaction("DR", 27.7d, 0.025d));
		
		System.out.println(account.calculateBalance());
	
		
	}

}
