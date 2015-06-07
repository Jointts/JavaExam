package airport;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

public class Connection {
	
	ArrayList<Optional<FlightConnection>> all = new ArrayList();
	
	public Connection(Optional<FlightConnection> optional, Optional<FlightConnection> optional2){
		all.add(optional);
		all.add(optional2);
	}
	
	public Connection(Optional<FlightConnection> flight1){
		
	}
	
	public Optional<FlightConnection> getFirst(){
		return all.get(0);
	}
	
	public Optional<FlightConnection> getSecond(){
		return all.get(1);
	}
}
