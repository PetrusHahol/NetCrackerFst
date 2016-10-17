package com.administrators;

import com.flights.Flight;
import com.ofice.*;
import com.ofice.Navigator;
import com.ofice.Pilot;
import com.ofice.Radiomen;
import com.ofice.Stewardess;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Asus on 14.10.2016.
 */
public class Dispatcher  {

    private List<Brigades> brigade = new ArrayList<Brigades>();
    private List<Radiomen> radiomens = new ArrayList<Radiomen>();
    private List<Pilot> pilots = new ArrayList<Pilot>();
    private List<Stewardess> stewardess = new ArrayList<Stewardess>();
    private List<Navigator> navigators = new ArrayList<Navigator>();



    public  void setBrigade(Brigades newBrigade){
        brigade.add(newBrigade);
    }

    public  void AddNewRadioman(String name, int age, int height, int expirience
            , String pasoprtData, int countForeignLenguage){
        radiomens.add(new Radiomen(name, age, height, expirience, pasoprtData, countForeignLenguage));
    }

    public  void AddNewStewardess(String name, int age, int height, int expirience
            , String pasoprtData, int lengthWaist){
        stewardess.add(new Stewardess(name, age, height, expirience, pasoprtData, lengthWaist));
    }

    public  void AddNewNavigator(String name, int age, int height, int expirience
            , String pasoprtData, String category){
        navigators.add(new Navigator(name, age, height, expirience, pasoprtData, category));
    }

    public  void AddNewPilot(String name, int age, int height, int expirience
            , String pasoprtData, int mileage){
        pilots.add(new Pilot(name, age, height, expirience, pasoprtData, mileage));
    }

    public  void Info(){

        for (Radiomen iter:radiomens){
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

        for (Brigades iter:brigade){
            System.out.print(iter);
        }
    }

    public List<Brigades> getBrigade() {
        return brigade;
    }

    public List<Radiomen> getRadiomens() {
        return radiomens;
    }

    public List<Pilot> getPilots() {
        return pilots;
    }

    public List<Stewardess> getStewardess() {
        return stewardess;
    }

    public List<Navigator> getNavigators() {
        return navigators;
    }

    public void setRadiomens(List<Radiomen> radiomens) {
        this.radiomens = radiomens;
    }

    public void setPilots(List<Pilot> pilots) {
        this.pilots = pilots;
    }

    public void setStewardess(List<Stewardess> stewardess) {
        this.stewardess = stewardess;
    }

    public void setNavigators(List<Navigator> navigators) {
        this.navigators = navigators;
    }



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

        for (Radiomen iter:radiomens) {
            result += iter.hashCode();
        }
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

    public void AddBrigade(Admin fst){
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
        System.out.println("Enter numb stewardes");

        int index_stewardes = in.nextInt();
        pos = 0;

        for (Stewardess iter:getStewardess())
        {   pos++;
            if (pos == index_stewardes) {
                newBrigade.setStewardes(iter);
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
        for (Radiomen iter:getRadiomens())
        {   pos++;
            System.out.println(Integer.toString(pos) + " " + iter);
        }
        System.out.println("Enter numb radiomen");
        int index_radiomen = in.nextInt();
        pos = 0;
        for (Radiomen iter:getRadiomens())
        {   pos++;
            if (pos == index_radiomen) {
                newBrigade.setRadiomen(iter);
            }
        }
        pos = 0;
        for (Flight iter:fst.getFlights() )
        {   pos++;
            if (pos == index_radiomen) {
                System.out.println(Integer.toString(pos) + " " + iter + "\n");
            }
        }
        System.out.println("Enter flight index");
        int indexObj = in.nextInt();

        pos=0;
        for (Flight iter:fst.getFlights() )
        {   pos++;
            if (pos == indexObj) {
                newBrigade.setFlightsObject(iter);
            }
        }
        this.setBrigade(newBrigade);
    }


}
