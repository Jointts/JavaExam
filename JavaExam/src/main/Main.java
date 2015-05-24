package main;

import java.io.IOException;

import airplane.ATR72;
import airport.AirportController;
import airport.ListConnections;
import fileReader.FileReader;

public class Main {
	public static void main(String[] args) throws IOException {
		AirportController airportController = new AirportController();
		FileReader.readText(airportController);
		
		//airportController.getFilteredAirportList("Tallinn Airport");
		//airportController.getAirportList();
		
		airportController.addAirportConnection("Prague-Ankara", 600, "Estonian Air", 119, new ATR72());
		airportController.addAirportConnection("Tallinn-Prague", 600, "Estonian Air", 119, new ATR72());
		airportController.displayAllConnections();
		//airportController.flightTime("Tallinn-Ankara");
		airportController.findConnection("Tallinn-Ankara");
	}
}