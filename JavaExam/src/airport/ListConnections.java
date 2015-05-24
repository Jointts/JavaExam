package airport;

import java.util.ArrayList;

public class ListConnections {
	
	static ArrayList<FlightConnection> flightConnections = new ArrayList<FlightConnection>();
	
	public static void addConnection(FlightConnection flightConnection){
		flightConnections.add(flightConnection);
	}
}
