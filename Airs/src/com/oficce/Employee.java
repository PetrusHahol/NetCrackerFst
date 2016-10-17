package com.oficce;

/**
 * Created by Asus on 16.10.2016.
 */
public abstract class Employee {

    protected String name;
    protected int age;
    protected int height;
    protected int experience;
    protected String pasportData;
    private static int objectsCounter;

    public Employee(){
        objectsCounter++;
    }
    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public int getHeight() {
        return this.height;
    }

    public int getExperience() {
        return this.experience;
    }

    public String getPasportData() {
        return this.pasportData;
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

    public String toString(){
        return ("STEWARDESS Name " + name + " - Age - " + Integer.toString(age)
                +" - Height - " + Integer.toString(height)
                + " - Expirience - " + Integer.toString(experience)
                + " - Pasport Data - " + pasportData + "\n");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setPasportData(String pasportData) {
        this.pasportData = pasportData;
    }
}
