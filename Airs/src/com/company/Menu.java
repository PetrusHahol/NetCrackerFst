package com.company;

import com.Exceptions.CustomExceptions;


import com.administrators.Admin;
import com.administrators.Dispatcher;
import com.flights.Flight;

import java.lang.reflect.Type;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Asus on 14.10.2016.
 */


public  class Menu {
    private Admin admin = new Admin();
    private Dispatcher dispatcher = new Dispatcher();
    private  Scanner input = new Scanner(System.in);
    private int age = 0;
    private int experience = 0;
    private String passportData = "";
    private int height = 0;
    private String name = "";

    public Menu()  {
        Init();
        MainMenu();
    }
    private void Init() {
        admin.AddFlight("Minsk", "Moskow", new GregorianCalendar(2016, 11, 18, 22, 23, 22));
        admin.AddFlight("Minsk", "Mogilev", new GregorianCalendar(2016, 10, 5, 6, 7));
        admin.AddFlight("Voronezh", "Gomel", new GregorianCalendar(2017, 5, 5, 6, 40));
        admin.AddFlight("Minsk", "Mars", new GregorianCalendar(2020, 9, 12, 20, 30, 50));
        admin.AddFlight("Minsk", "Mars", new GregorianCalendar(2020, 9, 12, 20, 30, 50));
        dispatcher.AddNewPilot("Stas", 25, 160, 5, "KV185555", 550);
        dispatcher.AddNewStewardess("Stas", 25, 160, 5, "KV185555", 60);
        dispatcher.AddNewNavigator("Stas", 25, 160, 5, "KV185555", "First");
        dispatcher.AddNewRadioman("Stas", 25, 160, 5, "KV185555", 12);
    }

    private void CharactersMenu(){
        System.out.println("Enter name");
        name = input.nextLine();
        System.out.println("Enter age");
        while (age == 0) {
            age = TryParse(input.nextLine());
        }
        System.out.println("Enter Height");
        while (height == 0) {
            height = TryParse(input.nextLine());
        }
        System.out.println("Enter Experience");
        while (experience == 0) {
            experience = TryParse(input.nextLine());
        }
        System.out.println("Enter Passport Data");
        passportData = input.nextLine();

    }

    private void PilotMenu(){
        System.out.println("Enter mileage");
        int mileage = 0;
        while (mileage == 0) {
            mileage = TryParse(input.nextLine());
        }
        dispatcher.AddNewPilot(name, age, height, experience, passportData, mileage);
    }

    private void RadiomenMenu(){
        System.out.println("Enter count foreign language");
        int countForeignLanguage = 0;
        while (countForeignLanguage == 0) {
            countForeignLanguage = TryParse(input.nextLine());
        }
        dispatcher.AddNewRadioman(name, age, height, experience
                , passportData, countForeignLanguage);
    }

    private void NavigatorMenu(){
        System.out.println("Enter category");
        input.nextLine();
        String category = input.nextLine();
        dispatcher.AddNewNavigator(name, age, height, experience, passportData, category);
    }

    private void StewardessMenu(){
        System.out.println("Enter length waist");
        int lengthWaist = 0;
        while (lengthWaist == 0){
            lengthWaist = TryParse(input.nextLine());
        }
        dispatcher.AddNewStewardess(name, age, height, experience, passportData, lengthWaist);
    }

    private void NewEmployMenu() {
        System.out.println(" Enter number:\n1 - Add new pilot\n2 - Add new radiomen"
                + "\n3 - Add new navigator"
                + "\n4 - Add new stewardess\n-1 - Exit");
        int tmp = TryParse(input.nextLine());
        CharactersMenu();
        switch (tmp) {
            case 1:
                PilotMenu();
                break;
            case 2:
                RadiomenMenu();
                break;
            case 3:
                NavigatorMenu();
                break;
            case 4:
                StewardessMenu();
                break;
        }
    }


    private void DispatcherMenu() {
        System.out.println(" Enter number:\n1 - Add new employee\n2 - Add new brigade\n3 - Info\n-1 - Exit");
        int tmp = TryParse(input.nextLine());
        switch (tmp) {
            case 1:
                NewEmployMenu();
                break;
            case 2:
                try {
                    dispatcher.AddBrigade(admin);
                } catch (CustomExceptions ex) {
                    System.out.println(ex.getMessage());
                }
                break;
            case 3:
                dispatcher.Info();
                break;
        }
    }

    private int EnterYearMenu() {
        System.out.println("Year(2016-2020)");
        return TryParse(input.nextLine());
    }


    private int EnterMonthMenu() {
        System.out.println("Month(1-12)");
        return TryParse(input.nextLine());
    }

    private int EnterDayMenu() {
        System.out.println("Day(1-31(30))");
        return TryParse(input.nextLine());
    }
    private int EnterMinuteMenu() {
        System.out.println("Minute (0-59)");
        return TryParse(input.nextLine());
    }

    private int EnterSecondMenu() {
        System.out.println("Second(0-59)");
        return TryParse(input.nextLine());
    }

    private int EnterHourMenu() {
        System.out.println("hour(0-23)");
        return TryParse(input.nextLine());
    }



    private void AddNewFlightMenu(){

        System.out.println("AddNewFlight");
        System.out.println("From");
        String from = input.nextLine();
        System.out.println("To");
        String to = input.nextLine();
        System.out.println("date");

        admin.AddFlight(from, to,new GregorianCalendar(EnterYearMenu(), EnterMonthMenu()-1
                        , EnterDayMenu(), EnterHourMenu(),  EnterMinuteMenu(), EnterSecondMenu()));
    }



    private void AdminMenu() {
            System.out.println("Enter number:\n1 - Add new flight\n"
                    + "2 - Delete flight\n3 - Info\n-1 - Exit");
            int tmp = TryParse(input.nextLine());
        switch (tmp) {
            case 1:
                AddNewFlightMenu();
                break;
            case 2:
                System.out.println("DeleteFlite");
                admin.Info();
                System.out.println("Enter index");
                int index = TryParse(input.nextLine());
                admin.DeleteFlight(index);
                break;
            case 3:
                admin.Info();
                break;
        }
    }

    private int TryParse(String string){
        int answer = 0;
        try {
            answer = Integer.parseInt(string);
        }catch (NumberFormatException e) {
            System.err.println("Wrong Format");
        }
        return answer;
    }

    private void MainMenu(){
        int tmp = 0;
        while (tmp != -1) {
            System.out.println("Enter number:\n1 "
                    +"- Go to administrator center\n"
                    +"2 - Go to Dispatcher center\n-1 - Exit");
            tmp = TryParse(input.nextLine());
            switch (tmp) {
                case 1:
                    AdminMenu();
                    break;
                case 2:
                    DispatcherMenu();
                    break;
            }
        }
    }

}

