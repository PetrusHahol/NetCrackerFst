package Ofice;

import Interfaces.AboutOficer;

import java.util.Scanner;

/**
 * Created by Asus on 14.10.2016.
 */
public class Stewardess implements AboutOficer {

    private String name;
    private int age;
    private int height;
    private int expirience;
    private String pasporData;

    public Stewardess(){

        setAge();

        setName();

        setHeight();


        setExperience();

        setPasportData();

    }

    public String toString(){
        return ("STEWARDESS Name " + name + " - Age - " + Integer.toString(age)
                +" - Height - " + Integer.toString(height)
                + " - Expirience - " + Integer.toString(expirience)
                +" - Pasport Data - "+pasporData+"\n");
    }

    @Override
    public void setName() {
        System.out.println("Add name");
        Scanner in = new Scanner(System.in);
        this.name = in.nextLine();
    }

    @Override
    public void setAge() {
        System.out.println("Add age");
        Scanner in = new Scanner(System.in);
        this.age = in.nextInt();
    }

    @Override
    public void setHeight() {
        System.out.println("Add Height");
        Scanner in = new Scanner(System.in);
        this.height = in.nextInt();
    }

    @Override
    public void setExperience() {
        System.out.println("Add Expirience");
        Scanner in = new Scanner(System.in);
        this.expirience = in.nextInt();
    }

    @Override
    public void setPasportData() {
        System.out.println("Add Pasport Data");
        Scanner in = new Scanner(System.in);
        this.pasporData = in.nextLine();
    }
}
