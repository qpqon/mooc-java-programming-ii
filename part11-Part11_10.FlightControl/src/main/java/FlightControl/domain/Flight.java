package FlightControl.domain;

/**
* This code is free to use, modify, and distribute under the MIT License.
* See LICENSE file for details.
* 
* Course: https://java-programming.mooc.fi/
*
* @author Daniel Menke
* 
*/
public class Flight {
    Airplane airplane;
    Place departureAirport;
    Place targetAirport;
    
    public Flight(Airplane airplane, Place departureAirport, Place targetAirport) {
        this.airplane = airplane;
        this.departureAirport = departureAirport;
        this.targetAirport = targetAirport;
    }

    public Airplane getAirplane() {
        return airplane;
    }

    public Place getDepartureAirport() {
        return departureAirport;
    }

    public Place getTargetAirport() {
        return targetAirport;
    }

    @Override
    public String toString() {
        return this.airplane.toString() 
                + " (" + this.departureAirport 
                + "-" + this.targetAirport + ")";
    }
    
    
}
