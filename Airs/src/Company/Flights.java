package Company;

/**
 * Created by Asus on 13.10.2016.
 */
public class Flights {
    private static String from;
    private static String to;
    private static String date;
    public Flights(String from,String to, String date ) {
        this.from = from;
        this.to = to;
        this.date=date;
    }
    public String ToString(){
        return "from " + this.from + " - to" + this.from + " - in - " + date;
    }
}
