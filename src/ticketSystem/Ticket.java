package ticketSystem;

import java.text.DecimalFormat;
import java.util.Random;

public class Ticket implements Comparable {

	Double price;
	
	public Ticket() {
		Random r = new Random();
		//price assumption
		double amount = 1 + (1000-1) * r.nextDouble();
		DecimalFormat formatter = new DecimalFormat("#0.00");
		price = Double.valueOf(formatter.format(amount));
	}
	
	public Double getPrice() {
		return price;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Ticket ticket = (Ticket)o;	
		return this.price.compareTo(ticket.price);
	}
}
