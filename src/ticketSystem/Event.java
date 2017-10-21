package ticketSystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {
	static AtomicInteger idGenerator = new AtomicInteger();
	private final int id;
	private final ArrayList<Ticket> tickets;
	
	public Event() {
		id = idGenerator.incrementAndGet();
		tickets = new ArrayList<Ticket>();
		generateTickets();
	}
	
	public int getId() {
        return id;
    }
	
	public ArrayList<Ticket> getTickets() {
        return tickets;
    }
	
	private void generateTickets() {
		Random rd = new Random();
		//assumption; 0-20 tickets
		int n = rd.nextInt(21);
		
		if(n>0) {
			for(int i = 0;i < n; i++) {
				Ticket t = new Ticket();
				tickets.add(t);
			}
		}
		Collections.sort(tickets);
	}
	
	public double getCheapest(){
        return tickets.get(0).getPrice();
    }
	
}
