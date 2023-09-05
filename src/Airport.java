import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Airport {
    private String iatacode;
    private String airport;
    private String city;
    private String state;
    private double latitude;
    private double longitude;
    private int timezome;

    public static void loadAirport (HashMap<String,Airport> airportHM){
            FileRead fr = new FileRead();
            fr.init("data/airports.csv");
            String line;
            Airport ar;
            int i=0;
            do {
                line= fr.readLine();
                if (line!=null){
                    if (i!=0){
                        ar = new Airport();
                        ar.buildAirport(line);
                        airportHM.put(ar.iatacode,ar);
                    }
                }
                i++;
            }while (line!=null);
            fr.close();
        }


    private void buildAirport(String line) {
        StringTokenizer st = new StringTokenizer(line, ";");
        this.iatacode= st.nextToken();
        this.airport=st.nextToken();
        this.city=st.nextToken();
        this.state=st.nextToken();
        this.latitude=Double.parseDouble(st.nextToken());
        this.longitude=Double.parseDouble(st.nextToken());
        this.timezome=Integer.parseInt(st.nextToken());

    }

    @Override
    public String toString() {
        return "{" +
                "iatacode='" + iatacode + '\'' +
                ", airport='" + airport + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", timezome=" + timezome +
                '}';
    }
}
