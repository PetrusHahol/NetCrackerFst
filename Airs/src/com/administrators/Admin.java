package com.administrators;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

import com.flights.Flight;

public class Admin implements Serializable {

    private static int objectsCounter;
    private Set<Flight> flights = new TreeSet<>();
    public Admin(){
        objectsCounter++;
    }

    public void downloadFlights(){
        try (BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream("src/com/input.txt"), StandardCharsets.UTF_8))){
            while (true) {
                in.readLine();
                addFlight(in.readLine(),in.readLine()
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
            // some
        }
    }

    public  void addFlight(String from, String to, GregorianCalendar date)  {
            flights.add(new Flight(from, to, date));
    }

    public  void deleteFlight(int index) {
        int position = 0;
        for (Flight iter:flights) {
            position++;
            if (position == index) {
                flights.remove(iter);
                break;
            }
        }
    }

    public void saveFlights() {
        try {
            File file = new File("src/com/input.txt");
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());
            for (Flight iter : flights) {
                out.println("-----------");
                out.print(iter.getFrom() + "\n" + iter.getTo()
                        + "\n" + iter.getDate().get(Calendar.YEAR) + "\n"
                        + iter.getDate().get(Calendar.MONTH)+"\n"
                        + iter.getDate().get(Calendar.DAY_OF_MONTH)+"\n"
                        + iter.getDate().get(Calendar.HOUR_OF_DAY)+"\n"
                        + iter.getDate().get(Calendar.MINUTE)+"\n"
                        + iter.getDate().get(Calendar.SECOND)+"\n");

            }
            out.close();
        } catch (IOException ex) {
            System.out.println("OUT");
        } catch (NumberFormatException ex) {
            // log;
        }
    }

    public Flight indexIntoFlight(int index){
        int pos = 0;
        for (Flight iter : flights) {
            pos++;
            if (pos == index) {
                return iter;
            }
        }
        return null;
    }

    public  void info(){
        int pos=0;
        for (Flight iter:flights){
            pos++;
            System.out.print(pos);
            System.out.print(" "+iter);
        }
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (Flight iter: flights) {
            result += iter.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Admin temp = (Admin) obj;
        return temp.flights.equals(this.flights);
    }

    public static int getObjectsCounter() {
        return objectsCounter;
    }

    public Set<Flight> getFlights(){
        return flights;
    }


}
