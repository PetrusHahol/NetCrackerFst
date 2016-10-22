package com.flights;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Asus on 13.10.2016.
 */
public class Flight implements Serializable , Comparable, Comparator<Flight> {

    private String from;
    private String to;
    private GregorianCalendar date;

    public Flight(String from, String to, GregorianCalendar date ) {
        this.from = from;
        this.to = to;
        this.date=date;
    }

    @Override
    public String toString(){
        return ("FLIGHT From " + from + " - to - " + to + " - in - " + date.getTime() + "\n");
    }

    @Override
    public int hashCode() {

        final int PRIME = 43;
        int result = 1;
        int MOD = 1000000007;
        result += from.hashCode()+to.hashCode()+date.hashCode();
        return result;
    }
    @Override
    public boolean equals(Object obj){

        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Flight temper = (Flight) obj;
        if (!to.equals(temper.to)) return false;
        if (!from.equals(temper.from)) return false;
        if (!date.equals(temper.date)) return false;

        return true;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public void setFrom(String from){
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setDate(GregorianCalendar date){
        this.date = date;
    }

    @Override
    public int compareTo(Object obj) {
        Flight entry = (Flight) obj;
        int result =  entry.date.compareTo(this.date);
        if(result != 0) {
            return result;
        }
        return 0;
    }

    @Override
    public int compare(Flight obj1,Flight  obj2) {
        return obj1.from.compareTo(obj2.from);
    }

}
