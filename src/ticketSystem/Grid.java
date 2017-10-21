package ticketSystem;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Random;

public class Grid {
	private final HashMap<Coordinate, Event> grid;

	public Grid() {
		grid = new HashMap<Coordinate, Event>();
		generateEvents();
	}

 
	public HashMap<Coordinate, Event> getGrid() {
		return grid;
	}


	private void generateEvents() {
		Random r = new Random();
		//Assumption: There will be 10 - 100 events in the world
		int eventNum = 10 + r.nextInt(91);
		for (int i = 0; i < eventNum; i++) {
			//location [-10,10]
			int x = -10 + r.nextInt(21);
			int y = -10 + r.nextInt(21);
			boolean flag = true;
			while(!grid.containsKey(new Coordinate(x,y)) && flag) {
				Event event = new Event();
				grid.put(new Coordinate(x,y), event);
				flag = false;
			}
		}
	}
	
	
	public ArrayList<Coordinate> getClosestEvents(Coordinate location){
		
		ArrayList<Coordinate> closest = new ArrayList<>();
		//you can get distances and corresponding coordinates
		//you need 5 closest points
		PriorityQueue<Coordinate> queue = new PriorityQueue<Coordinate>(5, new Comparator<Coordinate>() {
			@Override
			public int compare(Coordinate c1, Coordinate c2) {
				// TODO Auto-generated method stub
				int d1 = Math.abs(c1.getX()-location.getX()) + Math.abs(c1.getY()-location.getY());
				int d2 = Math.abs(c2.getX()-location.getX()) + Math.abs(c2.getY()-location.getY());
				return Integer.compare(d1, d2);
			}
		});
	
		for(Coordinate c : grid.keySet()) {
			queue.add(c);
		}

		while(closest.size()<5) {
			//Assumption: if no ticket available doesnt count
			Coordinate c = queue.poll();
			Event e = grid.get(c);
			if(!e.getTickets().isEmpty())
				closest.add(c);
		}
		return closest;
	}
	
	
	
}
