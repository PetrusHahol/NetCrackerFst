package com.company;

import com.exceptions.DataException;
import com.tools.Constants;
import com.administrators.Admin;
import com.administrators.Dispatcher;
import com.office.*;
import com.sun.org.apache.xerces.internal.impl.dv.DatatypeException;

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.*;

/**
 * Created by Asus on 14.10.2016.
 */


public  class Menu implements Serializable{
    private enum City{Minsk, Moskow, Voronezh, Gomel, Mogilev, Mars , Kiev, Pskow, Grodno, Wails}
    private Admin admin = new Admin();
    private Dispatcher dispatcher = new Dispatcher();
    private static  Scanner input = new Scanner(System.in);
    transient private int age = 0;
    transient private int experience = 0;
    transient private String passportData = "";
    transient private int height = 0;
    transient private String name = "";

    public Menu()  {
        init();
        mainMenu();
    }


    private void init() {
        Random rand = new Random();
        City[] allCity = City.values();
        admin.addFlight(allCity[rand.nextInt(10) ].toString()
                        , allCity[rand.nextInt(10) ].toString(), new GregorianCalendar(2016, 11, 18, 22, 23, 22));
        admin.addFlight(allCity[rand.nextInt(10)].toString()
                        , allCity[rand.nextInt(10) ].toString(), new GregorianCalendar(2016, 10, 5, 6, 7));
        admin.addFlight(allCity[rand.nextInt(10) ].toString()
                        , allCity[rand.nextInt(10)].toString(), new GregorianCalendar(2017, 5, 5, 6, 40));
        admin.addFlight(allCity[rand.nextInt(10) ].toString()
                        , allCity[rand.nextInt(10)].toString(), new GregorianCalendar(2020, 9, 12, 20, 30, 50));
        admin.addFlight(allCity[rand.nextInt(10)].toString()
                        , allCity[rand.nextInt(10) ].toString(), new GregorianCalendar(2020, 9, 12, 20, 30, 50));
        dispatcher.addNewPilot("Stas", 25, 160, 5, "KV185555", 550);
        dispatcher.addNewStewardess("Stas", 25, 160, 5, "KV185555", 60);
        dispatcher.addNewNavigator("Stas", 25, 160, 5, "KV185555", "First");
        dispatcher.addNewRadioman("Stas", 25, 160, 5, "KV185555", 12);
    }

    private int enterCharacters(String type, int lowerData, int upperData){
        int result = 0;
        while (result == 0) {
            System.out.println("Enter  " + type + " " + lowerData + " - " + upperData);
            result  = 0;
            while (result == 0){
                try {
                    result = tryParse(input.nextLine());
                    if (result < lowerData || result > upperData)
                        throw  new DataException("Try again");
                }catch (DataException ex){
                    result = 0;
                    System.err.println(ex.getMessage());
                }
            }
        }
        return result;
    }

    private void charactersMenu(){
        System.out.println("Enter name");
        name = input.nextLine();
        age = enterCharacters("Age", Constants.LOWER_AGE, Constants.UPPER_AGE);
        height = enterCharacters("Height", Constants.LOWER_HEIGHT, Constants.UPPER_HEIGHT);
        experience = enterCharacters("Height", Constants.LOWER_EXPERIENCE, Constants.UPPER_EXPERIENCE);
        System.out.println("Enter Passport Data");
        passportData = input.nextLine();

    }

    private void pilotMenu(){
        int mileage = enterCharacters("Mileage", com.tools.Constants.LOWER_MILEAGE, Constants.UPPER_MILEAGE);
        dispatcher.addNewPilot(name, age, height, experience, passportData, mileage);
    }

    private void radiomenMenu(){

        int countForeignLanguage = enterCharacters("Count Foreign Language", Constants.LOWER_LANGUAGE
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

        int lengthWaist = enterCharacters("Lenght Waist", Constants.LOWER_LENGTH_WAIST, Constants.UPPER_LENGTH_WAIST);

        dispatcher.addNewStewardess(name, age, height, experience, passportData, lengthWaist);
    }

    private void newEmployMenu() {
        System.out.println(" Enter number:\n1 - Add new pilot\n2 - Add new radiomen"
                + "\n3 - Add new navigator"
                + "\n4 - Add new stewardess\n-1 - Exit");
        int tmp = tryParse(input.nextLine());
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
        int indexFirstPilot = tryParse(input.nextLine());
        System.out.println("Enter numb second pilot");
        int indexSecondPilot = tryParse(input.nextLine());
        System.out.println("Enter numb navigator");
        int indexNavigator = tryParse(input.nextLine());
        System.out.println("Enter numb stewardess");
        int indexStewardess = tryParse(input.nextLine());
        System.out.println("Enter numb radiomen");
        int indexRadioman = tryParse(input.nextLine());
        admin.info();
        System.out.println("Enter flight index");
        int indexFlightObject = tryParse(input.nextLine());
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
        int tmp = tryParse(input.nextLine());
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
        return enterCharacters("Year", Constants.LOWER_YEAR, Constants.UPPER_YEAR);
    }

    private  int enterMonthMenu() {
        return enterCharacters("Month", Constants.LOWER_MONTH, Constants.UPPER_MONTH);
    }

    private  int enterDayMenu() {
        return enterCharacters("Day", Constants.LOWER_DAY, Constants.UPPER_DAY);
    }
    private  int enterMinuteMenu() {
        return enterCharacters("Minute", Constants.LOWER_MINUTE, Constants.UPPER_MINUTE);
    }

    private  int enterSecondMenu() {
        return enterCharacters("Second", Constants.LOWER_SECOND, Constants.UPPER_SECOND);
    }

    private  int enterHourMenu() {
        return enterCharacters("Hour", Constants.LOWER_HOUR, Constants.UPPER_HOUR);
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
            int enterBit = tryParse(input.nextLine());
        switch (enterBit) {
            case 1:
                addNewFlightMenu();
                break;
            case 2:
                System.out.println("DeleteFlight");
                admin.info();
                System.out.println("Enter index");
                int index = tryParse(input.nextLine());
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

    private static int tryParse(String string){
        int answer = 0;
        try {
            answer = Integer.parseInt(string);
        }catch (NumberFormatException e) {
            System.err.println("Wrong Format");
        }
        return answer;
    }

     void mainMenu(){
        int tmp = 0;
        while (tmp != -1) {
            System.out.println("Enter number:\n1 "
                    +"- Go to administrator center\n"
                    +"2 - Go to Dispatcher center\n-1 - Exit");
            tmp = tryParse(input.nextLine());
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

