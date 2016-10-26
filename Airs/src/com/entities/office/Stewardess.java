package com.entities.office;

/**
 * Created by Asus on 14.10.2016.
 */
public class Stewardess extends Employee {

    private int lengthWaist;

    private static int objectsCounter;

    public Stewardess(){
        objectsCounter++;
    }

    public Stewardess(String name, int age, int height, int experience
            , String passportData, int lengthWaist){

        setAge(age);
        setName(name);
        setHeight(height);
        setExperience(experience);
        setPassportData(passportData);
        setLengthWaist(lengthWaist);
        objectsCounter++;
    }

    @Override
    public String toString(){
        return ("STEWARDESS Name " + name + " - Age - " + Integer.toString(age)
                +" - Height - " + Integer.toString(height)
                + " - Experience - " + Integer.toString(experience)
                + " - Passport Data - " + passportData
                + " - LengthWaist - " + lengthWaist + "\n");
    }

    @Override
    public int hashCode() {
        final int PRIME = 43;
        int result = 1;
        int MOD = 1000000007;
        result += name.hashCode() + passportData.hashCode();
        result += (result * age+PRIME) % MOD;
        result += (result * experience +PRIME) % MOD;
        result += (result * height+PRIME) % MOD;
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return true;
        Stewardess temp =  (Stewardess) obj;
        return (temp.name.equals(this.name) &&  temp.age == this.age
                && temp.height == this.height && temp.experience == this.experience
                && temp.passportData.equals(this.passportData) && temp.lengthWaist == this.lengthWaist);
    }

    public int getLengthWaist() {
        return this.lengthWaist;
    }

    public void setLengthWaist(int lengthWaist) {
        this.lengthWaist = lengthWaist;
    }

    public static int getObjectsCounter() {
        return objectsCounter;
    }

    public static void setObjectsCounter(int objectsCounter) {
        Stewardess.objectsCounter = objectsCounter;
    }
}
