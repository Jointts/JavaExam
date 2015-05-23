package airport;

import airplane.Airplane;

public class FlightConnection {
	
	int distance; 
	String service; 
	int price;
	Airplane airplane;
	String connection;
	
	public FlightConnection(String connection, int distance, String service, int price, Airplane airplane){
		this.distance = distance;
		this.service = service;
		this.price = price;
		this.airplane = airplane;
		this.connection = connection;
	}
}
