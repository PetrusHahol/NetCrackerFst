package com.flights;

/**
 * Created by Asus on 13.10.2016.
 */
public class Flight {

    private String from;
    private String to;
    private String date;

    public Flight(String from, String to, String date ) {
        this.from = from;
        this.to = to;
        this.date=date;
    }

    public void setFrom(String from){
        this.from = from;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public void setDate(String date){
        this.date = date;
    }

    @Override
    public String toString(){
        return ("FLIGHT From " + from + " - to - " + to + " - in - " + date);
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

        System.out.println(this);
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

    public String getDate() {
        return date;
    }
}
