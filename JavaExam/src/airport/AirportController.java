package airport;

import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class AirportController {
	
	static ArrayList<Airport> airportList = new ArrayList<Airport>();
	String filteredText;
	
	Predicate<Airport> filterAirport = u -> u.getAirport() == filteredText;
    Predicate<Airport> filterCountry = u -> u.getCountry() == filteredText;
    Predicate<Airport> filterContinent = u -> u.getContinent() == filteredText;
    Predicate<Airport> filterLength = u -> u.getAirfieldLength() == filteredText;
	Predicate<Airport> fullFilter = filterAirport.or(filterCountry).or(filterContinent).or(filterLength);
	
	public void createAirport(String airport, String country, String continent, String airfield_length){
		airportList.add(new Airport(airport, country, continent, airfield_length));

	}
	
	public void getAirportList(){
		Stream <Airport> airportStream = airportList.stream();
		airportStream.forEach(u -> u.displayInfo());
	}
	
	public void getFilteredAirportList(String filteredText){
		this.filteredText = filteredText;
		System.out.println(filteredText);
		Stream<Airport> airportFilteredStream = airportList.stream().filter(filterCountry);
		airportFilteredStream.forEach(u -> u.displayInfo());
	}
}
