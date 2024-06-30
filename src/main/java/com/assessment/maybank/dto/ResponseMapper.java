package com.assessment.maybank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter @Getter @AllArgsConstructor @NoArgsConstructor
public class ResponseMapper {
    HttpStatus httpStatus;
    String message;
    Object data;
}
