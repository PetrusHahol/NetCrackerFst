package com.administrators;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.flights.Flight;

/**
 * Created by Asus on 13.10.2016.
 */
public class Admin {

    private static List<Flight> flights= new ArrayList<Flight>();

    public List<Flight> getFlights(){
        return flights;
    }

    public  void AddFlight(){
        Scanner in = new Scanner(System.in);

        System.out.println("AddNewFlite");
        System.out.println("From");
        String namefrom = in.nextLine();
        System.out.println("To");
        String nameto = in.nextLine();
        System.out.println("date");
        String namedate = in.nextLine();

        Flight tmp = new Flight(namefrom,nameto,namedate);

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

        Flight tmp = new Flight(namefrom,nameto,namedate);
        int pos = -1,delete_pos=-1;

        for (Flight iter:flights) {
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

        for (Flight iter:flights){
            pos++;
            System.out.print(pos);
            System.out.println(" "+iter);
        }
    }

    public int hashCode() {
        int result = 0;
        for (Flight iter : flights) {
            result += iter.hashCode();
        }
        return result;
    }

    public boolean equels(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        return true;
    }
}
