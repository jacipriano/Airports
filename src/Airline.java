import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Airline {
    private String code;
    private String name;

    /*public Airline(String code, String name) {
        this.code = code;
        this.name = name;
    }*/

    public static void loadAirlines(ArrayList<Airline> airlineArrayList) {

        FileRead fr = new FileRead();
        fr.init("data/airlines.csv");
        String line;
        Airline ar;
        int i=0;
do {
    line= fr.readLine();
    if (line!=null){
        if (i!=0){
            ar = new Airline();
            ar.buildAirline(line);
            airlineArrayList.add(ar);
        }
    }
    i++;
}while (line!=null);
fr.close();
    }

    @Override
    public String toString(){
        return ("{"+this.code+" "+name+"}");
    }
    private void buildAirline(String line) {
        StringTokenizer st = new StringTokenizer(line, ";");
        this.code= st.nextToken();
        this.name=st.nextToken();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
