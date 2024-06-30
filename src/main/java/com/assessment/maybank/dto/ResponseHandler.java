package com.assessment.maybank.dto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {

    public static ResponseEntity<ResponseMapper> responseBuilder(String msg, HttpStatus httpStatus, Object data){
            return new ResponseEntity<>(new ResponseMapper(httpStatus,msg,data),httpStatus);
    }
}
