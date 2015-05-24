package fileReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import airport.AirportController;

public class FileReader {

	public static void readText(AirportController airportController)
			throws IOException {

		Stream<String> stream = Files.lines(Paths.get("data.txt"));
		stream.forEach(u -> {
			String[] sliceAndDice = u.split("[;][\\s]");
			String airport = sliceAndDice[0];
			String country = sliceAndDice[1];
			String continent = sliceAndDice[2];
			String airfield_length = sliceAndDice[3].replaceAll("[;]", "");

			airportController.createAirport(airport, country, continent,
					airfield_length);
		});
		stream.close();
	}
}
