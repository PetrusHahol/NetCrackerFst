package Company;

/**
 * Created by Asus on 13.10.2016.
 */
public class Flights {
    private String from;
    private String to;
    private String date;

    public Flights(String from,String to, String date ) {
        this.from = from;
        this.to = to;
        this.date=date;
    }

    public String toString(){
        return ("From " +from + " - to - " + to+ " - in - " + date);
    }

    public int hashCode() {
        final int prime = 43;
        int result = 1;
        int mod = 1000000007;
        for (int i=0; i<from.length(); i++){
            result=prime*result+ from.charAt(i);
            result%=mod;
        }
        for (int i=0; i<to.length(); i++){
            result=result*prime+ to.charAt(i);
            result%=mod;
        }
        for (int i=0; i<date.length(); i++){
            result=result * prime+ date.charAt(i);
            result%=mod;

        }
        return result;
    }


    public boolean equels(Object obj){
        System.out.println(this);
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Flights temper = (Flights) obj;
        if (this.to.length()!=temper.to.length()) return false;
        if (this.from.length()!=temper.from.length()) return false;
        if (this.date.length()!=temper.date.length()) return false;
        for (int i=0; i<to.length(); i++){
            if (temper.to.charAt(i)!=this.to.charAt(i)){
                return false;
            }
        }
        for (int i=0; i<from.length(); i++){
            if (temper.from.charAt(i)!=this.from.charAt(i)){
                return false;
            }
        }
        for (int i=0; i<date.length(); i++){
            if (temper.date.charAt(i)!=this.date.charAt(i)){
                return false;
            }
        }

        return true;
    }
}
