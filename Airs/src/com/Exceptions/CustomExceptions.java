package com.Exceptions;


/**
 * Created by Asus on 18.10.2016.
 */
public class CustomExceptions extends  Exception{

    public CustomExceptions(String message){
        super(message);
    }

    public CustomExceptions(){
        super();
    }

    public int getYear() {
        return 0;
    }

    public int getMonth() {
        return 0;
    }

    public int getDay() {
        return 0;
    }

    public int getHour() {
        return 0;
    }

    public int getMinute() {
        return 0;
    }

    public int getSecond() {
        return 0;
    }
}
