package com.administrators;

import com.administrators.Interface.DispatcherInterface;
import com.entities.teams.Brigades;
import com.exceptions.DataException;
import com.entities.flights.Flight;
import com.entities.office.*;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Asus on 14.10.2016.
 */
public class Dispatcher<T> implements   DispatcherInterface {

    private  List<Brigades> brigade = new ArrayList<>();
    private  Map<Brigades, Flight> brigadeToFlight = new HashMap<>();
    private  List<Radioman> radiomans = new ArrayList<>();
    private  List<Pilot> pilots = new ArrayList<>();
    private  List<Stewardess> stewardess = new ArrayList<>();
    private  List<Navigator<Object>> navigators = new ArrayList<Navigator<Object>>();
    private  int objectsCounter;
    private int pos = 0;

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

    @Override
    public  void addNewRadioman(String name, int age, int height, int experience
            , String passportData, int countForeignLanguage){
        radiomans.add(new Radioman(name, age, height, experience, passportData, countForeignLanguage));
    }

    @Override
    public void addNewStewardess(String name, int age, int height, int experience
            , String passportData, int lengthWaist){
        stewardess.add(new Stewardess(name, age, height, experience, passportData, lengthWaist));
    }

    @Override
    public void addNewNavigator(String name, int age, int height, int experience, String passportData, Object category) {
            navigators.add(new Navigator<>(name, age, height, experience, passportData, category));

    }


    @Override
    public void addNewPilot(String name, int age, int height, int experience
            , String passportData, int mileage){
        pilots.add(new Pilot(name, age, height, experience, passportData, mileage));
    }

    public  void employeeInfo(){

        pos = 1 ;
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
        for (Navigator<Object> iter:navigators){
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
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        return  getClass() == obj.getClass();
    }


    public Pilot iterIntoPilot(int index) {
        pos = 0;
        for (Pilot iter : pilots) {
            pos++;
            if (pos == index) {
                return iter;
            }
        }
        return null;
    }

    public Navigator<Object> iterIntoNavigator(int index) {
        pos = 0;
        for (Navigator<Object> iter : navigators) {
            pos++;
            if (pos == index) {
                return iter;
            }
        }
        return null;
    }

    public Stewardess iterIntoStewardess(int index) {
        pos = 0;
        for (Stewardess iter : stewardess) {
            pos++;
            if (pos == index) {
                return iter;
            }
        }
        return null;
    }

    public Radioman iterIntoRadioman(int index) {
        pos = 0;
        for (Radioman iter : radiomans) {
            pos++;
            if (pos == index) {
                return iter;
            }
        }
        return null;
    }

    public  void addBrigade(Pilot firstPilot, Pilot secondPilot, Navigator<Object> navigator
            , Stewardess stewardess , Radioman radiomen, Flight flight) {

        try{
            if (firstPilot == null || secondPilot == null || navigator == null
                    || stewardess == null || radiomen == null || flight == null || firstPilot.equals(secondPilot))
                throw new DataException("Wrong  data");
            setBrigade(new Brigades(firstPilot,secondPilot,navigator,stewardess,radiomen), flight);
        }catch (DataException ex){
            System.err.println(ex.getMessage());
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

    public List<Navigator<Object>> getNavigators() {
        return navigators;
    }

    public  void setRadiomans(List<Radioman> radiomen) {
        this.radiomans = radiomen;
    }

    public  void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }

    public  void setStewardess(List<Stewardess> stewardess) {
        this.stewardess = stewardess;
    }

    public  void setNavigators(List<Navigator<Object>> navigator) {
        this.navigators = navigator;
    }


    @Override
    public int hashCode() {
        int result = brigade.hashCode();
        result = 31 * result + brigadeToFlight.hashCode();
        result = 31 * result + radiomans.hashCode();
        result = 31 * result + pilots.hashCode();
        result = 31 * result + stewardess.hashCode();
        result = 31 * result + navigators.hashCode();
        return result;
    }
}
