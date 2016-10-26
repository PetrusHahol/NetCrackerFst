package com.office;

/**
 * Created by Asus on 14.10.2016.
 */
public class Navigator<T> extends Employee {

    private T category;
    private static int objectsCounter;

    public Navigator(String name, int age, int height, int experience
            , String passportData, T category){
        setAge(age);
        setName(name);
        setHeight(height);
        setExperience(experience);
        setPassportData(passportData);
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
        result += name.hashCode() + passportData.hashCode() + category.hashCode();
        result += (result * age + PRIME) % MOD;
        result += (result * experience + PRIME) % MOD;
        result += (result * height + PRIME) % MOD;
        return result;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) {
                    return false;
        }
        Navigator temp =  (Navigator) obj;
        return (temp.name.equals(this.name) &&  temp.age == this.age
                && temp.height == this.height && temp.experience == this.experience
                && temp.passportData.equals(this.passportData) && temp.category.equals(this.category));
    }

    public T getCategory() {
        return category;
    }

    public void setCategory(T category) {
        this.category = category;
    }

    public static int getObjectsCounter() {
        return objectsCounter;
    }

    public static void setObjectsCounter(int objectsCounter) {
        Navigator.objectsCounter = objectsCounter;
    }
}
