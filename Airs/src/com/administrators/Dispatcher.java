package com.administrators;

import com.ofice.*;
import com.ofice.personality.profesions.Navigator;
import com.ofice.personality.profesions.Pilot;
import com.ofice.personality.profesions.Radiomen;
import com.ofice.personality.profesions.Stewardess;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 14.10.2016.
 */
public class Dispatcher  {

    private List<Brigades> brigade = new ArrayList<Brigades>();
    private List<Radiomen> radiomens = new ArrayList<Radiomen>();
    private List<Pilot> pilots = new ArrayList<Pilot>();
    private List<Stewardess> stewardess = new ArrayList<Stewardess>();
    private List<Navigator> navigators = new ArrayList<Navigator>();


    public void setBrigade(Brigades newBrigade){
        brigade.add(newBrigade);
    }

    public  void AddNewRadioman(){
        radiomens.add(new Radiomen());
    }

    public  void AddNewStewardess(){
        stewardess.add(new Stewardess());
    }

    public  void AddNewNavigator(){
        navigators.add(new Navigator());
    }

    public  void AddNewPilot(){
        pilots.add(new Pilot());
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

    public boolean equels(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }
}
