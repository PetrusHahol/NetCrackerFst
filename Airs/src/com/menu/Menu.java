package com.menu;

import com.exceptions.DataException;
import com.initialization.DispatcherInit;
import com.initialization.FlightInit;
import com.tools.Constants;
import com.administrators.Admin;
import com.administrators.Dispatcher;
import com.entities.office.*;
import com.tools.Utilities;

import java.io.Serializable;
import java.util.*;

/**
 * Created by Asus on 14.10.2016.
 */


public  class Menu implements Serializable{
    private Admin admin = new Admin();
    private Dispatcher dispatcher = new Dispatcher();
    private static  Scanner input = new Scanner(System.in);
    transient private int age = 0;
    transient private int experience = 0;
    transient private String passportData = "";
    transient private int height = 0;
    transient private String name = "";
    transient private Utilities utility = new Utilities();
    public Menu()  {
        admin =  new FlightInit().getAdmin();
        dispatcher = new DispatcherInit().getDispatcher();
        mainMenu();
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

        int lengthWaist = utility.handler("Lenght Waist", Constants.LOWER_LENGTH_WAIST, Constants.UPPER_LENGTH_WAIST);

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

    private void brigadeMenu(){

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
        dispatcher.addBrigade(dispatcher.iterIntoPilot(indexFirstPilot),dispatcher.iterIntoPilot(indexSecondPilot),
                              dispatcher.iterIntoNavigator(indexNavigator) ,dispatcher.iterIntoStewardess(indexStewardess),
                              dispatcher.iterIntoRadioman(indexRadioman), admin.indexIntoFlight(indexFlightObject));
        } catch (DataException ex){
            System.out.println(ex.getMessage());
        }
    }

    private void dispatcherMenu() {
        System.out.println(" Enter number:\n1 - Add new employee\n2 - Add new brigade\n3 - Info\n4 -"
                + " Regularize\n-1 - Exit");
        int tmp = utility.tryParse(input.nextLine());
        switch (tmp) {
            case 1:
                newEmployMenu();
                break;
            case 2:
                brigadeMenu();
                break;
            case 3:
                dispatcher.employeeInfo();
                dispatcher.brigadeInfo();
                break;
            case 4:
                dispatcher.regularize();
                break;

        }
    }

    private  int enterYearMenu() {
        return utility.handler("Year", Constants.LOWER_YEAR, Constants.UPPER_YEAR);
    }

    private  int enterMonthMenu() {
        return utility.handler("Month", Constants.LOWER_MONTH, Constants.UPPER_MONTH);
    }

    private  int enterDayMenu() {
        return utility.handler("Day", Constants.LOWER_DAY, Constants.UPPER_DAY);
    }

    private  int enterMinuteMenu() {
        return utility.handler("Minute", Constants.LOWER_MINUTE, Constants.UPPER_MINUTE);
    }

    private  int enterSecondMenu() {
        return utility.handler("Second", Constants.LOWER_SECOND, Constants.UPPER_SECOND);
    }

    private  int enterHourMenu() {
        return utility.handler("Hour", Constants.LOWER_HOUR, Constants.UPPER_HOUR);
    }

    private  void addNewFlightMenu(){
        System.out.println("AddNewFlight");
        System.out.println("From");
        String from = input.nextLine();
        System.out.println("To");
        String to = input.nextLine();
        System.out.println("date");

        admin.addFlight(from, to, new GregorianCalendar(enterYearMenu(), enterMonthMenu()-1
                        , enterDayMenu(), enterHourMenu(),  enterMinuteMenu(), enterSecondMenu()));
    }

    private void adminMenu() {
            System.out.println("Enter number:\n1 - Add new flight\n"
                                + "2 - Delete flight\n3 - Info\n4 - Download flights from BD\n"
                                + "5 - Rewrite flights in BD\n-1 - Exit");
            int enterBit = utility.tryParse(input.nextLine());
        switch (enterBit) {
            case 1:
                addNewFlightMenu();
                break;
            case 2:
                System.out.println("DeleteFlight");
                admin.info();
                System.out.println("Enter index");
                int index = utility.tryParse(input.nextLine());
                admin.deleteFlight(index);
                break;
            case 3:
                admin.info();
                break;
            case 4:
                admin.downloadFlights();
                break;
            case 5:
                admin.saveFlights();
                break;

        }
    }



    public void mainMenu(){
        int tmp = 0;
        while (tmp != -1) {
            System.out.println("Enter number:\n1 "
                    +"- Go to administrator center\n"
                    +"2 - Go to Dispatcher center\n-1 - Exit");
            tmp = utility.tryParse(input.nextLine());
            switch (tmp) {
                case 1:
                    adminMenu();
                    break;
                case 2:
                    dispatcherMenu();
                    break;
            }
        }
    }

    public Admin getAdmin() {
        return admin;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public int getAge() {
        return age;
    }

    public int getExperience() {
        return experience;
    }

    public String getPassportData() {
        return passportData;
    }

    public int getHeight() {
        return height;
    }

    public String getName() {
        return name;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setName(String name) {
        this.name = name;
    }
}

