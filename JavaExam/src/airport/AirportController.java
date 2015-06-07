package airport;

import java.util.ArrayList;
import java.util.stream.Stream;

import airplane.Airplane;

public class AirportController {

	ArrayList<Airport> airportList = new ArrayList<Airport>();
	static int x;
	static ArrayList<Connection> yolo = new ArrayList<Connection>();
	static String midPoint;

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

	public Connection findConnection(String asked_connection) {

		String[] fromTo = asked_connection.split("-");
		String from = fromTo[0];
		String to = fromTo[1];

		Stream<FlightConnection> flightConnections = ListConnections.flightConnections
				.stream().filter(u -> u.connection.equals(asked_connection));
		flightConnections.forEach(u -> {
			System.out.println("------------------------------------");
			System.out.println("Route is: " + from + "-" + to);
		});

		Stream<FlightConnection> flightConnections2 = ListConnections.flightConnections
				.stream().filter(u -> u.connection.contains(from + "-"));
		flightConnections2
				.forEach(u -> {

					Stream<FlightConnection> flightConnections3 = ListConnections.flightConnections
							.stream().filter(
									v -> v.connection.contains(u.getTo() + "-"
											+ to));
					midPoint = from + "-" + u.getTo();
					
					Stream<FlightConnection> dummy = ListConnections.flightConnections
							.stream().filter(
									v -> v.connection.contains(u.getTo() + "-"
											+ to));
					midPoint = from + "-" + u.getTo();
					
					if(x==0){System.out.println("------------------------------------");
					System.out.println("Route is: " + u.connection + "-" + to);x++;}

					Stream<FlightConnection> flightConnections5 = ListConnections.flightConnections
							.stream();

					yolo.add(new Connection(flightConnections3.findFirst(),
							flightConnections5.filter(
									v -> v.connection.equals(midPoint))
									.findFirst()));

				});
		return yolo.get(0);

	}

	public int flightTime(String asked_connection) {

		Stream<FlightConnection> flightConnections = ListConnections.flightConnections
				.stream().filter(u -> u.connection.equals(asked_connection));
		
		Stream<FlightConnection> flightConnections2 = ListConnections.flightConnections
				.stream().filter(u -> u.connection.equals(asked_connection));
		
		if(flightConnections2.count()>0){

		flightConnections.forEach(u -> {
			double hoursDouble = (double) u.distance
					/ (double) u.airplane.getSpeed();
			if (u.airplane.getName() == "ATR-72" && u.distance < 700) {
				hoursDouble += 1 / 6;
			}
			double minutesDouble = hoursDouble / (1.0 / 60.0) % 60;
			int hours = (int) hoursDouble;
			int minutes = (int) minutesDouble;
			System.out.println("------------------------------------");
			System.out.println("Time to travel: " + hours + "h " + minutes
					+ "min");
			return;
		});
		}else{

		double speed1 = findConnection(asked_connection).getFirst().get().airplane
				.getSpeed();
		double distance1 = findConnection(asked_connection).getFirst().get().distance;
		double speed2 = findConnection(asked_connection).getSecond().get().airplane
				.getSpeed();
		double distance2 = findConnection(asked_connection).getSecond().get().distance;

		double hoursDouble1 = distance1 / speed1;
		if (findConnection(asked_connection).getFirst().get().airplane
				.getName() == "ATR-72"
				&& findConnection(asked_connection).getFirst().get().distance < 700.0) {
			hoursDouble1 += 0.15;
		}
		double hoursDouble2 = distance2 / speed2;
		if (findConnection(asked_connection).getSecond().get().airplane
				.getName() == "ATR-72"
				&& findConnection(asked_connection).getFirst().get().distance < 700.0) {
			hoursDouble2 += 0.15;
		}
		double hoursTotal = hoursDouble1 + hoursDouble2 + 0.75;
		double minutesTotal = hoursTotal / (1.0 / 60.0) % 60;
		int hours = (int) hoursTotal;
		int minutes = (int) minutesTotal;
		System.out.println("------------------------------------");
		System.out.println("Time to travel: " + hours + "h " + minutes + "min");

		return 0;
	}
		return 0;

	}
}
