package com.link.generator.system.link.generator.system.controller;

import com.link.generator.system.link.generator.system.model.Customer;
import com.link.generator.system.link.generator.system.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/customer")
public class CustomerController {
    private final CustomerService customerService;
    @PostMapping("/register")
    public ResponseEntity<String> registerCustomer(@Valid @RequestBody Customer aCustomer, BindingResult bindResult)
    {
        System.out.println("ERRORS: " + bindResult.hasErrors());
        if (bindResult.hasErrors())
        {
            System.err.println("Error Found");
            return ResponseEntity.badRequest().body(bindResult.getFieldErrors().get(0).getDefaultMessage());
        }

        Customer savedCustomer = customerService.saveCustomerDetails(aCustomer);

        if(savedCustomer != null)
        {
            return new ResponseEntity<String> ("Customer Successfully Registered, customer ID: " + savedCustomer.getCustomerId(), HttpStatus.CREATED);
        }

        return new ResponseEntity<String> ("Customer Registration Failed", HttpStatus.FAILED_DEPENDENCY);
    }

}

