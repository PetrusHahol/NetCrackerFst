package com.ofice;

import java.util.Scanner;

/**
 * Created by Asus on 14.10.2016.
 */
public class Radiomen extends Employee {

    private int countForeignLenguage;

    public Radiomen(String name, int age, int height, int expirience
                   , String pasportData, int countForeignLenguage){

        setAge(age);

        setName(name);

        setHeight(height);

        setExperience(expirience);

        setPasportData(pasportData);

        setCountForeignLenguage(countForeignLenguage);
    }


     public String toString(){
        return ("RADIOMEN Name " + name + " - Age - " + Integer.toString(age)
                + " - Height - " + Integer.toString(height)
                + " - Expirience - " + Integer.toString(experience)
                + " - Pasport Data - " + pasportData
                + " - Count Foreign Lenguage - " + countForeignLenguage + "\n");
     }

     public int getCountForeignLenguage() {
        return this.countForeignLenguage;
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
         result = result * countForeignLenguage+PRIME;
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

    public void setCountForeignLenguage(int countForeignLenguage) {
        this.countForeignLenguage = countForeignLenguage;
    }
}
