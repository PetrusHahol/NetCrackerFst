package com.oficce;

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
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        else
            if (obj == null) return false;
            else
                if (getClass() != obj.getClass());
        return true;
    }

    public int getLengthWaist() {
        return this.lengthWaist;
    }

    public void setLengthWaist(int lengthWaist) {
        this.lengthWaist = lengthWaist;
    }
}
