package com.prashu.exceptions;

public class UserException extends Exception{

    public UserException(String msg) throws Exception {
        throw  new Exception(msg);
    }

}
