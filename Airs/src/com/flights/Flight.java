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

        for (int i = 0; i < from.length(); i++){
            result = PRIME * result + from.charAt(i);
            result %= MOD;
        }

        for (int i = 0; i < to.length(); i++){
            result = result * PRIME + to.charAt(i);
            result %= MOD;
        }

        for (int i = 0; i < date.length(); i++){
            result = result * PRIME + date.charAt(i);
            result %= MOD;

        }
        return result;
    }

    @Override
    public boolean equals(Object obj){

        System.out.println(this);
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Flight temper = (Flight) obj;

        if (this.to.length() != temper.to.length()) return false;
        if (this.from.length() != temper.from.length()) return false;
        if (this.date.length() != temper.date.length()) return false;

        for (int i = 0; i < to.length(); i++){
            if (temper.to.charAt(i) != this.to.charAt(i)){
                return false;
            }
        }
        for (int i = 0; i < from.length(); i++){
            if (temper.from.charAt(i) != this.from.charAt(i)){
                return false;
            }
        }
        for (int i = 0; i < date.length(); i++){
            if (temper.date.charAt(i) != this.date.charAt(i)){
                return false;
            }
        }
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
