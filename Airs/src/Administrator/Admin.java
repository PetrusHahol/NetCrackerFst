package Administrator;

import java.util.Iterator;
import java.util.Scanner;
import Company.Airline;
import Company.Flights;

/**
 * Created by Asus on 13.10.2016.
 */
public class Admin extends Airline {
    public static void AddFlight(){
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

    public static void DeleteFlight(){
        Scanner in = new Scanner(System.in);
        System.out.println("AddNewFlite");
        System.out.println("From");
        String namefrom = in.nextLine();
        System.out.println("To");
        String nameto = in.nextLine();
        System.out.println("date");
        String namedate = in.nextLine();
        Flights tmp = new Flights(namefrom,nameto,namedate);
        for (Flights iter:flights) {
            if (tmp.equels((iter))){
                System.out.println("TRUE"+iter+"\n\n");
            }
        }

    }

    public static void EditFlight(){
        //Find + delete+ Edit
    }
    public static void Info(){
        for (Flights iter:flights)System.out.println(iter);
        }

}
