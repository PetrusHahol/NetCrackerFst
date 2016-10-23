package com.administrators;

import com.Exceptions.DataExceptions;

import com.flights.Flight;
import com.office.*;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Asus on 14.10.2016.
 */
public class Dispatcher<T> implements  Serializable {

    private  List<Brigades> brigade = new ArrayList<>();
    private  Map<Brigades, Flight> brigadeToFlight = new HashMap<>();
    private  List<Radioman> radiomans = new ArrayList<>();
    private  List<Pilot> pilots = new ArrayList<>();
    private  List<Stewardess> stewardess = new ArrayList<>();
    private  List<Navigator> navigators = new ArrayList<>();
    private  int objectsCounter;

    public Dispatcher(){
        objectsCounter++;
    }

    public void regularize(){
        Collections.sort(brigade);
    }

    public void setBrigade(Brigades newBrigade, Flight flightObject)
    {
        brigade.add(newBrigade);
        brigadeToFlight.put(newBrigade, flightObject);
    }

    public  void addNewRadioman(String name, int age, int height, int experience
            , String passportData, int countForeignLanguage){
        radiomans.add(new Radioman(name, age, height, experience, passportData, countForeignLanguage));
    }

    public void addNewStewardess(String name, int age, int height, int experience
            , String passportData, int lengthWaist){
        stewardess.add(new Stewardess(name, age, height, experience, passportData, lengthWaist));
    }

    public  void addNewNavigator(String name, int age, int height, int experience
            , String passportData, String category){
        navigators.add(new Navigator(name, age, height, experience, passportData, category));
    }

    public  void addNewNavigator(String name, int age, int height, int experience
            , String passportData, int category){
        navigators.add(new Navigator(name, age, height, experience, passportData, category));
    }

    public void addNewPilot(String name, int age, int height, int experience
            , String passportData, int mileage){
        pilots.add(new Pilot(name, age, height, experience, passportData, mileage));
    }

    public  void employeeInfo(){

        int pos = 1 ;
        for (Radioman iter: radiomans){
            System.out.print(pos + " " + iter);
            pos++;
        }
        System.out.println("--");

        pos = 1;
        for (Pilot iter:pilots){
            System.out.print(pos + " " +iter);
            pos++;
        }
        System.out.println("--");

        pos = 1;
        for (Navigator iter:navigators){
            System.out.print(pos + " " +iter);
            pos++;
        }
        System.out.println("--");

        pos = 1;
        for (Stewardess iter:stewardess){
            System.out.print(pos + " " + iter);
            pos++;
        }
        System.out.println("--");

    }

    public void brigadeInfo(){
        for(Brigades iter: brigade){
            System.out.print(iter + " " + brigadeToFlight.get(iter));
        }
    }


    @Override
    public int hashCode() {
        int result = 0;
        for (Brigades iter:brigade) {
            result += iter.hashCode();
        }

        for (Pilot iter:pilots) {
            result += iter.hashCode();
        }

        for (Stewardess iter:stewardess) {
            result += iter.hashCode();
        }

        for (Navigator iter:navigators) {
            result += iter.hashCode();
        }

        for (Radioman iter: radiomans) {
            result += iter.hashCode();
        }
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        return  getClass() == obj.getClass();
    }


    public Pilot iterIntoPilot(int index) {
        int pos = 0;
        for (Pilot iter : pilots) {
            pos++;
            if (pos == index-1) {
                return iter;
            }
        }
        return null;
    }

    public Navigator iterIntoNavigator(int index) {
        int pos = 0;
        for (Navigator iter : navigators) {
            pos++;
            if (pos == index-1) {
                return iter;
            }
        }
        return null;
    }

    public Stewardess iterIntoStewardess(int index) {
        int pos = 0;
        for (Stewardess iter : stewardess) {
            pos++;
            if (pos == index-1) {
                return iter;
            }
        }
        return null;
    }

    public Radioman iterIntoRadioman(int index) {
        int pos = 0;
        for (Radioman iter : radiomans) {
            pos++;
            if (pos == index-1) {
                return iter;
            }
        }
        return null;
    }

    public  void addBrigade(Pilot firstPilot, Pilot secondPilot, Navigator navigator
            , Stewardess stewardess , Radioman radiomen, Flight flight) {

        try{
            if (firstPilot == null || secondPilot == null || navigator == null
                    || stewardess == null || radiomen == null || flight == null)
                throw new DataExceptions("Wrong  data");
            setBrigade(new Brigades(firstPilot,secondPilot,navigator,stewardess,radiomen), flight);
        }catch (DataExceptions ex){
            System.out.println(ex.getMessage());
        }


    }

    public Map<Brigades, Flight> getBrigadeToFlight() {
        return brigadeToFlight;
    }

    public int getObjectsCounter() {
        return objectsCounter;
    }

    public List<Brigades> getBrigade() {
        return brigade;
    }

    public  List<Radioman> getRadiomans() {
        return radiomans;
    }

    public  List<Pilot> getPilots() {
        return pilots;
    }

    public  List<Stewardess> getStewardess() {
        return stewardess;
    }

    public  List<Navigator> getNavigators() {
        return navigators;
    }

    public  void setRadiomans(List<Radioman> radiomen) {
        this.radiomans = radiomen;
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }

    public  void setStewardess(List<Stewardess> stewardess) {
        this.stewardess = stewardess;
    }

    public  void setNavigators(List<Navigator> navigator) {
        this.navigators = navigator;
    }


}
