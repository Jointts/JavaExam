package main;

import java.io.IOException;

import airport.AirportController;
import fileReader.FileReader;

public class Main {
	public static void main(String[] args) throws IOException {
		AirportController airportController = new AirportController();
		FileReader.readText(airportController);
		airportController.getFilteredAirportList("Estonia");
		airportController.getAirportList();
	}
}