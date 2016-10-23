package com.Interface;

/**
 * Created by Asus on 17.10.2016.
 */
public interface DispatcherInterface {

    public  void AddNewRadioman(String name, int age, int height, int experience
            , String passportData, int countForeignLanguage);

    public  void AddNewStewardess(String name, int age, int height, int experience
            , String passportData, int lengthWaist);

    public void AddNewNavigator(String name, int age, int height, int experience
            , String passportData, String category);

    public void AddNewNavigator(String name, int age, int height, int experience
            , String passportData, int category);

    public void AddNewPilot(String name, int age, int height, int experience
            , String passportData, int mileage);
}