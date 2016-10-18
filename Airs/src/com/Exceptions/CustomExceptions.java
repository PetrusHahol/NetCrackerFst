package com.Exceptions;

/**
 * Created by Asus on 18.10.2016.
 */
public class CustomExceptions {

    public static class BrigadeCreateException extends Exception {

        public BrigadeCreateException(String message){
            super(message);
        }

        public String getMessage(){
            return "To add a team, you need at least one employee of each specialty and necessarily two pilots";
        }


    }


/*
    public class  extends Exception {
        public BrigadeCreateException(String message){
            super(message);
        }

    }
  */
}
