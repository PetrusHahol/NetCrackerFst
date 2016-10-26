package com.menu;

import com.administrators.Admin;
import com.administrators.Dispatcher;
import com.entities.flights.Flight;
import com.entities.office.Navigator;
import com.entities.office.Pilot;
import com.entities.office.Radioman;
import com.entities.office.Stewardess;
import com.exceptions.DataException;
import com.initialization.DispatcherInit;
import com.tools.Constants;
import com.tools.Utilities;

import java.util.Scanner;

/**
 * Created by Asus on 27.10.2016.
 */
public class DispatcherMenu {
    private Utilities utility = new Utilities();
    private static Scanner input = new Scanner(System.in);
    private Dispatcher dispatcher = new Dispatcher();
    private BrigadeMenu brigadeMenu;
    private int age = 0;
    private int experience = 0;
    private String passportData = "";
    private int height = 0;
    private String name = "";

    public DispatcherMenu()  {
        dispatcher = new DispatcherInit().getDispatcher();
        brigadeMenu = new BrigadeMenu();
    }

    public void main(Admin admin) {
        boolean flag = true;
        while (flag) {
            System.out.println(" Enter number:\n1 - Add new employee\n2 - Add new brigade\n3 - Info\n4 -"
                    + " Regularize\n-1 - Back");
            int tmp = utility.tryParse(input.nextLine());
            switch (tmp) {
                case 1:
                    newEmployMenu();
                    break;
                case 2:
                    brigadeMenu.main(admin, dispatcher);
                    break;
                case 3:
                    dispatcher.employeeInfo();
                    dispatcher.brigadeInfo();
                    break;
                case 4:
                    dispatcher.regularize();
                    break;
                case -1:
                    flag = false;
                    break;
            }
        }
    }

    private void charactersMenu(){
        System.out.println("Enter name");
        name = input.nextLine();
        age = utility.handler("Age", Constants.LOWER_AGE, Constants.UPPER_AGE);
        height = utility.handler("Height", Constants.LOWER_HEIGHT, Constants.UPPER_HEIGHT);
        experience = utility.handler("Height", Constants.LOWER_EXPERIENCE, Constants.UPPER_EXPERIENCE);
        System.out.println("Enter Passport Data");
        passportData = input.nextLine();

    }
    private void pilotMenu(){
        int mileage = utility.handler("Mileage", Constants.LOWER_MILEAGE, Constants.UPPER_MILEAGE);
        dispatcher.addNewPilot(name, age, height, experience, passportData, mileage);
    }

    private void radiomenMenu(){

        int countForeignLanguage = utility.handler("Count Foreign Language", Constants.LOWER_LANGUAGE
                , Constants.UPPER_LANGUAGE);
        dispatcher.addNewRadioman(name, age, height, experience
                , passportData, countForeignLanguage);
    }

    private void navigatorMenu(){
        System.out.println("Enter category");
        String strCategory = "";
        try {
            strCategory = input.nextLine();
            int intCategory = Integer.parseInt(strCategory);
            dispatcher.addNewNavigator(name, age, height, experience, passportData, intCategory);
        }
        catch(NumberFormatException ex){
            dispatcher.addNewNavigator(name, age, height, experience, passportData, strCategory);
        }
    }

    private void stewardessMenu(){

        int lengthWaist = utility.handler("Length Waist", Constants.LOWER_LENGTH_WAIST, Constants.UPPER_LENGTH_WAIST);

        dispatcher.addNewStewardess(name, age, height, experience, passportData, lengthWaist);
    }

    private void newEmployMenu() {
        System.out.println(" Enter number:\n1 - Add new pilot\n2 - Add new radiomen"
                + "\n3 - Add new navigator"
                + "\n4 - Add new stewardess\n-1 - Exit");
        int tmp = utility.tryParse(input.nextLine());
        charactersMenu();
        switch (tmp) {
            case 1:
                pilotMenu();
                break;
            case 2:
                radiomenMenu();
                break;
            case 3:
                navigatorMenu();
                break;
            case 4:
                stewardessMenu();
                break;
        }
    }


}
