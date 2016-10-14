package com.company;

import Administrator.Admin;
import Company.Flights;

import java.util.Scanner;

/**
 * Created by Asus on 14.10.2016.
 */
public  class Runer {
    public Runer()
    {   int tmp = 0;
        Admin fst = new Admin();
        Scanner input = new Scanner(System.in);
        while (tmp != -1) {
            System.out.println("Enter number:\n1 - Go to administraton center\n2 - Go to second\n-1 - Exit");
            tmp = input.nextInt();
            if (tmp == 1) {
                System.out.println("Enter number:\n1 - Add new flight\n2 - Delete flight\n3 - Info\n-1 - Exit");
                tmp = input.nextInt();
                if (tmp == 1) {
                    fst.AddFlight();
                }
                if (tmp == 2){
                    fst.DeleteFlight();
                }
                if (tmp == 4) {
                    fst.Info();
                }
            }
        }
    }
}

