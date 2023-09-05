import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Flight {
    private int day;
    private int dayOfWeek;// = new String[]{"", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday","Sunday"};
    private String airline;
    private int flightNumber;
    private String originAirport;
    private String destinationAirport;
    private Time scheduledDeparture;
    private Time departureTime;
    private int departureDelay;
    private int scheduledTravelTime;
    private double distance;
    private Time scheduledArrival;
    private Time arrivalTime;
    private int arrivalDelay;

    private void buildFlight(String line, HashMap<String,Airport> airPortHM) {
        StringTokenizer st = new StringTokenizer(line, ";");


        this.day= Integer.parseInt(st.nextToken());
        this.dayOfWeek=Integer.parseInt(st.nextToken());
        this.airline= st.nextToken();
        this.flightNumber=Integer.parseInt(st.nextToken());
        this.originAirport= st.nextToken();
        this.destinationAirport=st.nextToken();
        this.scheduledDeparture= new Time(Integer.parseInt(st.nextToken()));
        this.departureTime=new Time(Integer.parseInt(st.nextToken()));
        this.distance= Integer.parseInt(st.nextToken());
        this.scheduledArrival=new Time(Integer.parseInt(st.nextToken()));
        this.arrivalTime= new Time(Integer.parseInt(st.nextToken()));



        this.scheduledTravelTime=Time.getTime(scheduledDeparture, airPortHM.get(originAirport).getTimezome(),scheduledArrival,airPortHM.get(destinationAirport).getTimezome() ); // FALTA ESTE!

    }

    public static void loadFlight (ArrayList<Flight> flightArrayList, HashMap<String,Airport> airPortHM){
        FileRead fr = new FileRead();
        fr.init("data/flights.csv");
        String line;
        Flight ar;
        int i=0;
        do {
            line= fr.readLine();
            if (line!=null){
                if (i!=0){
                    ar = new Flight();
                    ar.buildFlight(line, airPortHM);
                    flightArrayList.add(ar);
                }
            }
            i++;
        }while (line!=null);
        fr.close();
    }

    @Override
    public String toString() {
        return "Flight{" +
                "day=" + day +
                ", dayOfWeek=" + dayOfWeek +
                ", airline='" + airline + '\'' +
                ", flightNumber=" + flightNumber +
                ", originAirport='" + originAirport + '\'' +
                ", destinationAirport='" + destinationAirport + '\'' +
                ", scheduledDeparture=" + scheduledDeparture +
                ", departureTime=" + departureTime +
                ", departureDelay=" + departureDelay +
                ", scheduledTravelTime=" + scheduledTravelTime +
                ", distance=" + distance +
                ", scheduledArrival=" + scheduledArrival +
                ", arrivalTime=" + arrivalTime +
                ", arrivalDelay=" + arrivalDelay +
                '}';
    }
}
