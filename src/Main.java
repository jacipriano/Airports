import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        ArrayList<Airline> airLineList = new ArrayList<>();
        Airline.loadAirlines(airLineList);

        HashMap<String,Airport> airportHM = new HashMap<>();
        Airport.loadAirport(airportHM);

        ArrayList<Flight> FlightList = new ArrayList<>();
        Flight.loadFlight(FlightList, airportHM);


        /*
        for (String st : airportHM.keySet()) {
            System.out.println(airportHM.get(st).toString());
        }*/
        for (Flight ft: FlightList){
            System.out.println(ft.toString());
        }
    }

}
