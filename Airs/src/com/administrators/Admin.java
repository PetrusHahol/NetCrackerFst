package com.administrators;

import java.util.*;

import com.flights.Flight;

public class Admin     {

    private static int objectsCounter;

    private static Set<Flight> flights = new HashSet<Flight>() ;

    public static int getObjectsCounter() {
        return objectsCounter;
    }

    public Set<Flight> getFlights(){
        return flights;
    }

    public Admin(){
        objectsCounter++;
    }

    public  void AddFlight(String from, String to, GregorianCalendar date)  {
            flights.add(new Flight(from, to, date));
    }

    public  void DeleteFlight(int index) {
        int position = 0;
        for (Flight iter:flights) {
            position++;
            if (position == index) {
                flights.remove(iter);
                break;
            }
        }
    }



    public  void Info(){
        int pos=0;

        for (Flight iter:flights){
            pos++;
            System.out.print(pos);
            System.out.print(" "+iter);
        }
    }

    public int hashCode() {
        int result = 0;
        for (Flight iter: flights) {
            result += iter.hashCode();
        }
        return result;
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        return true;
    }
}
