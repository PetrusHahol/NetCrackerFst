package com.Exceptions;


import java.io.Serializable;

/**
 * Created by Asus on 18.10.2016.
 */
public class DataExceptions extends  Exception implements Serializable{

    public static final int LOWER_LENGTH_WAIST = 100;
    public static final int UPPER_LENGTH_WAIST = 100;
    public static final int LOWER_AGE = 25;
    public static final int UPPER_AGE = 55;
    public static final int LOWER_EXPERIENCE = 10;
    public static final int UPPER_EXPERIENCE = 40;
    public static final int LOWER_HEIGHT = 130;
    public static final int UPPER_HEIGHT = 210;
    public static final int LOWER_LANGUAGE = 5;
    public static final int UPPER_LANGUAGE = 25;
    public static final int LOWER_MILEAGE = 1000;
    public static final int UPPER_MILEAGE = 10000000;

    public DataExceptions(String message){
        super(message);
    }
    public DataExceptions(){
        super();
    }


}
