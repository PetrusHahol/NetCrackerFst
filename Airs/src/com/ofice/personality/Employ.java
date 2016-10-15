package com.ofice.personality;

import com.interfaces.EmploysInterface;

import java.util.Scanner;

/**
 * Created by Asus on 16.10.2016.
 */
public class Employ implements EmploysInterface {

    protected String name;
    protected int age;
    protected int height;
    protected int expirience;
    protected String pasporData;

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
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getHeight() {
        return this.height;
    }

    public int getExpirience() {
        return this.expirience;
    }

    public String getPasporData() {
        return this.pasporData;
    }

    public int hashCode() {
        final int PRIME = 43;
        int result = 1;
        int MOD = 1000000007;

        for (int i = 0; i < name.length(); i++){
            result = PRIME * result + name.charAt(i);
            result %= MOD;
        }

        for (int i = 0; i < pasporData.length(); i++){
            result = result * PRIME + pasporData.charAt(i);
            result %= MOD;
        }
        result = result * age+PRIME;
        result = result * expirience+PRIME;
        result = result * height+PRIME;
        return result;
    }

    public boolean equels(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

    public String toString(){
        return ("STEWARDESS Name " + name + " - Age - " + Integer.toString(age)
                +" - Height - " + Integer.toString(height)
                + " - Expirience - " + Integer.toString(expirience)
                + " - Pasport Data - " + pasporData + "\n");
    }

}
