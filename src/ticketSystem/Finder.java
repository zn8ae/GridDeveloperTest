package ticketSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Finder {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//init world
		Grid grid = new Grid();
		
		//get user input
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Please input Coordiantes:");
		String in = input.readLine();
		String[] coord = in.trim().split(",");
		Coordinate loc = new Coordinate(Integer.valueOf(coord[0]),Integer.valueOf(coord[1]));
		//check if coordinate is in the world
		while(loc.getX()<-10 || loc.getX() > 10 || loc.getY() < -10 || loc.getY()>10) {
			System.out.println("Location out of bounds. Please re-enter:");
			in = input.readLine();
			coord = in.trim().split(",");
			loc = new Coordinate(Integer.valueOf(coord[0]),Integer.valueOf(coord[1]));
		}
		
		System.out.println("Closest Events to (" + loc.getX() + "," + loc.getY() + "):");
		ArrayList<Coordinate> list = grid.getClosestEvents(loc);
		for(Coordinate c : list) {
			int dist = Math.abs(c.getX()-loc.getX()) + Math.abs(c.getY()-loc.getY());
			Event e = grid.getGrid().get(c);
			System.out.println("Event " + e.getId() + " - $" + e.getCheapest() + ", Distance " + dist);
		} 
		
	}

}
