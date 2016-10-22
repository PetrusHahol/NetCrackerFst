package com.oficce;

import com.flights.Flight;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Date;

/**
 * Created by Asus on 14.10.2016.
 */
public class Brigades implements Serializable ,Comparable, Comparator<Brigades>{

    private Pilot firstPilot;
    private Pilot secondPilot;
    private Stewardess stewardess;
    private Radioman radioman;
    private Navigator navigator ;

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


    @Override
    public String toString(){
        return ("Brigade :" + "\t" + firstPilot + "\t"+ secondPilot
                + "\t" + stewardess + "\t" + navigator + "\t" + radioman );
    }

    @Override
    public int hashCode() {
        int result = 0;
        result = firstPilot.hashCode() + secondPilot.hashCode() + stewardess.hashCode() + navigator.hashCode()
                     + radioman.hashCode();
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

    @Override
    public int compareTo(Object obj) {
        return 0;
    }


    @Override
    public int compare(Brigades obj1, Brigades obj2) {
        int size = obj1.firstPilot.compareTo(obj2.firstPilot);
        if (size != 0 ){
            return size;
        }
        size = obj1.secondPilot.compareTo(obj2.secondPilot);
        if (size != 0){
            return size;
        }
        size = obj1.stewardess.compareTo(obj2.stewardess);
        if (size != 0){
            return size;
        }
        size = obj1.navigator.compareTo(obj2.navigator);
        if (size != 0){
            return size;
        }
        size = obj1.radioman.compareTo(obj2.radioman);
        return size;
    }

}
