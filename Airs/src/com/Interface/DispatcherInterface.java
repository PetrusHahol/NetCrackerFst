package com.Interface;

/**
 * Created by Asus on 17.10.2016.
 */
public interface DispatcherInterface {

    void AddNewRadioman(String name, int age, int height, int experience
            , String passportData, int countForeignLanguage);

    void AddNewStewardess(String name, int age, int height, int experience
            , String passportData, int lengthWaist);

    void AddNewNavigator(String name, int age, int height, int experience
            , String passportData, String category);

    void AddNewNavigator(String name, int age, int height, int experience
            , String passportData, int category);

    void AddNewPilot(String name, int age, int height, int experience
            , String passportData, int mileage);
}