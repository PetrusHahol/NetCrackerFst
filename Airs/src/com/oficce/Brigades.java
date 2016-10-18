package com.oficce;

import com.flights.Flight;

/**
 * Created by Asus on 14.10.2016.
 */
public class Brigades  {

    private Pilot firstPilot;
    private Pilot secondPilot;
    private Stewardess stewardess;
    private Radioman radioman;
    private Navigator navigator ;
    private Flight flightObject;

    private static int objectsCounter;

    public Brigades(){
        objectsCounter++;
    }

    public Pilot getFirstPilot(){
        return this.firstPilot;
    }

    public Pilot getSecondPilot(){
        return this.secondPilot;
    }

    public Stewardess getStewardess(){
        return this.stewardess;
    }

    public Radioman getRadioman(){
        return this.radioman;
    }

    public Navigator getNavigator(){
        return this.navigator;
    }

    public Flight getFlights(){
        return this.flightObject;
    }

    public void setFirstPilot(Pilot firstPilot){
        this.firstPilot = firstPilot;
    }

    public void setSecondPilot(Pilot secondPilot){
        this.secondPilot = secondPilot;
    }

    public void setStewardess(Stewardess stewardess){
        this.stewardess = stewardess;
    }

    public void setRadioman(Radioman radioman){
        this.radioman = radioman;
    }

    public void setNavigator(Navigator navigator){
        this.navigator = navigator;
    }

    public void setFlightsObject(Flight flightObject){
        this.flightObject = flightObject;
    }

    @Override
    public String toString(){
        return ("Brigade :" + "\t" + firstPilot + "\t"+ secondPilot
                + "\t" + stewardess + "\t" + navigator + "\t" + radioman
                + "\t" + flightObject + "\n\n\n");
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = firstPilot.hashCode() + secondPilot.hashCode() + stewardess.hashCode() + navigator.hashCode()
                     + flightObject.hashCode() + radioman.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }
}
