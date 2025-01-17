package FlightControl.logic;

import FlightControl.domain.Airplane;
import FlightControl.domain.Flight;
import FlightControl.domain.Place;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class FlightControl {
    private HashMap<String, Airplane> airplanes;
    private HashMap<String, Flight> flights;
    private Map<String, Place> places;
    
    public FlightControl() {
        this.airplanes = new HashMap<>();
        this.flights = new HashMap<>();
        this.places = new HashMap<>();
    }
    
    public void addAirplane(String ID, int capacity) {
        Airplane airplane = new Airplane(ID, capacity);
        airplanes.put(ID, airplane);
    }
    
    public void addFlight(Airplane airplane, String departure, String target) {
        this.places.putIfAbsent(departure, new Place(departure));
        this.places.putIfAbsent(target, new Place(target));
        
        Flight flight = new Flight(airplane, this.places.get(departure), this.places.get(target));
        this.flights.put(flight.toString(), flight);                
    }
    
    public Collection<Airplane> getAirplanes() {
        return this.airplanes.values();
    }
    
    public Collection<Flight> getFlights() {
        return this.flights.values();
    }
    
    public Airplane getAirplane(String ID) {
        return this.airplanes.get(ID);
    }
}
