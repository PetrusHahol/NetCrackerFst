package Ofice;

import Interfaces.AboutOficer;

import java.util.Scanner;

/**
 * Created by Asus on 14.10.2016.
 */
public class Pilot implements AboutOficer {

    private String name;
    private int age;
    private int height;
    private int expirience;
    private String pasporData;

    public Pilot(){

        getAge();

        getName();

        getHeight();

        getExperience();

        getPasportData();

    }

    public String toString(){
        return ("PILOT Name " + name + " - Age - " + Integer.toString(age)
                + " - Height - " + Integer.toString(height)
                + " - Expirience - " + Integer.toString(expirience)
                + " - Pasport Data - "+pasporData + "\n");
    }

    @Override
    public void getName() {
        System.out.println("Add name");
        Scanner in = new Scanner(System.in);
        this.name = in.nextLine();
    }

    @Override
    public void getAge() {
        System.out.println("Add age");
        Scanner in = new Scanner(System.in);
        this.age = in.nextInt();
    }

    @Override
    public void getHeight() {
        System.out.println("Add Height");
        Scanner in = new Scanner(System.in);
        this.height = in.nextInt();
    }

    @Override
    public void getExperience() {
        System.out.println("Add Expirience");
        Scanner in = new Scanner(System.in);
        this.expirience = in.nextInt();
    }

    @Override
    public void getPasportData() {
        System.out.println("Add Pasport Data");
        Scanner in = new Scanner(System.in);
        this.pasporData = in.nextLine();
    }
}
