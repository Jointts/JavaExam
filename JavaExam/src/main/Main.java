package main;

import java.io.IOException;

import airport.Airport;
import airport.AirportController;
import fileReader.FileReader;

public class Main {
	public static void main(String[] args) throws IOException {
		AirportController airportController = new AirportController();
		FileReader.readText(airportController);
		airportController.getFilteredAirportList("Tallinn Airport");
		airportController.getAirportList();
	}
}