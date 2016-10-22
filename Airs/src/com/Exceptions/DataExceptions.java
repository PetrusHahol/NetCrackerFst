package com.Exceptions;


import java.io.Serializable;

/**
 * Created by Asus on 18.10.2016.
 */
public class DataExceptions extends  Exception implements Serializable{


    public DataExceptions(String message){
        super(message);
    }
    public DataExceptions(){
        super();
    }


}
