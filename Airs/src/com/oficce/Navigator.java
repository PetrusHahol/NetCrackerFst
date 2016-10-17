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

        setPasportData(pasportData);

        setCategory(category);

        objectsCounter++;
    }

    public String toString(){
        return ("NAVIGATOR Name " + name + " - Age - " + Integer.toString(age)
                + " - Height - " + Integer.toString(height)
                + " - Expirience - " + Integer.toString(experience)
                + " - Pasport Data - " + pasportData
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

        for (int i = 0; i < pasportData.length(); i++){
            result = result * PRIME + pasportData.charAt(i);
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

    public boolean equals(Object obj){
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

    public void setCategory(String category) {
        this.category = category;
    }
}
