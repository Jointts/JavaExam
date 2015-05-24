package airport;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Stream;

import airplane.Airplane;

public class AirportController {
	
	ArrayList<Airport> airportList = new ArrayList<Airport>();

	public void createAirport(String airport, String country, String continent,
			String airfield_length) {
		airportList.add(new Airport(airport, country, continent,
				airfield_length));

	}
	
	public void getAirportList(){
		Stream <Airport> airportStream = airportList.stream();
		airportStream.forEach(u -> u.getCountry()); //returns Turkey
	}
	
	public void getFilteredAirportList(String filteredText){
	    Stream<Airport> airportFilteredList = airportList.stream().filter(
	            u -> u.getCountry().equals(filteredText) || u.getAirport().equals(filteredText) || u.getContinent().equals(filteredText) || u.getAirfieldLength().equals(filteredText));
	    airportFilteredList.forEach(u -> u.displayInfo());
	    
	}
	
	public void addAirportConnection(String from, String to, int distance, String service, int price, Airplane airplane){
		
	}
	
}
