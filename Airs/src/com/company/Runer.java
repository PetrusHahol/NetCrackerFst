package com.company;

import com.administrators.Admin;
import com.administrators.Dispatcher;

import java.util.Scanner;

/**
 * Created by Asus on 14.10.2016.
 */
public  class Runer {

    private Admin admin = new Admin();
    private Dispatcher dispatcher = new Dispatcher();

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
                    Scanner in = new Scanner(System.in);
                    System.out.println("AddNewFlite");
                    System.out.println("From");
                    String from = in.nextLine();
                    System.out.println("To");
                    String to = in.nextLine();
                    System.out.println("date");
                    String date = in.nextLine();
                    admin.AddFlight(from, to, date);
                }
                if (tmp == 2){
                    Scanner in = new Scanner(System.in);
                    System.out.println("AddNewFlite");
                    System.out.println("From");
                    String from = in.nextLine();
                    System.out.println("To");
                    String to = in.nextLine();
                    System.out.println("date");
                    String date = in.nextLine();
                    admin.DeleteFlight(from, to , date);
                }
                if (tmp == 3) {
                    admin.Info();
                }
            } else
                if (tmp == 2) {
                    System.out.println(" Enter number:\n1 - Add new employee\n2 - Add new brigade\n3 - Info\n-1 - Exit");
                    tmp = input.nextInt();
                    if (tmp == 1) {
                        System.out.println(" Enter number:\n1 - Add new pilot\n2 - Add new radiomen"
                                + "\n3 - Add new navigator"
                                + "\n4 - Add new Stewardess\n-1 - Exit");

                        tmp = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter name");
                        String name = input.nextLine();
                        System.out.println("Enter age");
                        int age = input.nextInt();
                        System.out.println("Enter Height");
                        int height = input.nextInt();
                        System.out.println("Enter Expirience");
                        int expirience = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter Pasport Data");
                        String pasoprtData = input.nextLine();

                        if (tmp == 1) {
                            System.out.println("Enter mileage");
                            int mileage = input.nextInt();
                            dispatcher.AddNewPilot(name, age, height, expirience, pasoprtData, mileage);
                        }
                        if (tmp == 2) {
                            System.out.println("Enter count foreign lenguage");
                            int countForeignLenguage = input.nextInt();
                            dispatcher.AddNewRadioman(name, age, height, expirience, pasoprtData, countForeignLenguage);
                        }
                        if (tmp == 3) {
                            System.out.println("Enter category");
                            input.nextLine();
                            String category = input.nextLine();
                            dispatcher.AddNewNavigator(name, age, height, expirience, pasoprtData, category);
                        }
                        if (tmp == 4) {
                            System.out.println("Enter length waist");
                            int lengthWaist = input.nextInt();
                            dispatcher.AddNewStewardess(name, age, height, expirience, pasoprtData, lengthWaist);
                        }
                    }
                    if (tmp == 3) {
                        dispatcher.Info();
                    }
                    if (tmp == 2 ){
                        dispatcher.AddBrigade(admin);
                    }
                }
        }
    }



}

