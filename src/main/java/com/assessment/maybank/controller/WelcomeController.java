package com.assessment.maybank.controller;

import com.assessment.maybank.dto.ResponseHandler;
import com.assessment.maybank.dto.ResponseMapper;
import com.assessment.maybank.model.Customer;
import com.assessment.maybank.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Tag(name = "Welcome", description = "Welcome API")
@RequestMapping("/welcome")
public class WelcomeController {
    //ttest
    Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @Autowired
    CustomerService customerService;

    @Operation(description = "Api is working and insert dummy data")
    @RequestMapping(value = "/index" , method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<ResponseMapper> greeting() {
        List<Customer> customerLists = new ArrayList<>();
        customerLists.add(new Customer(null,"Raihan","Razali"));
        customerLists.add(new Customer(null,"John","John"));
        customerLists.add(new Customer(null,"Hanz","Abd"));
        customerLists.add(new Customer(null,"Ali","Abu"));
        customerLists.add(new Customer(null,"Gibran","St"));
        customerLists.add(new Customer(null,"Jr","Wls"));
        customerService.saveAll(customerLists);
        return ResponseHandler.responseBuilder("Hello World!",HttpStatus.OK, customerLists);
    }

}
