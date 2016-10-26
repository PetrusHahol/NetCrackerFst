package com.menu;

import com.administrators.Admin;
import com.initialization.FlightInit;
import com.tools.Constants;
import com.tools.Utilities;

import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Created by Asus on 27.10.2016.
 */
public class AdminMenu {
    private Admin admin = new Admin();
    private Utilities utility = new Utilities();
    private static Scanner input = new Scanner(System.in);

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public AdminMenu(){
        admin =  new FlightInit().getAdmin();
    }

    private  void addNewFlightMenu(){
        System.out.println("AddNewFlight");
        System.out.println("From");
        String from = input.nextLine();
        System.out.println("To");
        String to = input.nextLine();
        System.out.println("date");

        admin.addFlight(from, to, new GregorianCalendar(enterYear(), enterMonth()-1
                , enterDay(), enterHour(),  enterMinute(), enterSecond()));
    }

    private  int enterYear() {
        return utility.handler("Year", Constants.LOWER_YEAR, Constants.UPPER_YEAR);
    }

    private  int enterMonth() {
        return utility.handler("Month", Constants.LOWER_MONTH, Constants.UPPER_MONTH);
    }

    private  int enterDay() {
        return utility.handler("Day", Constants.LOWER_DAY, Constants.UPPER_DAY);
    }

    private  int enterMinute() {
        return utility.handler("Minute", Constants.LOWER_MINUTE, Constants.UPPER_MINUTE);
    }

    private  int enterSecond() {
        return utility.handler("Second", Constants.LOWER_SECOND, Constants.UPPER_SECOND);
    }

    private  int enterHour() {
        return utility.handler("Hour", Constants.LOWER_HOUR, Constants.UPPER_HOUR);
    }


    public void main() {
        boolean flag = true;
        while (flag) {
            System.out.println("Enter number:\n1 - Add new flight\n"
                    + "2 - Delete flight\n3 - Info\n4 - Download flights from BD\n"
                    + "5 - Rewrite flights in BD\n6 - Serialization\n -1 - Back");
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
                case 6:
                    admin.serialization();
                    break;
                case -1:
                    flag = false;
                    break;
            }
        }
    }


}
