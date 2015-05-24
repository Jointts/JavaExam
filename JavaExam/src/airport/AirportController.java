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

	public void getAirportList() {
		Stream<Airport> airportStream = airportList.stream();
		airportStream.forEach(u -> u.displayInfo()); // returns Turkey
	}

	public void getFilteredAirportList(String filteredText) {
		Stream<Airport> airportFilteredList = airportList.stream().filter(
				u -> u.getCountry().equals(filteredText)
						|| u.getAirport().equals(filteredText)
						|| u.getContinent().equals(filteredText)
						|| u.getAirfieldLength().equals(filteredText));
		airportFilteredList.forEach(u -> u.displayInfo());

	}

	public void addAirportConnection(String connection, int distance,
			String service, int price, Airplane airplane) {
		new FlightConnection(connection, distance, service, price, airplane);
	}

	public void displayAllConnections() {
		ListConnections.flightConnections.forEach(u -> {
			u.displayInfo();
		});
	}

	public void findConnection(String asked_connection) {

		String[] fromTo = asked_connection.split("-");
		String from = fromTo[0];
		String to = fromTo[1];

		Stream<FlightConnection> flightConnections = ListConnections.flightConnections
				.stream().filter(u -> u.connection.equals(asked_connection));
		flightConnections.forEach(u -> {
			System.out.println("From: " + from + "\nTo: " + to);
		});
		
		Stream<FlightConnection> flightConnections2 = ListConnections.flightConnections
				.stream();
		flightConnections2.forEach(u -> {
			if(u.connection.contains(from + "-")){
				Stream<FlightConnection> flightConnections3 = ListConnections.flightConnections
						.stream();
				for(FlightConnection v : ListConnections.flightConnections)
					if(v.connection.contains(u.getTo() + "-" + to)){String route = "Route is: " + u.connection + "-" + to; System.out.println(route); return;}
				;};
		});

	}

	public int flightTime(String asked_connection) {

		Stream<FlightConnection> flightConnections = ListConnections.flightConnections
				.stream().filter(u -> u.connection.equals(asked_connection));
		flightConnections.forEach(u -> {
			double hoursDouble = (double) u.distance
					/ (double) u.airplane.getSpeed();
			double minutesDouble = hoursDouble / (1.0 / 60.0) % 60;
			int hours = (int) hoursDouble;
			int minutes = (int) minutesDouble;
			System.out.println(hours + "h " + minutes + "min");
		});
		return 0;

	}
}
