package com.ofice.personality.profesions;

import com.ofice.personality.Employ;

import java.util.Scanner;

/**
 * Created by Asus on 14.10.2016.
 */
public class Navigator extends Employ {

    private String category;

    public Navigator(){
        setAge();

        setName();

        setHeight();

        setExperience();

        setPasportData();

        setCategory();
    }

    private void setCategory() {
        System.out.println("Add Category");
        Scanner in = new Scanner(System.in);
        this.category = in.nextLine();
    }

    public String toString(){
        return ("NAVIGATOR Name " + name + " - Age - " + Integer.toString(age)
                + " - Height - " + Integer.toString(height)
                + " - Expirience - " + Integer.toString(expirience)
                + " - Pasport Data - " + pasporData
                + " - Category - " + category + "\n");
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
        for (int i = 0; i < category.length(); i++){
            result = result * PRIME + category.charAt(i);
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

    public String getCategory() {
        return category;
    }
}
