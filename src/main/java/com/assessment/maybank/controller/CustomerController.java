package com.assessment.maybank.controller;

import com.assessment.maybank.dto.ResponseHandler;
import com.assessment.maybank.dto.ResponseMapper;
import com.assessment.maybank.model.Customer;
import com.assessment.maybank.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/customer")
@Tag(name = "Customer", description = "Customer API")
public class CustomerController {


    @Autowired
    private CustomerService customerService;

    @Operation(summary = "To Get Customer" , description = "To get all Customer by pageNo and pageSize")
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<ResponseMapper> findAll(@RequestParam(value = "pageNo",defaultValue = "0",required = true) int pageNo,
                                                                @RequestParam(value = "pageSize",defaultValue = "10",required = true) int pageSize) {
        try {
            return ResponseHandler.responseBuilder("findAll", HttpStatus.OK, customerService.findAll(pageNo,pageSize));
        }catch (Exception e){
            return ResponseHandler.responseBuilder(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @Operation(summary = "To Get Customer By Id" , description = "To get customer data by send customer id")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<ResponseMapper> findById(@PathVariable Long id) {
        try {
            return ResponseHandler.responseBuilder("findById", HttpStatus.OK, customerService.findById(id));
        }catch (Exception e){
            return ResponseHandler.responseBuilder(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @Operation(summary = "To Delete Customer" , description = "To force delete customer data by send customer id")
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public @ResponseBody ResponseEntity<ResponseMapper> delete(@PathVariable Long id) {
        try {
            customerService.delete(id);
            return ResponseHandler.responseBuilder("delete success", HttpStatus.OK, null);
        }catch (Exception e){
            return ResponseHandler.responseBuilder(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @Operation(summary = "Insert and Update Customer data" , description = "To Insert and update customer")
    @RequestMapping(value = "/",method = RequestMethod.PUT)
    public @ResponseBody ResponseEntity<ResponseMapper> saveCustomer(@RequestBody Customer customer) {
        try {
            return ResponseHandler.responseBuilder("saveCustomer", HttpStatus.OK, customerService.save(customer));
        }catch (Exception e){
            return ResponseHandler.responseBuilder(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }

    @Operation(summary = "Insert and Update Customer data" , description = "To Insert and update customer")
    @RequestMapping(value = "/screen/{id}",method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<ResponseMapper> screenCustomer(@PathVariable Long id) {
        try {
            return ResponseHandler.responseBuilder("screen id " + id, HttpStatus.OK, customerService.screen(id));
        }catch (Exception e){
            return ResponseHandler.responseBuilder(e.getMessage(), HttpStatus.BAD_REQUEST, null);
        }
    }


}
