package com.office;

/**
 * Created by Asus on 14.10.2016.
 */
public class Radioman extends Employee {

    private int countForeignLanguage;
    public static int objectsCounter;

    public Radioman(){
        objectsCounter++;
    }

    public Radioman(String name, int age, int height, int experience
                   , String passportData, int countForeignLanguage){

        setAge(age);

        setName(name);

        setHeight(height);

        setExperience(experience);

        setPassportData(passportData);

        setCountForeignLanguage(countForeignLanguage);

        objectsCounter++;
    }


    @Override
    public String toString(){
        return ("RADIOMEN Name " + name + " - Age - " + Integer.toString(age)
                + " - Height - " + Integer.toString(height)
                + " - Experience - " + Integer.toString(experience)
                + " - Passport Data - " + passportData
                + " - Count Foreign Language - " + countForeignLanguage + "\n");
     }

     public int getCountForeignLanguage() {
        return this.countForeignLanguage;
    }

    @Override
    public int hashCode() {
         final int PRIME = 43;
         int result = 1;
         int MOD = 1000000007;

         result += name.hashCode() + passportData.hashCode();
         result += (result * age+PRIME) % MOD;
         result += (result * experience + PRIME) % MOD;
         result += (result * height + PRIME) % MOD;
         result += (result * countForeignLanguage + PRIME) % MOD;
         return result;
     }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) {
            return false;
        }
        return true;
    }

    public void setCountForeignLanguage(int countForeignLanguage) {
        this.countForeignLanguage = countForeignLanguage;
    }
}
