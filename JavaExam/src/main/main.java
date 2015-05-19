package main;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class main
{
    public static void main(String[] args) throws FileNotFoundException, IOException
    {
        InputStream in = new FileInputStream(new File("C:/temp/data.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        StringBuilder out = new StringBuilder();
        String line;
        for (int x = 1;(line = reader.readLine()) != null; x++) {
           
        	String[] sliceAndDice = line.split("([;]){1}");
            
            String airport = sliceAndDice[0];
            String country = sliceAndDice[1];
            String continent = sliceAndDice[2];
            String airfield_length = sliceAndDice[3];
            
            System.out.println("----------------------------");
            System.out.println("Airport name is: " + airport);
            System.out.println("Country name is: " + country);
            System.out.println("Continent is: " + continent);
            System.out.println("Airfield length is: " + airfield_length + "m");
        }
        //Prints the string content read from input stream
        reader.close();
    }
}