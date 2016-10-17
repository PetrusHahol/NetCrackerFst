package com.oficce;

/**
 * Created by Asus on 14.10.2016.
 */
public class Pilot extends Employee {


    private int mileage;
    private static int objectsCounter;

    public Pilot(String name, int age, int height, int experience
            , String passportData, int mileage){

        setAge(age);

        setName(name);

        setHeight(height);

        setExperience(experience);

        setPassportData(passportData);

        setMileage(mileage);

        objectsCounter++;

    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String toString(){
        return ("PILOT Name " + name + " - Age - " + Integer.toString(age)
                + " - Height - " + Integer.toString(height)
                + " - Experience - " + Integer.toString(experience)
                + " - Passport Data - " + passportData
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

        for (int i = 0; i < passportData.length(); i++){
            result = result * PRIME + passportData.charAt(i);
            result %= MOD;
        }
        result = result * age+PRIME;
        result = result * experience +PRIME;
        result = result * height+PRIME;
        result = result * mileage+PRIME;
        return result;
    }

    public boolean equals(Object obj){
        if (this == obj) return true; else
            if (obj == null) return false; else
                if (getClass() != obj.getClass()) {
                    return false;
                }
        return true;
    }
}
