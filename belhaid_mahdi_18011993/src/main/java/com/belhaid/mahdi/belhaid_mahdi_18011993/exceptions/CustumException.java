package com.belhaid.mahdi.belhaid_mahdi_18011993.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CustumException extends RuntimeException{

    public CustumException(){
        super();
    }

    public CustumException(String message){
        super(message);
    }
    public CustumException(String message,Throwable cause){
        super(message, cause);
    }
    public CustumException(Throwable cause){
        super(cause);
    }
}
