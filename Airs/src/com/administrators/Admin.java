package com.administrators;

import java.util.ArrayList;
import java.util.List;

import com.flights.Flight;

public class Admin     {
    private static int objectsCounter;

    private static List<Flight> flights = new ArrayList<Flight>();

    public static int getObjectsCounter() {
        return objectsCounter;
    }

    public List<Flight> getFlights(){
        return flights;
    }

    public Admin(){
        objectsCounter++;
    }

    public  void AddFlight(String from, String to, String date)  {
            flights.add(new Flight(from, to, date));
    }

    public  void DeleteFlight(String from, String to, String date) {
        Flight tmp = new Flight(from, to, date);
        int pos = -1, delete_pos = -1;
        for (Flight iter : flights) {
            if (tmp.equals((iter))) {
                pos++;
                delete_pos = pos;
            }
        }
        if (delete_pos != -1) {
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

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        return true;
    }
}
