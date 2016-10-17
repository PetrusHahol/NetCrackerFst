package com.oficce;

/**
 * Created by Asus on 14.10.2016.
 */
public class Navigator extends Employee {

    private String category;
    private static int objectsCounter;

    public Navigator(String name, int age, int height, int expirience
            , String pasportData, String category){

        setAge(age);

        setName(name);

        setHeight(height);

        setExperience(expirience);

        setPassportData(pasportData);

        setCategory(category);

        objectsCounter++;
    }

    @Override
    public String toString(){
        return ("NAVIGATOR Name " + name + " - Age - " + Integer.toString(age)
                + " - Height - " + Integer.toString(height)
                + " - Experience - " + Integer.toString(experience)
                + " - Passport Data - " + passportData
                + " - Category - " + category + "\n");
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
        for (int i = 0; i < category.length(); i++){
            result = result * PRIME + category.charAt(i);
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
                if (getClass() != obj.getClass()) {
                    return false;
                }
        return true;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
