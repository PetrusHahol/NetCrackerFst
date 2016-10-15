package com.ofice.personality.profesions;

import com.ofice.personality.Employ;

import java.util.Scanner;

/**
 * Created by Asus on 14.10.2016.
 */
public class Pilot extends Employ {

  private int mileage;

    public Pilot(){

        setAge();

        setName();

        setHeight();

        setExperience();

        setPasportData();

        setMileage();
    }

    private void setMileage() {
        System.out.println("Add milage");
        Scanner in = new Scanner(System.in);
        this.mileage = in.nextInt();
    }

    public String toString(){
        return ("PILOT Name " + name + " - Age - " + Integer.toString(age)
                + " - Height - " + Integer.toString(height)
                + " - Expirience - " + Integer.toString(expirience)
                + " - Pasport Data - " + pasporData
                + " - Mileage - " + Integer.toString(mileage) + "\n");
    }


    public int getMileage() {
        return this.mileage;
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
        result = result * mileage+PRIME;
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
}
