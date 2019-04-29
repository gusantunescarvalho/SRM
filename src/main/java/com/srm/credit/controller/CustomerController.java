package com.srm.credit.controller;

import com.srm.credit.entity.Customer;
import com.srm.credit.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

    private final CustomerRepository repository;

    @Autowired
    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable findAll() {
        return repository.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Customer create(@RequestBody Customer customer) {
        return repository.save(customer);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Customer customer) {
        repository.delete(customer);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public HttpEntity delete(@PathVariable Long id) {
        Optional<Customer> customer = repository.findById(id);
        repository.delete(customer.get());
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}