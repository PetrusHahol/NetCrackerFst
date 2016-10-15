package com.company;

import com.administrators.Admin;
import com.administrators.Dispatcher;
import com.flights.Flight;
import com.ofice.*;
import com.ofice.personality.profesions.Navigator;
import com.ofice.personality.profesions.Pilot;
import com.ofice.personality.profesions.Radiomen;
import com.ofice.personality.profesions.Stewardess;

import java.util.Scanner;

/**
 * Created by Asus on 14.10.2016.
 */
public  class Runer {

    private Admin fst = new Admin();
    private Dispatcher snd = new Dispatcher();

    public Runer()
    {   int tmp = 0;
        Scanner input = new Scanner(System.in);

        while (tmp != -1) {
            System.out.println("Enter number:\n1 "
                               +"- Go to administraton center\n"
                               +"2 - Go to Dispatcer center\n-1 - Exit");
            tmp = input.nextInt();
            if (tmp == 1) {
                System.out.println("Enter number:\n1 - Add new flight\n"
                                   +"2 - Delete flight\n3 - Info\n-1 - Exit");
                tmp = input.nextInt();
                if (tmp == 1) {
                    fst.AddFlight();
                }
                if (tmp == 2){
                    fst.DeleteFlight();
                }
                if (tmp == 3) {
                    fst.Info();
                }
            } else
                if (tmp == 2){
                    System.out.println(" Enter number:\n1 - Add new pilot\n2 - "
                                       +"Add new Radiomen\n3 - Add new Navigator\n4 - "
                                       +"Add new Stewardess\n5- Add new brigade\n6 - Info\n-1 - Exit");
                    tmp = input.nextInt();
                    if (tmp == 1){
                        snd.AddNewPilot();
                    }
                    if (tmp == 2 ){
                        snd.AddNewRadioman();
                    }
                    if (tmp == 3){
                        snd.AddNewNavigator();
                    }
                    if (tmp == 4){
                        snd.AddNewStewardess();
                    }
                    if (tmp == 5 ){
                        this.AddBrigade();
                    }
                    if (tmp == 6){
                        snd.Info();
                    }
                }
        }
    }


    protected void AddBrigade(){
        int pos = 0;
        Brigades newBrigade = new Brigades();
        for (Pilot iter:snd.getPilots())
        {   pos++;
            System.out.println(Integer.toString(pos)+" "+ iter);
        }
        Scanner in = new Scanner(System.in);
        System.out.println("Enter numb first pilot");
        int index_first_pilot = in.nextInt();

        pos = 0;
        for (Pilot iter:snd.getPilots())
        {   pos++;
            if (pos == index_first_pilot) {
                 newBrigade.setFirstPilot(iter);
            }
        }

        System.out.println("Enter numb second pilot");
        int index_second_pilot = in.nextInt();
        pos = 0;
        for (Pilot iter:snd.getPilots())
        {   pos++;
            if (pos == index_second_pilot) {
                newBrigade.setSecondPilot(iter);
            }
        }
        pos = 0;

        for (Stewardess iter:snd.getStewardess())
        {   pos++;
            System.out.println(Integer.toString(pos)+" "+ iter);
        }
        System.out.println("Enter numb stewardes");

        int index_stewardes = in.nextInt();
        pos = 0;

        for (Stewardess iter:snd.getStewardess())
        {   pos++;
            if (pos == index_stewardes) {
                newBrigade.setStewardes(iter);
            }
        }

        pos = 0;
        for (Navigator iter:snd.getNavigators())
        {   pos++;
            System.out.println(Integer.toString(pos)+" "+ iter);
        }
        System.out.println("Enter numb navigator");
        int index_navigator = in.nextInt();
        pos = 0;
        for (Navigator iter:snd.getNavigators())
        {   pos++;
            if (pos == index_navigator) {
                newBrigade.setNavigator(iter);
            }
        }

        pos = 0;
        for (Radiomen iter:snd.getRadiomens())
        {   pos++;
            System.out.println(Integer.toString(pos) + " " + iter);
        }
        System.out.println("Enter numb radiomen");
        int index_radiomen = in.nextInt();
        pos = 0;
        for (Radiomen iter:snd.getRadiomens())
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
        snd.setBrigade(newBrigade);
    }


}

