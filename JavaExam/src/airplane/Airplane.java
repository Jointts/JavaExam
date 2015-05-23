package airplane;

public class Airplane {

	int speed;
	int passengers;
	String name;

	public int flightLength(int flightDistance) {
		return flightDistance/speed;
	}
}
