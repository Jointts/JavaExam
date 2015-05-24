package airport;

import java.util.ArrayList;

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
		ListConnections.addConnection(this);
	}
	
	public void displayInfo(){
		
		System.out.println("----------------------------");
		
		System.out.println("Flight: " + connection);
		System.out.println("Distance: " + distance + "km");
		System.out.println("Service: " + service);
		System.out.println("Price: " + price + "€");
		System.out.println("Airplane: " + airplane.getName());
	}
	
	public String getFrom(){
		String[] connection = this.connection.split("-");		
		return connection[0];
	}
	
	public String getTo(){
		String[] connection = this.connection.split("-");		
		return connection[1];
	}
}
