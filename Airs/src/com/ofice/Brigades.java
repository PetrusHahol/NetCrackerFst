package com.ofice;

import com.flights.Flight;
import com.ofice.personality.profesions.Navigator;
import com.ofice.personality.profesions.Pilot;
import com.ofice.personality.profesions.Radiomen;
import com.ofice.personality.profesions.Stewardess;

/**
 * Created by Asus on 14.10.2016.
 */
public class Brigades  {

    private Pilot firstpilot;
    private Pilot secondpilot;
    private Stewardess stewardes;
    private Radiomen radiomen;
    private Navigator navigator ;
    private Flight flightObject;

    public Pilot getFirstPilot(){
        return this.firstpilot;
    }

    public Pilot getSecondPilot(){
        return this.secondpilot;
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

    public void setFirstPilot(Pilot firstpilot){
        this.firstpilot = firstpilot;
    }

    public void setSecondPilot(Pilot secondpilot){
        this.secondpilot = secondpilot;
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

    public void setFlightsObject(Flight flightobject){
        this.flightObject =  flightobject;
    }

    public String toString(){
        return ("Brigade :" + "\t" + firstpilot + "\t"+secondpilot
                + "\t" + stewardes + "\t" + navigator + "\t" + radiomen
                + "\t" + flightObject + "\n\n\n");
    }

    public int hashCode() {
        int result = 0;
        result = firstpilot.hashCode() + secondpilot.hashCode() + stewardes.hashCode() + navigator.hashCode()
                     + flightObject.hashCode() + radiomen.hashCode();
        return result;
    }

    public boolean equels(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }
}
