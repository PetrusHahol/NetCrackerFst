package Administrator;

import java.util.Iterator;
import java.util.Scanner;
import Company.Airline;
import Company.Flights;

/**
 * Created by Asus on 13.10.2016.
 */
public class Admin extends Airline {
    public  void AddFlight(){
        Scanner in = new Scanner(System.in);
        System.out.println("AddNewFlite");
        System.out.println("From");
        String namefrom = in.nextLine();
        System.out.println("To");
        String nameto = in.nextLine();
        System.out.println("date");
        String namedate = in.nextLine();
        Flights tmp = new Flights(namefrom,nameto,namedate);
        flights.add(tmp);
        System.out.println(tmp+" was added");
    }

    public  void DeleteFlight(){
        Scanner in = new Scanner(System.in);
        System.out.println("AddNewFlite");
        System.out.println("From");
        String namefrom = in.nextLine();
        System.out.println("To");
        String nameto = in.nextLine();
        System.out.println("date");
        String namedate = in.nextLine();
        Flights tmp = new Flights(namefrom,nameto,namedate);
        int pos = -1,delete_pos=-1;
        for (Flights iter:flights) {
            if (tmp.equels((iter))){
                pos++;
                delete_pos=pos;
            }
        }
        if (delete_pos!=-1){
            flights.remove(delete_pos);
        }

    }

    public  void Info(){
        int pos=0;
        for (Flights iter:flights){
            pos++;
            System.out.print(pos);
            System.out.println(" "+iter);

        }
    }

}
