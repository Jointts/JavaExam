package airport;

public class Airport {
	
	String airport;
	String country;
    String continent;
    String airfield_length;
    int passengers = 0;
    
    public Airport(String airport, String country, String continent, String airfield_length){
    	this.airport = airport;
    	this.country = country;
    	this.continent = continent;
    	this.airfield_length = airfield_length;
    }
    
    public void displayInfo(){
    	System.out.println("----------------------------");
        System.out.println("Airport name is: " + airport);
        System.out.println("Country name is: " + country);
        System.out.println("Continent is: " + continent);
        System.out.println("Airfield length is: " + airfield_length + "m");
    }
    
    public String getAirport(){
    	return airport;
    }
    
    public String getCountry(){
    	return country;
    }
    
    public String getContinent(){
    	return continent;
    }
    
    public String getAirfieldLength(){
    	return airfield_length;
    }
    
    public int getPassengers(){
    	return passengers;
    }
	
}
