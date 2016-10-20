package com.administrators;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import com.flights.Flight;

public class Admin implements Serializable {

    private static int objectsCounter;

    private Set<Flight> flights = new HashSet<Flight>() ;

    public static int getObjectsCounter() {
        return objectsCounter;
    }

    public Set<Flight> getFlights(){
        return flights;
    }

    public Admin(){
        objectsCounter++;
    }

    public void DownloadFlights(){
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("src/com/input.txt"), StandardCharsets.UTF_8))){
            String line = " ";
            while (true) {
                in.readLine();
                AddFlight(in.readLine(),in.readLine()
                                , new GregorianCalendar(Integer.parseInt(in.readLine())
                                , Integer.parseInt(in.readLine())
                                , Integer.parseInt(in.readLine())
                                , Integer.parseInt(in.readLine())
                                , Integer.parseInt(in.readLine())
                                , Integer.parseInt(in.readLine())));
            }
        } catch (IOException ex) {
           System.out.println("OUT");
        }
        catch(NumberFormatException ex){
            // log;
        }
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
