package Administrator;

import Company.Flights;
import Ofice.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Asus on 14.10.2016.
 */
public class Dispatcher extends Brigade {
    public static void AddPilotFlight(){
        Scanner in = new Scanner(System.in);
        System.out.println("Enter index flight");
        Integer flightIndex = in.nextInt();
        System.out.println("Set index of brigade");
        Integer BrigadeIndex = in.nextInt();;
    }


    public static void AddNewRadioman(){
        radiomens.add(new Radiomen());
    }

    public static void AddNewStewardess(){
        stewardess.add(new Stewardess());
    }

    public static void AddNewNavigator(){
        navigators.add(new Navigator());
    }

    public static void AddNewPilot(){
        pilots.add(new Pilot());
    }

    public static void Info(){
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

    }
}
