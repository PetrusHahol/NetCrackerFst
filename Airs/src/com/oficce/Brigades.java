package com.oficce;

import com.flights.Flight;

/**
 * Created by Asus on 14.10.2016.
 */
public class Brigades  {

    private Pilot firstPilot;
    private Pilot secondPilot;
    private Stewardess stewardes;
    private Radiomen radiomen;
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

    public Stewardess getStewardes(){
        return this.stewardes;
    }

    public Radiomen getRadiomen(){
        return this.radiomen;
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

    public void setStewardes(Stewardess stewardes){
        this.stewardes = stewardes;
    }

    public void setRadiomen(Radiomen radiomen){
        this.radiomen = radiomen;
    }

    public void setNavigator(Navigator navigator){
        this.navigator = navigator;
    }

    public void setFlightsObject(Flight flightObject){
        this.flightObject = flightObject;
    }

    public String toString(){
        return ("Brigade :" + "\t" + firstPilot + "\t"+ secondPilot
                + "\t" + stewardes + "\t" + navigator + "\t" + radiomen
                + "\t" + flightObject + "\n\n\n");
    }

    public int hashCode() {
        int result = 0;
        result = firstPilot.hashCode() + secondPilot.hashCode() + stewardes.hashCode() + navigator.hashCode()
                     + flightObject.hashCode() + radiomen.hashCode();
        return result;
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }
}
