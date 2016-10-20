package com.Exceptions;


import java.io.Serializable;

/**
 * Created by Asus on 18.10.2016.
 */
public class CustomExceptions extends  Exception implements Serializable{

    public CustomExceptions(String message){
        super(message);
    }

    public CustomExceptions(){
        super();
    }


}
