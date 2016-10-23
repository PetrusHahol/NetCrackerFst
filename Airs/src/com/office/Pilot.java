package com.office;

/**
 * Created by Asus on 14.10.2016.
 */
public class Pilot extends Employee {


    private int mileage;
    public static int objectsCounter;

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

    @Override
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

    @Override
    public int hashCode() {
        final int PRIME = 43;
        int result = 1;
        int MOD = 1000000007;

        result += name.hashCode() + passportData.hashCode();
        result += (result * age + PRIME) % MOD;
        result += (result * experience + PRIME) % MOD;
        result += (result * height + PRIME) % MOD;
        result += (result * mileage + PRIME) % MOD;
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass())
            return false;
        Pilot temp =  (Pilot) obj;
        return (temp.name.equals(this.name) ||  temp.age == this.age
                || temp.height == this.height || temp.experience == this.experience
                || temp.passportData.equals(this.passportData) || temp.mileage == this.mileage);
    }
}
