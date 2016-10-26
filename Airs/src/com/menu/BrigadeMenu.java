package com.menu;

import com.administrators.Admin;
import com.administrators.Dispatcher;
import com.entities.office.Navigator;
import com.entities.office.Pilot;
import com.entities.office.Radioman;
import com.entities.office.Stewardess;
import com.exceptions.DataException;
import com.tools.Utilities;

import java.util.Scanner;

/**
 * Created by Asus on 27.10.2016.
 */
public class BrigadeMenu {

    private Utilities utility = new Utilities();
    private static Scanner input = new Scanner(System.in);

    public void main(Admin admin, Dispatcher<Object> dispatcher) {
        try {
            if (Pilot.getObjectsCounter() < 2 || Stewardess.getObjectsCounter() == 0
                    || Navigator.getObjectsCounter() == 0 || Radioman.getObjectsCounter() == 0)
                throw new DataException("Your have to enter 2 pilots and 1 over employee");
            dispatcher.employeeInfo();
            System.out.println("Enter numb first pilot");
            int indexFirstPilot = utility.tryParse(input.nextLine());
            System.out.println("Enter numb second pilot");
            int indexSecondPilot = utility.tryParse(input.nextLine());
            System.out.println("Enter numb navigator");
            int indexNavigator = utility.tryParse(input.nextLine());
            System.out.println("Enter numb stewardess");
            int indexStewardess = utility.tryParse(input.nextLine());
            System.out.println("Enter numb radiomen");
            int indexRadioman = utility.tryParse(input.nextLine());
            admin.info();
            System.out.println("Enter flight index");
            int indexFlightObject = utility.tryParse(input.nextLine());
            dispatcher.addBrigade(dispatcher.iterIntoPilot(indexFirstPilot), dispatcher.iterIntoPilot(indexSecondPilot),
                    dispatcher.iterIntoNavigator(indexNavigator), dispatcher.iterIntoStewardess(indexStewardess),
                    dispatcher.iterIntoRadioman(indexRadioman), admin.indexIntoFlight(indexFlightObject));
        } catch (DataException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
