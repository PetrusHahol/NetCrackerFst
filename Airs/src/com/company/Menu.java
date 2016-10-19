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

    private void Init(){
        admin.AddFlight("Minsk","Moskow",new GregorianCalendar(2016, 11, 18,22,23,22));
        admin.AddFlight("Minsk","Mogilev",new GregorianCalendar(2016, 10, 5,6,7));
        admin.AddFlight("Voronezh","Gomel",new GregorianCalendar(2017, 5, 5,6,40));
        admin.AddFlight("Minsk","Mars",new GregorianCalendar(2020, 9, 12,20,30,50));
        admin.AddFlight("Minsk","Mars",new GregorianCalendar(2020, 9, 12,20,30,50));
        dispatcher.AddNewPilot("Stas", 25, 160, 5, "KV185555", 550);
        dispatcher.AddNewStewardess("Stas", 25, 160, 5, "KV185555", 60);
        dispatcher.AddNewNavigator("Stas", 25, 160, 5, "KV185555", "First");
        dispatcher.AddNewRadioman("Stas", 25, 160, 5, "KV185555", 12);
    }

    private void SecondMenu(){
        int tmp = 0;
        Scanner input = new Scanner(System.in);

            if (tmp == 2) {
                System.out.println(" Enter number:\n1 - Add new employee\n2 - Add new brigade\n3 - Info\n-1 - Exit");
                try {
                    tmp = input.nextInt();
                }
                catch (InputMismatchException ex){
                    System.out.println("Try again ( 1 - 3 ) ");
                }
                if (tmp == 1) {
                    System.out.println(" Enter number:\n1 - Add new pilot\n2 - Add new radiomen"
                            + "\n3 - Add new navigator"
                            + "\n4 - Add new stewardess\n-1 - Exit");
                    try {
                        tmp = input.nextInt();
                    }
                    catch (InputMismatchException ex){
                        System.out.println("Try again ( 1 - 4 ) ");
                        input.nextLine();
                    }
                    input.nextLine();
                    System.out.println("Enter name");
                    String name = input.nextLine();
                    System.out.println("Enter age");
                    int age = 0;
                    int experience = 0;
                    String passportData = "";
                    int height = 0;

                    try {
                        age = input.nextInt();
                        if (age < 25 || age > 50) throw new CustomExceptions("Age needs to be between 25 and 50");
                        System.out.println("Enter Height");
                        height = input.nextInt();
                        if (height < 150 || height > 230) throw new CustomExceptions("Height needs to be between 150 and 230");
                        System.out.println("Enter Experience");
                        experience = input.nextInt();
                        if (experience < 2 || experience > 20) throw new CustomExceptions("Experience needs to be between 2 and 20");
                        input.nextLine();
                        System.out.println("Enter Passport Data");
                        passportData = input.nextLine();
                    } catch (InputMismatchException ex) {
                        System.out.println("Try again, height, age, experience must be integer");
                        input.nextLine();
                        tmp = 0;
                    } catch (CustomExceptions ex) {
                        System.out.println(ex.getMessage());
                        tmp = 0;
                    }
                    if (tmp == 1){
                        System.out.println("Enter mileage");
                        int mileage = 0;
                        try {
                            mileage = input.nextInt();
                            dispatcher.AddNewPilot(name, age, height, experience, passportData, mileage);
                        }
                        catch (InputMismatchException ex){
                            System.out.println("Try again, mileage must be integer");
                            input.nextLine();
                        }

                    }
                    if (tmp == 2) {
                        System.out.println("Enter count foreign language");
                        int countForeignLanguage = 0;
                        try {
                            countForeignLanguage = input.nextInt();
                            dispatcher.AddNewRadioman(name, age, height, experience
                                    , passportData, countForeignLanguage);

                        }catch (InputMismatchException ex){
                            System.out.println("Try again, count foreign language must be integer");
                        }
                    }

                    if (tmp == 3){
                        System.out.println("Enter category");
                        input.nextLine();
                        String category = input.nextLine();
                        dispatcher.AddNewNavigator(name, age, height, experience, passportData, category);
                    }

                    if (tmp == 4) {
                        System.out.println("Enter length waist");
                        int lengthWaist = 0;
                        try {
                            lengthWaist = input.nextInt();
                            dispatcher.AddNewStewardess(name, age, height, experience, passportData, lengthWaist);
                        } catch (InputMismatchException ex) {
                            System.out.println("Try again, length waist must be integer");
                        }

                    }
                }
            }

            if (tmp == 3) {
                dispatcher.Info();
            }
            if (tmp == 2 ){
                try {
                    dispatcher.AddBrigade(admin);
                }catch (CustomExceptions ex){
                    System.out.println(ex.getMessage());
                }
            }
        }

    private int EnterYearMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Year(2016-2020)");
        return TryParse(input.nextLine());
    }


    private int EnterMonthMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Month(1-12)");
        return TryParse(input.nextLine());
    }

    private int EnterDayMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Day(1-31(30))");
        return TryParse(input.nextLine());
    }
    private int EnterMinuteMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Minute (0-59)");
        return TryParse(input.nextLine());
    }

    private int EnterSecondMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("Second(0-59)");
        return TryParse(input.nextLine());
    }

    private int EnterHourMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("hour(0-23)");
        return TryParse(input.nextLine());
    }



    private void AddNewFlightMenu(){

        Scanner input = new Scanner(System.in);
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
            Scanner input = new Scanner(System.in);
            System.out.println("Enter number:\n1 - Add new flight\n"
                    + "2 - Delete flight\n3 - Info\n-1 - Exit");
            int tmp = TryParse(input.nextLine());
            if (tmp == 1) {
                AddNewFlightMenu();
            }

            if (tmp == 2) {
                System.out.println("DeleteFlite");
                admin.Info();
                System.out.println("Enter index");
                try {
                    int index = input.nextInt();
                    admin.DeleteFlight(index);
                } catch (InputMismatchException ex) {
                    System.out.println("Try again ");
                }
            }
            if (tmp == 3) {
                admin.Info();
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
        Scanner input = new Scanner(System.in);
        int tmp = 0;

        while (tmp != -1) {
            System.out.println("Enter number:\n1 "
                    +"- Go to administrator center\n"
                    +"2 - Go to Dispatcher center\n-1 - Exit");
            tmp = TryParse(input.nextLine());
            if (tmp == 1 ) {
                AdminMenu();
            }
        }
    }


    private Admin admin = new Admin();
    private Dispatcher dispatcher = new Dispatcher();

    public Menu()  {
        Init();
        MainMenu();
    }
}

