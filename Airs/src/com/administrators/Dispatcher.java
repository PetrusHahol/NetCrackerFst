package com.administrators;

import com.Exceptions.DataExceptions;

import com.flights.Flight;
import com.oficce.*;
import com.oficce.Navigator;
import com.oficce.Pilot;
import com.oficce.Radioman;
import com.oficce.Stewardess;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Asus on 14.10.2016.
 */
public class Dispatcher implements  Serializable {

    private  List<Brigades> brigade = new ArrayList<Brigades>();
    private  Map<Brigades, Flight> brigadeToFlight = new HashMap<Brigades, Flight>();
    private  List<Radioman> radiomans = new ArrayList<Radioman>();
    private  List<Pilot> pilots = new ArrayList<Pilot>();
    private  List<Stewardess> stewardess = new ArrayList<Stewardess>();
    private  List<Navigator> navigators = new ArrayList<Navigator>();
    private  int objectsCounter;

    public Dispatcher(){
        objectsCounter++;
    }

    public void Regularize(){
        Collections.sort(brigade);
    }

    public void setBrigade(Brigades newBrigade, Flight flightObject)
    {
        brigade.add(newBrigade);
        brigadeToFlight.put(newBrigade, flightObject);
    }

    public  void AddNewRadioman(String name, int age, int height, int experience
            , String passportData, int countForeignLanguage){
        radiomans.add(new Radioman(name, age, height, experience, passportData, countForeignLanguage));
    }

    public void AddNewStewardess(String name, int age, int height, int experience
            , String passportData, int lengthWaist){
        stewardess.add(new Stewardess(name, age, height, experience, passportData, lengthWaist));
    }

    public  void AddNewNavigator(String name, int age, int height, int experience
            , String passportData, String category){
        navigators.add(new Navigator(name, age, height, experience, passportData, category));
    }

    public void AddNewPilot(String name, int age, int height, int experience
            , String passportData, int mileage){
        pilots.add(new Pilot(name, age, height, experience, passportData, mileage));
    }

    public  void Info(){

        for (Radioman iter: radiomans){
            System.out.print(iter);
        }

        for (Pilot iter:pilots){
            System.out.print(iter);
        }

        for (Navigator iter:navigators){
            System.out.print(iter);
        }

        for (Stewardess iter:stewardess){
            System.out.print(iter);
        }
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

    public  void AddBrigade(Admin admin) throws DataExceptions {

        if (Pilot.objectsCounter <2 || Stewardess.objectsCounter == 0
            || Navigator.objectsCounter ==0  || Radioman.objectsCounter == 0)
            throw new DataExceptions("Your have to enter 2 pilots and 1 over employee");

        int pos = 0;
        Brigades newBrigade = new Brigades();
        for (Pilot iter:getPilots())
        {   pos++;
            System.out.println(Integer.toString(pos)+" "+ iter);
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Enter numb first pilot");
        int index_first_pilot = in.nextInt();

        pos = 0;
        for (Pilot iter:getPilots())
        {   pos++;
            if (pos == index_first_pilot) {
                newBrigade.setFirstPilot(iter);
            }
        }

        System.out.println("Enter numb second pilot");
        int index_second_pilot = in.nextInt();
        pos = 0;
        for (Pilot iter:getPilots())
        {   pos++;
            if (pos == index_second_pilot) {
                newBrigade.setSecondPilot(iter);
            }
        }
        pos = 0;

        for (Stewardess iter:getStewardess())
        {   pos++;
            System.out.println(Integer.toString(pos)+" "+ iter);
        }
        System.out.println("Enter numb stewardess");

        int index_stewardess = in.nextInt();
        pos = 0;

        for (Stewardess iter:getStewardess())
        {   pos++;
            if (pos == index_stewardess) {
                newBrigade.setStewardess(iter);
            }
        }

        pos = 0;
        for (Navigator iter:getNavigators())
        {   pos++;
            System.out.println(Integer.toString(pos)+" "+ iter);
        }
        System.out.println("Enter numb navigator");
        int index_navigator = in.nextInt();
        pos = 0;
        for (Navigator iter:getNavigators())
        {   pos++;
            if (pos == index_navigator) {
                newBrigade.setNavigator(iter);
            }
        }

        pos = 0;
        for (Radioman iter: getRadiomans())
        {   pos++;
            System.out.println(Integer.toString(pos) + " " + iter);
        }
        System.out.println("Enter numb radiomen");
        int index_radioman = in.nextInt();
        pos = 0;
        for (Radioman iter: getRadiomans())
        {   pos++;
            if (pos == index_radioman) {
                newBrigade.setRadioman(iter);
            }
        }
        pos = 0;
        for (Flight iter:admin.getFlights() )
        {   pos++;
                System.out.println(Integer.toString(pos) + " " + iter + "\n");

        }
        System.out.println("Enter flight index");
        int indexObj = in.nextInt();

        pos=0;
        for (Flight iter:admin.getFlights())
        {   pos++;
            if (pos == indexObj) {;
                setBrigade(newBrigade, iter);
            }
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
