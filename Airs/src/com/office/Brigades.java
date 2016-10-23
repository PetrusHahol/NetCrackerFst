package com.office;

import java.io.Serializable;

/**
 * Created by Asus on 14.10.2016.
 */
public class Brigades implements Serializable ,Comparable {

    private Pilot firstPilot;
    private Pilot secondPilot;
    private Stewardess stewardess;
    private Radioman radioman;
    private Navigator navigator;


    private static int objectsCounter;

    public Brigades(Pilot firstPilot, Pilot secondPilot, Navigator navigator, Stewardess stewardess, Radioman radioman ) {
        setFirstPilot(firstPilot);
        setSecondPilot(secondPilot);
        setStewardess(stewardess);
        setRadioman(radioman);
        setNavigator(navigator);
        objectsCounter++;
    }

    public Pilot getFirstPilot() {
        return this.firstPilot;
    }

    public Pilot getSecondPilot() {
        return this.secondPilot;
    }

    public Stewardess getStewardess() {
        return this.stewardess;
    }

    public Radioman getRadioman() {
        return this.radioman;
    }

    public Navigator getNavigator() {
        return this.navigator;
    }

    public void setFirstPilot(Pilot firstPilot) {
        this.firstPilot = firstPilot;
    }

    public void setSecondPilot(Pilot secondPilot) {
        this.secondPilot = secondPilot;
    }

    public void setStewardess(Stewardess stewardess) {
        this.stewardess = stewardess;
    }

    public void setRadioman(Radioman radioman) {
        this.radioman = radioman;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }


    @Override
    public String toString() {
        return ("Brigade :\n" + "\t" + firstPilot + "\t" + secondPilot
                + "\t" + stewardess + "\t" + navigator + "\t" + radioman);
    }

    @Override
    public int hashCode() {
        int result;
        result = firstPilot.hashCode() + secondPilot.hashCode() + stewardess.hashCode() + navigator.hashCode()
                + radioman.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        Brigades temp =  (Brigades) obj;
        return (temp.firstPilot.equals(this.firstPilot) ||  temp.secondPilot.equals(this.secondPilot)
                || temp.navigator.equals(this.navigator) || temp.stewardess.equals(this.stewardess)
                || temp.radioman.equals(this.radioman));
    }

    @Override
    public int compareTo(Object obj) {
        Brigades obj2 = (Brigades) obj;
        int size = firstPilot.compare(firstPilot, obj2.firstPilot);
        if (size != 0) {
            return size;
        }
        size = secondPilot.compare(firstPilot, ((Brigades) obj).firstPilot);
        if (size != 0) {
            return size;
        }
        return 0;
    }
}
