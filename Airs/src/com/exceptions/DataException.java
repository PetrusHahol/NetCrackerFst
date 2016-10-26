package com.exceptions;


import java.io.Serializable;

public class DataException extends  Exception {

    public DataException(String message){
        super(message);
    }

}