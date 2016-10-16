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
                        snd.AddBrigade(fst);
                    }
                    if (tmp == 6){
                        snd.Info();
                    }
                }
        }
    }



}

