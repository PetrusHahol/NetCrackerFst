package com.oficce;

/**
 * Created by Asus on 14.10.2016.
 */
public class Pilot extends Employee {


    private int mileage;
    private static int objectsCounter;

    public Pilot(String name, int age, int height, int expirience
            , String pasportData, int mileage){

        setAge(age);

        setName(name);

        setHeight(height);

        setExperience(expirience);

        setPasportData(pasportData);

        setMileage(mileage);

        objectsCounter++;

    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public String toString(){
        return ("PILOT Name " + name + " - Age - " + Integer.toString(age)
                + " - Height - " + Integer.toString(height)
                + " - Expirience - " + Integer.toString(experience)
                + " - Pasport Data - " + pasportData
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

        for (int i = 0; i < pasportData.length(); i++){
            result = result * PRIME + pasportData.charAt(i);
            result %= MOD;
        }
        result = result * age+PRIME;
        result = result * experience +PRIME;
        result = result * height+PRIME;
        result = result * mileage+PRIME;
        return result;
    }

    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }
}
