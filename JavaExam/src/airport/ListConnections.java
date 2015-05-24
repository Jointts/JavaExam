package airport;

import java.util.ArrayList;

public class ListConnections {
	
	public static ArrayList<FlightConnection> flightConnections = new ArrayList<FlightConnection>();
	
	public static void addConnection(FlightConnection flightConnection){
		flightConnections.add(flightConnection);
	}
	
}
