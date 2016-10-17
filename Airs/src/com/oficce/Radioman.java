package com.oficce;

/**
 * Created by Asus on 14.10.2016.
 */
public class Radioman extends Employee {

    private int countForeignLanguage;
    private static int objectsCounter;

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
         result = result * countForeignLanguage +PRIME;
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

    public void setCountForeignLanguage(int countForeignLanguage) {
        this.countForeignLanguage = countForeignLanguage;
    }
}
