package com.company;

import com.Exceptions.DataExceptions;


import com.administrators.Admin;
import com.administrators.Dispatcher;
import com.office.*;

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

    private void charactersMenu(){
        System.out.println("Enter name");
        name = input.nextLine();
        System.out.println("Enter age");
        age = 0;
        height = 0;
        experience = 0;
        while (age == 0) {
            age = tryParse(input.nextLine());
        }
        System.out.println("Enter Height");
        while (height == 0) {
            height = tryParse(input.nextLine());
        }
        System.out.println("Enter Experience");
        while (experience == 0) {
            experience = tryParse(input.nextLine());
        }
        System.out.println("Enter Passport Data");
        passportData = input.nextLine();

    }

    private void pilotMenu(){
        System.out.println("Enter mileage");
        int mileage = 0;
        while (mileage == 0) {
            mileage = tryParse(input.nextLine());
        }
        dispatcher.addNewPilot(name, age, height, experience, passportData, mileage);
    }

    private void radiomenMenu(){
        System.out.println("Enter count foreign language");
        int countForeignLanguage = 0;
        while (countForeignLanguage == 0) {
            countForeignLanguage = tryParse(input.nextLine());
        }
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
        System.out.println("Enter length waist");
        int lengthWaist = 0;
        while (lengthWaist == 0){
            lengthWaist = tryParse(input.nextLine());
        }
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
                throw new DataExceptions("Your have to enter 2 pilots and 1 over employee");
        } catch (DataExceptions ex){
            ex.getMessage();
        }

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

    }

    private void dispatcherMenu() {
        System.out.println(" Enter number:\n1 - Add new employee\n2 - Add new brigade\n3 - Info\n4 -"
                + " regularize\n-1 - Exit");
        int tmp = tryParse(input.nextLine());
        switch (tmp) {
            case 1:
                newEmployMenu();
                break;
            case 2:
                brigadeMenu();
                break;
            case 3:
                dispatcher.info();
                break;
            case 4:
                dispatcher.regularize();
                break;

        }
    }

    private  int enterYearMenu() {
        System.out.println("Year(2016-2020)");
        return Math.max(2016, tryParse(input.nextLine()));
    }

    private  int enterMonthMenu() {
        System.out.println("Month(1-12)");
        return tryParse(input.nextLine());
    }

    private  int enterDayMenu() {
        System.out.println("Day(1-31(30))");
        return tryParse(input.nextLine());
    }
    private  int enterMinuteMenu() {
        System.out.println("Minute (0-59)");
        return tryParse(input.nextLine());
    }

    private  int enterSecondMenu() {
        System.out.println("Second(0-59)");
        return tryParse(input.nextLine());
    }

    private  int enterHourMenu() {
        System.out.println("Hour(0-23)");
        return tryParse(input.nextLine());
    }

    private  void addNewFlightMenu(){
        System.out.println("AddNewFlight");
        System.out.println("From");
        String from = input.nextLine();
        System.out.println("To");
        String to = input.nextLine();
        System.out.println("date");

        admin.addFlight(from, to,new GregorianCalendar(enterYearMenu(), enterMonthMenu()-1
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

    public static Scanner getInput() {
        return input;
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

    public static void setInput(Scanner input) {
        Menu.input = input;
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

